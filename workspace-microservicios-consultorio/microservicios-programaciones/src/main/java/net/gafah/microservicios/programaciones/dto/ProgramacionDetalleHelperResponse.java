package net.gafah.microservicios.programaciones.dto;

import java.io.Serializable;
import java.util.List;

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
public class ProgramacionDetalleHelperResponse implements Serializable {

//    private Empleado empleado;
    
//    private Set<ProgramacionDetalle> programacionDetalles;
    
    private  List< Boolean> listaDias;
    
        
}
