package com.gafahtec.consultorio.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.gafahtec.consultorio.dto.request.ProgramacionRequest;
import com.gafahtec.consultorio.model.Programacion;
import com.gafahtec.consultorio.model.ProgramacionDetalle;

public interface IProgramacionDetalleService extends ICRUD<ProgramacionDetalle, Integer> {
    public List<ProgramacionDetalle> generarProgramacionDetalle(Programacion programacion,
            ProgramacionRequest programacionRequest);

    List<ProgramacionDetalle> generarProgramacion(Programacion programacion, ProgramacionRequest programacionRequest)
            throws ParseException;

    List<ProgramacionDetalle> generarDiasProgramados(Integer idMedico) throws ParseException;

//    public List<ProgramacionDetalle> getProgramacionConDetalle(Programacion programacion);

    public List<ProgramacionDetalle> getProgramacionMedico(Integer idProgramacion, Integer idMedico);
    
    
    public List<ProgramacionDetalle> programacionDias(Integer estado);

    public List<ProgramacionDetalle> verificaProgramacion(Integer idMedico, String fechaInicial, String fechaFinal);
}
