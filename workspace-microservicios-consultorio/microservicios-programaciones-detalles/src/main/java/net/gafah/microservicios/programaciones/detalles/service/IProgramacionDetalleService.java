package net.gafah.microservicios.programaciones.detalles.service;

import java.text.ParseException;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jakarta.validation.Valid;
import net.gafah.microservicios.programaciones.dto.ProgramacionDetalleHelperResponse;
import net.gafah.microservicios.programaciones.dto.ProgramacionDetalleRequest;
import net.gafah.microservicios.programaciones.dto.ProgramacionDetalleResponse;
import net.gafah.microservicios.programaciones.model.ProgramacionDetalle;

public interface IProgramacionDetalleService  {


	Set<ProgramacionDetalleResponse> registrar(ProgramacionDetalleRequest request) ;
	

	ProgramacionDetalleResponse modificar(@Valid ProgramacionDetalleRequest programacionDetalleRequest);


	void eliminar(Integer id);
	
	Page<ProgramacionDetalleResponse> listarPageable(Pageable pageable);
	
	Set<ProgramacionDetalleResponse> getProgramacionEmpleado(ProgramacionDetalleRequest programacionDetalleRequest);
	
	Boolean existeProgramacionEmpleado(ProgramacionDetalleRequest request);
    
	
	Set<ProgramacionDetalleResponse> listarDiasProgramados(String numeroDocumento, Integer idEmpresa) throws ParseException;

	Set<ProgramacionDetalle> getProgramacionDetalleActivo(Boolean estado);
	public ProgramacionDetalle modificarEntity(ProgramacionDetalle programacionDetalle);
    //////////////////////////////////////////////
	


	

	Set<ProgramacionDetalleResponse> verificaProgramacion(Integer idMedico, String fechaInicial, String fechaFinal);

	Set<ProgramacionDetalleResponse> citasPendientes(Integer idMedico, Integer numeroDiaSemana);

    

	ProgramacionDetalleHelperResponse listarPorIdProgramacion(Integer idProgramacion);



   




    

   
}
