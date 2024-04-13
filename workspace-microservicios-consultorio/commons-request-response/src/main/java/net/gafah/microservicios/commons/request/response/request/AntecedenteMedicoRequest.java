package net.gafah.microservicios.commons.request.response.request;

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
public class AntecedenteMedicoRequest {

    private Long idAntecedenteMedico;

    private String ectoscopia;
    private String alergia;
    private String motivo;
    private String antecedentesMedicos;
    

    private String numeroDocumento;
}
