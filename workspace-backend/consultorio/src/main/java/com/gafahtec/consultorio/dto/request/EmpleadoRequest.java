package com.gafahtec.consultorio.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmpleadoRequest {
    private Integer idMedico;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String tipoDocumento;
    private String numeroDocumento;
    private String direccion;
    private String telefono;
    private String celular;
    private LocalDateTime fecha;
}
