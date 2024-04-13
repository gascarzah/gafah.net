package com.gafahtec.consultorio.dto.request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ClienteRequest {
    private Integer idCliente;
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
