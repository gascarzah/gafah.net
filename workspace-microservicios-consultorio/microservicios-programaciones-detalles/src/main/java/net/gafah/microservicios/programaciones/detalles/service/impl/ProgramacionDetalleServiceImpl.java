package net.gafah.microservicios.programaciones.detalles.service.impl;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.gafah.microservicios.programaciones.dto.ProgramacionDetalleHelperResponse;
import net.gafah.microservicios.programaciones.dto.ProgramacionDetalleRequest;
import net.gafah.microservicios.programaciones.dto.ProgramacionDetalleResponse;
import net.gafah.microservicios.programaciones.dto.ProgramacionResponse;
import net.gafah.microservicios.programaciones.model.Programacion;
import net.gafah.microservicios.programaciones.model.ProgramacionDetalle;
import net.gafah.microservicios.programaciones.repository.IProgramacionDetalleRepository;
import net.gafah.microservicios.programaciones.repository.IProgramacionRepository;
import net.gafah.microservicios.programaciones.service.IProgramacionDetalleService;

@AllArgsConstructor
@Service
@Log4j2
@Transactional
public class ProgramacionDetalleServiceImpl implements IProgramacionDetalleService {

	private IProgramacionDetalleRepository iProgramacionDetalleRepository;
	private IProgramacionRepository iProgramacionRepository;
//	private IEmpleadoRepository iEmpleadoRepository;
//	private ICitaRepository iCitaRepository;

	@Override
	public Set<ProgramacionDetalleResponse> registrar(ProgramacionDetalleRequest request) {
		var programacion = iProgramacionRepository.findById(request.getIdProgramacion()).orElseThrow(null);

		LocalDate startLocalDate = programacion.getFechaInicial().toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate();
		System.out.println("startLocalDate " + startLocalDate);
		LocalDate endLocalDate = programacion.getFechaFinal().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		System.out.println("endLocalDate " + endLocalDate);

		var programacionDetalleList = new HashSet<ProgramacionDetalle>();

		for (String dia : request.getChecked()) {
			if (StringUtils.hasText(dia)) {
				LocalDate diaProgramado = startLocalDate.plusDays(Integer.parseInt(dia));
				DayOfWeek dayOfWeek = diaProgramado.getDayOfWeek();

				var programacionDetalle = ProgramacionDetalle.builder().programacion(programacion).fecha(diaProgramado)
						.diaSemana(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault()))
						.numeroDiaSemana(dayOfWeek.getValue())
						.idEmpresa(request.getIdEmpresa())
						.numeroDocumento(request.getNumeroDocumento())
//						.activo(Constants.ACTIVO).build();
						.activo(true).build();
				var programacionDetalleSaved = iProgramacionDetalleRepository.save(programacionDetalle);

				log.info("Resultado", programacionDetalleSaved);
				programacionDetalleList.add(programacionDetalleSaved);
			}

		}

		return programacionDetalleList.stream().map(this::entityToResponse).collect(Collectors.toSet());

	}

	@Override
	public Page<ProgramacionDetalleResponse> listarPageable(Pageable pageable) {
		return iProgramacionDetalleRepository.listarProgramacionDetalleActivoPageable(pageable)
				.map(this::addTotalentityToResponse);
	}

	@Override
	public ProgramacionDetalleHelperResponse listarPorIdProgramacion(Integer idProgramacion) {
		var listaProgramacionDetalle = iProgramacionDetalleRepository
				.findByProgramacion(Programacion.builder().idProgramacion(idProgramacion).build());

//		Set<Empleado> hsetEmpleado = new HashSet<>();
//		List<Boolean> listDias = new ArrayList<>();
//
//		for (int i = 0; i < 6; i++) {
//			listDias.add(false);
//		}
//
//		for (ProgramacionDetalle pd : listaProgramacionDetalle) {
//			var empleado = iEmpleadoRepository.findById(EmpleadoId.builder().idEmpresa(pd.getIdEmpresa()).numeroDocumento(pd.getNumeroDocumento()).build()).get();
//			hsetEmpleado.add(empleado);
//
//			if (pd.getActivo()) {
//				listDias.set((pd.getNumeroDiaSemana() - 1), true);
//			}
//		}
//
//		System.out.println(listDias);
//
//		if (hsetEmpleado.size() > 0) {
//			List<Empleado> empleados = new ArrayList<>(hsetEmpleado);
//			return ProgramacionDetalleHelperResponse.builder().empleado(empleados.get(0))
//					.programacionDetalles(listaProgramacionDetalle).listaDias(listDias).build();
//
//		}

		return null;
	}

	@Override
	public ProgramacionDetalleResponse modificar(@Valid ProgramacionDetalleRequest programacionDetalleRequest) {
		var lista = listarPorProgramacion(programacionDetalleRequest.getIdProgramacion());

		// nuevos
		var listaAgregar = new ArrayList<>(Arrays.asList(programacionDetalleRequest.getChecked()));
		List<ProgramacionDetalle> listProgramacionDetalleDelete = new ArrayList<>();
//	    for(int i= 0; i < lista.size(); i ++) {
		for (var pd : lista) {
//	        var pd = lista.get(i);
			listProgramacionDetalleDelete.add(pd);
			for (int x = 0; x < listaAgregar.size(); x++) {
				String numero = listaAgregar.get(x);
				if (StringUtils.hasText(numero)) {
					if (pd.getNumeroDiaSemana() - 1 == Integer.parseInt(numero)) {
						listProgramacionDetalleDelete.remove(pd);
						listaAgregar.remove(numero);
						break;
					}

				}

			}
		}

		System.out.println("listaTemporal " + listaAgregar);
		System.out.println("listProgramacionDetalleTemp " + listProgramacionDetalleDelete);
		if (!listaAgregar.isEmpty()) {
			programacionDetalleRequest
					.setChecked(Arrays.copyOf(listaAgregar.toArray(), listaAgregar.size(), String[].class));

			registrar(programacionDetalleRequest);
		}

		for (ProgramacionDetalle pgdel : listProgramacionDetalleDelete) {

			eliminar(pgdel.getIdProgramacionDetalle());
		}

		return null;
	}

	@Override
	public void eliminar(Integer id) {

		iProgramacionDetalleRepository.deleteById(id);
	}

	private Set<ProgramacionDetalle> listarPorProgramacion(Integer idProgramacion) {

		return iProgramacionDetalleRepository
				.findByProgramacion(Programacion.builder().idProgramacion(idProgramacion).build());
	}

	public Set<ProgramacionDetalleResponse> getProgramacionEmpleado(ProgramacionDetalleRequest request) {
		return iProgramacionDetalleRepository.getProgramacionEmpleado(request.getIdProgramacion(),
				request.getIdEmpresa(), request.getNumeroDocumento()).stream().map(this::entityToResponse)
				.collect(Collectors.toSet());

	}

	public Boolean existeProgramacionEmpleado(ProgramacionDetalleRequest request) {

		return getProgramacionEmpleado(request).isEmpty();
	}

	public ProgramacionDetalle modificarEntity(ProgramacionDetalle programacionDetalle) {
		return iProgramacionDetalleRepository.save(programacionDetalle);
	}
	//////////////////

	@Override
	public Set<ProgramacionDetalleResponse> listarDiasProgramados(String numeroDocumento, Integer idEmpresa)
			throws ParseException {

		return iProgramacionDetalleRepository.findByEmpleadoAndEstado(numeroDocumento, idEmpresa, true).stream()
				.map(this::entityToResponse).collect(Collectors.toSet());
	}

	@Override
	public Set<ProgramacionDetalle> getProgramacionDetalleActivo(Boolean activo) {

		return iProgramacionDetalleRepository.findByActivo(activo);
	}

	@Override
	public Set<ProgramacionDetalleResponse> verificaProgramacion(Integer idMedico, String fechaInicial,
			String fechaFinal) {
		return iProgramacionDetalleRepository.verificaProgramacion(idMedico, fechaInicial, fechaFinal).stream()
				.map(this::entityToResponse).collect(Collectors.toSet());

	}

	@Override
	public Set<ProgramacionDetalleResponse> citasPendientes(Integer idMedico, Integer numeroDiaSemana) {

//		return iProgramacionDetalleRepository.citasPendientes(idMedico, Constants.ACTIVO, numeroDiaSemana).stream()
		return iProgramacionDetalleRepository.citasPendientes(idMedico, true, numeroDiaSemana).stream()
				.map(this::entityToResponse).collect(Collectors.toSet());
	}



	private ProgramacionDetalleResponse entityToResponse(ProgramacionDetalle entity) {

		var response = new ProgramacionDetalleResponse();
		BeanUtils.copyProperties(entity, response);

		var programacion = new ProgramacionResponse();
		BeanUtils.copyProperties(entity.getProgramacion(), programacion);


		
		response.setProgramacion(programacion);
		return response;
	}

	private ProgramacionDetalleResponse addTotalentityToResponse(ProgramacionDetalle entity) {

		var response = entityToResponse(entity);
//		var total = iCitaRepository.getTotalCitas(entity.getIdProgramacionDetalle());
//
//		response.setRegistrados(total);
		return response;
	}

}
