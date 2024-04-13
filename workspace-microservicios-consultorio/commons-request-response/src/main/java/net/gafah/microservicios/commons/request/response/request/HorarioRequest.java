package net.gafah.microservicios.commons.request.response.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class HorarioRequest {

    private Integer idHorario;
    private String descripcion;
    
}
