package com.gafahtec.consultorio.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = { "citas" })
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProgramacionDetalle extends Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProgramacionDetalle;

    private LocalDate fecha;

    private String diaSemana;
    private Integer numeroDiaSemana;
    private Integer estado;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "id_empleado", nullable = false, foreignKey = @ForeignKey(name = "FK_programacion_empleado_medico"))
    private Empleado empleado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_programacion", nullable = false, foreignKey = @ForeignKey(name = "FK_programacion"))
    private Programacion programacion;

    @JsonIgnore
    @Builder.Default
    @OneToMany(mappedBy = "programacionDetalle", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private List<Cita> citas = new ArrayList<>();
    
    

}
