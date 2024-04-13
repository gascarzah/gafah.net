package com.gafahtec.consultorio.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gafahtec.consultorio.dto.DiaProgramado;
import com.gafahtec.consultorio.model.ProgramacionDetalle;
import com.gafahtec.consultorio.service.IProgramacionDetalleService;
import com.gafahtec.consultorio.util.Utils;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/programacionesDetalladas")
@AllArgsConstructor
@Slf4j
public class ProgramacionDetalleController {

    private IProgramacionDetalleService iProgramacionDetalleService;

    @GetMapping("/medico")
    public ResponseEntity<List<ProgramacionDetalle>> listarPorMedico(@RequestParam("idMedico") Integer idMedico)
            throws Exception {
        List<ProgramacionDetalle> lista = new ArrayList<>();
        try {
            lista = iProgramacionDetalleService.generarDiasProgramados(idMedico);
        } catch (Exception e) {
            log.error("error", e);
        }

        return new ResponseEntity<List<ProgramacionDetalle>>(lista, HttpStatus.OK);
    }

//    @GetMapping("/verifica")
//    public ResponseEntity<List<DiaProgramado>> verificaProgramacion(@RequestParam("idMedico") Integer idMedico,
//            @RequestParam("fechaInicial") Date fechaInicial,
//            @RequestParam("fechaFinal") Date fechaFinal) throws Exception {
//
//        String strFechaInicial = Utils.getFecha2String(fechaInicial);
//        String strFechaFinal = Utils.getFecha2String(fechaFinal);
//        List<ProgramacionDetalle> lista = new ArrayList<>();
//        Map<Integer, Boolean> diasProgramados = Utils.getListaDias();
//        List<DiaProgramado> dias = new ArrayList<>();
//        try {
//
//            System.out.println(
//                    "Verifica " + idMedico + " strFechaInicial " + strFechaInicial + " strFechaFinal " + strFechaFinal);
//            lista = iProgramacionDetalleService.verificaProgramacion(idMedico, strFechaInicial, strFechaFinal);
//
//            if (!lista.isEmpty()) {
//                lista.forEach(p -> {
//                    diasProgramados.put(p.getNumeroDiaSemana(), true);
//                });
//            }
//            
//            
//            
//            diasProgramados.forEach((k,v) -> {
//                System.out.println((k + ":" + v));
//                dias.add(new DiaProgramado(k, Utils.DIAS[k], v));
//            });
//
//            System.out.println("Verifica " + dias);
//        } catch (Exception e) {
//            log.error("error", e);
//        }
//
//        return new ResponseEntity<List<DiaProgramado>>(dias, HttpStatus.OK);
//    }
}
