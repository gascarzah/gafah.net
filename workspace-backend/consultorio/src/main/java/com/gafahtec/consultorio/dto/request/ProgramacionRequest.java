package com.gafahtec.consultorio.dto.request;

import java.util.Date;

import lombok.Data;

@Data
public class ProgramacionRequest {
    private Integer idMedico;
    private Date fechaInicial;
    private Date fechaFinal;
    private String[] checked;
}
