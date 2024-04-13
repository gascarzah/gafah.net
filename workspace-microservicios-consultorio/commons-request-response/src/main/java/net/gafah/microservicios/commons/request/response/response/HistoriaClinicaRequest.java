package net.gafah.microservicios.commons.request.response.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
@Builder
public class HistoriaClinicaRequest {

    private Long idHistoriaClinica;

    private String ectoscopia;
    private String alergia;
    private String motivo;
    private String antecedentesMedicos;
    private String numeroDocumento;
    private Long idCliente;
}
