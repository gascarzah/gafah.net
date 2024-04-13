package com.gafahtec.consultorio.dto.request;

import lombok.Data;

@Data
public class CitaRequest {

    private Integer idProgramacionDetalle;
    private Integer idCliente;
    private Integer idCita;
    private Integer idCupo;
}
