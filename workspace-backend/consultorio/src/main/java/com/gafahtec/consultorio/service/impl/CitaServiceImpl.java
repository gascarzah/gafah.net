package com.gafahtec.consultorio.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.exception.ResourceNotFoundException;
import com.gafahtec.consultorio.model.Cita;
import com.gafahtec.consultorio.model.Cliente;
import com.gafahtec.consultorio.model.Cupo;
import com.gafahtec.consultorio.model.ProgramacionDetalle;
import com.gafahtec.consultorio.repository.ICitaRepository;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.service.ICitaService;
import com.gafahtec.consultorio.service.ICupoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CitaServiceImpl extends CRUDImpl<Cita, Integer> implements ICitaService {

    private ICitaRepository repo;

    private ICupoService iCupoService;

    @Override
    protected IGenericRepository<Cita, Integer> getRepo() {

        return repo;
    }

    @Override
    public Page<Cita> listarPageable(Pageable pageable) throws ResourceNotFoundException{
        return repo.findAll(pageable);
    }

    public void registrarCupos(List<ProgramacionDetalle> list) {

       
            List<Cupo> cupos = iCupoService.listar();

            for (ProgramacionDetalle programacionDetalle : list) {

                for (Cupo cupo : cupos) {

                    repo.save(Cita.builder()
                            .programacionDetalle(programacionDetalle)
                            .cupo(cupo)
                            .atendido(0)
                            .build());
                }

            }

        

    }

    @Override
    public List<Cita> listarCitas(Integer idProgramacionDetalle) {
        // TODO Auto-generated method stub
        return repo.findByProgramacionDetalleOrderByCita(idProgramacionDetalle);
    }

    @Transactional
    @Override
    public Integer eliminar(Integer idCita, Integer idCupo, Integer idProgramacionDetalle) {
        // TODO Auto-generated method stub
        return repo.eliminar(idCita, idCupo, idProgramacionDetalle);
    }

    @Transactional
    @Override
    public Integer updateAtencion(Integer idCita) {
        // TODO Auto-generated method stub
        return repo.updateAtencion(idCita);
    }

    @Override
    public List<Cita> listaCitados(Integer idMedico, Integer numeroDiaSemana) {
        // TODO Auto-generated method stub
        return repo.listaCitados(idMedico,  numeroDiaSemana);
    }

    @Override
    public List<Cita> listaHistorialCitaCliente(Integer idCliente) {
        // TODO Auto-generated method stub
        return repo.listaHistorialCitaCliente(idCliente);
//        return repo.findByCliente(Cliente.builder().idCliente(idCliente).build());
    }

    @Override
    public Page<Cita> listaHistorialCitaCliente(Integer idCliente, Pageable paging) {
        // TODO Auto-generated method stub
//        return repo.findByClienteNoAtendidos(Cliente.builder().idCliente(idCliente).build(), paging);
        return repo.findByClienteNoAtendidos(idCliente, paging);
    }

    @Override
    public List<Cita> listarNoAtendidos(Integer idProgramacionDetalle,Integer atendido) {
        // TODO Auto-generated method stub
        return repo.getNoAtendidos(idProgramacionDetalle, atendido);
    }

}
