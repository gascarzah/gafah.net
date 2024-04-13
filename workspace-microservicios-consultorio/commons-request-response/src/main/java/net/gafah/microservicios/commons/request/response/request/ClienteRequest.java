package net.gafah.microservicios.commons.request.response.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class ClienteRequest {
    private Integer idCliente;
    @NotEmpty(message = "Campo nombres no puede estar vacio")
    private String nombres;
    @NotEmpty(message = "Campo apellido paterno no puede estar vacio")
    private String apellidoPaterno;
    @NotEmpty(message = "Campo apellido materno no puede estar vacio")
    private String apellidoMaterno;
    private String tipoDocumento;
    @NotEmpty(message = "Numero de documento no puede estar vacio")
    private String numeroDocumento;
    private String direccion;
    private String telefono;
    private String celular;
    private LocalDateTime fecha;
    private String email;

    private String ectoscopia;
    private String alergia;
    private String motivo;
    private String antecedentesMedicos;
}
