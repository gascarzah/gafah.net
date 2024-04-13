package net.gafah.microservicios.programaciones.dto;

import java.io.Serializable;
import java.time.LocalDate;

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
public class ProgramacionDetalleResponse implements Serializable {


    private Integer idProgramacionDetalle;

    private LocalDate fecha;

    private String diaSemana;
    private Integer numeroDiaSemana;
    
    private Boolean estado;
//    private EmpleadoResponse empleado;

    private ProgramacionResponse programacion;
    
    private Integer registrados;
    


    

    
}
