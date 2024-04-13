package net.gafah.microservicios.commons.request.response.response;

import java.io.Serializable;

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
public class EmpresaResponse implements Serializable{
    private Integer idEmpresa;
    
    private String nombre;
}
