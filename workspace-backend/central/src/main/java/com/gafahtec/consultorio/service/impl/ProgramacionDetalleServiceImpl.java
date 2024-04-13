package com.gafahtec.consultorio.service.impl;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.dto.request.ProgramacionRequest;
import com.gafahtec.consultorio.model.Empleado;
import com.gafahtec.consultorio.model.Programacion;
import com.gafahtec.consultorio.model.ProgramacionDetalle;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.repository.IProgramacionDetalleRepository;
import com.gafahtec.consultorio.service.IProgramacionDetalleService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class ProgramacionDetalleServiceImpl extends CRUDImpl<ProgramacionDetalle, Integer>
        implements IProgramacionDetalleService {

    private IProgramacionDetalleRepository repo;

    @Override
    protected IGenericRepository<ProgramacionDetalle, Integer> getRepo() {

        return repo;
    }

    public List<ProgramacionDetalle> generarProgramacionDetalle(Programacion programacion,
            ProgramacionRequest programacionRequest) {

        List<ProgramacionDetalle> list = new ArrayList();
        try {
            list = generarProgramacion(programacion, programacionRequest);

        } catch (ParseException e) {
            log.info("msg", "Se producjo un problema al generar horario");
            log.error("error", e);

        }

        return list;

    }

    @Override
    public List<ProgramacionDetalle> generarProgramacion(Programacion programacion,
            ProgramacionRequest programacionRequest) throws ParseException {

        LocalDate startLocalDate = programacion.getFechaInicial().toInstant().atZone(ZoneId.systemDefault())
                .toLocalDate();
        System.out.println("startLocalDate "+startLocalDate);
        LocalDate endLocalDate = programacion.getFechaFinal().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("endLocalDate "+endLocalDate);
        
        List<ProgramacionDetalle> programacionDetalleList = new ArrayList<>();

        for (String dia : programacionRequest.getChecked()) {
            LocalDate diaProgramado = startLocalDate.plusDays(Integer.parseInt(dia));
            DayOfWeek dayOfWeek = diaProgramado.getDayOfWeek();

            ProgramacionDetalle programacionDetalle = getRepo().save(ProgramacionDetalle.builder()
                    .programacion(programacion)
                    .fecha(diaProgramado).diaSemana(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault()))
                    .numeroDiaSemana(dayOfWeek.getValue())
                    .empleado(Empleado.builder().idEmpleado(programacionRequest.getIdMedico()).build())
                    .estado(0)
                    .build());

            log.info("Resultado", programacionDetalle);
            programacionDetalleList.add(programacionDetalle);
        }

        return programacionDetalleList;
    }

    @Override
    public List<ProgramacionDetalle> generarDiasProgramados(Integer idMedico) throws ParseException {
        // TODO Auto-generated method stub
        return repo.findByEmpleadoAndPendiente(idMedico, 0);
    }
    
    public List<ProgramacionDetalle> getProgramacionMedico(Integer idProgramacion, Integer idMedico){
        
        return repo.getProgramacionMedico(idProgramacion, idMedico);
    }

    @Transactional
    @Override
    public List<ProgramacionDetalle> programacionDias(Integer estado) {
        
         return repo.findByEstado(estado);
    }

    @Override
    public List<ProgramacionDetalle> verificaProgramacion(Integer idMedico, String fechaInicial, String fechaFinal) {
        return  repo.verificaProgramacion( idMedico,  fechaInicial,  fechaFinal);
        
        
    }
    
    
}
