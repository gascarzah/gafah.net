package com.gafahtec.consultorio.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cita extends Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCita;

    @ManyToOne
    @JoinColumn(name = "id_programacion_detalle", nullable = true, foreignKey = @ForeignKey(name = "FK_cita_programaciondet"))
    private ProgramacionDetalle programacionDetalle;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = true, foreignKey = @ForeignKey(name = "FK_cita_cliente") )
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_cupo", nullable = true, foreignKey = @ForeignKey(name = "FK_cita_cupo"))
    private Cupo cupo;
    
    private Integer atendido;
    
    private String informe;
}
