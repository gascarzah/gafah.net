package com.gafahtec.consultorio.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gafahtec.consultorio.dto.request.CitaRequest;
import com.gafahtec.consultorio.model.Cita;
import com.gafahtec.consultorio.model.Cliente;
import com.gafahtec.consultorio.model.Cupo;
import com.gafahtec.consultorio.model.ProgramacionDetalle;
import com.gafahtec.consultorio.service.ICitaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/citas")
@AllArgsConstructor
public class CitaController {

    private ICitaService iCitaService;

    @GetMapping
    public ResponseEntity<List<Cita>> listar() throws Exception {
        List<Cita> lista = iCitaService.listar();
        return new ResponseEntity<List<Cita>>(lista, HttpStatus.OK);
    }

    @GetMapping("/medico")
    public ResponseEntity<List<Cita>> listarCitas(
            @RequestParam("idProgramacionDetalle") Integer idProgramacionDetalle) throws Exception {
        List<Cita> lista = new ArrayList<>();
        try {
             lista = iCitaService.listarCitas(idProgramacionDetalle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<List<Cita>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Cita obj = iCitaService.listarPorId(id);

        if (obj.getIdCita() == null) {
            throw new RuntimeException("Id no encontrado " + id);
        }

        return new ResponseEntity<Cita>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cita> registrar(@Valid @RequestBody CitaRequest citaRequest) throws Exception {
        
        Cita obj = iCitaService.registrar(Cita.builder()
//                                        .idCita(citaRequest.getIdCita())
                                        .cupo(Cupo.builder().idCupo(citaRequest.getIdCupo()).build())
                                        .programacionDetalle(ProgramacionDetalle.builder().idProgramacionDetalle(citaRequest.getIdProgramacionDetalle()).build())
                                        .cliente(Cliente.builder().idCliente(citaRequest.getIdCliente()).build()) 
                                        
                                        .build());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCita())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Cita> modificar(@Valid @RequestBody CitaRequest citaRequest) throws Exception {
        Cita objRequest = Cita.builder()
                .idCita(citaRequest.getIdCita())
                .cupo(Cupo.builder().idCupo(citaRequest.getIdCupo()).build())
                .programacionDetalle(ProgramacionDetalle.builder().idProgramacionDetalle(citaRequest.getIdProgramacionDetalle()).build())
                .cliente(Cliente.builder().idCliente(citaRequest.getIdCliente()).build())
                .atendido(0)
                .build();
        Cita obj = iCitaService.registrar(objRequest);
        return new ResponseEntity<Cita>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/eliminar")
    public ResponseEntity<Integer> eliminar(@RequestBody CitaRequest citaRequest) throws Exception {
        Integer obj = iCitaService.eliminar(citaRequest.getIdCita(), citaRequest.getIdCupo(),citaRequest.getIdProgramacionDetalle());
//        Cita obj = iCitaService.listarPorId(id);
//
//        if (obj.getIdCita() == null) {
//            throw new RuntimeException("ID NO ENCONTRADO " + id);
//        }

//        iCitaService.eliminar(id);
        return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Cita>> listarPageable(Pageable pageable) throws Exception {
        Page<Cita> paginas = iCitaService.listarPageable(pageable);
        return new ResponseEntity<Page<Cita>>(paginas, HttpStatus.OK);
    }
}
