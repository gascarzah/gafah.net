package net.gafah.microservicios.commons.request.response.request;

import java.util.Date;

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
public class ProgramacionRequest {
    private Integer idProgramacion;
    private Date fechaInicial;
    private Date fechaFinal;
    private String[] checked;
    private Integer idEmpresa;
    private String numeroDocumento;
}
