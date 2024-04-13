package com.gafahtec.consultorio.dto.request;

import com.gafahtec.consultorio.model.Cita;

import lombok.Data;

@Data
public class HistoriaClinicaDetalleRequest {


    private Cita cita;
    private String informe;
    private Integer atendido;
    
   
}
