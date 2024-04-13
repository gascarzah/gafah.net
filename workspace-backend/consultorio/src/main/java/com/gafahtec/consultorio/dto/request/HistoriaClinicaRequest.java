package com.gafahtec.consultorio.dto.request;

import lombok.Data;

@Data
public class HistoriaClinicaRequest {

    private Integer idHistoriaClinica;

    private String ectoscopia;
    private String alergia;
    private String motivo;
    private String antecedentesMedicos;
    private Integer idCliente;
}
