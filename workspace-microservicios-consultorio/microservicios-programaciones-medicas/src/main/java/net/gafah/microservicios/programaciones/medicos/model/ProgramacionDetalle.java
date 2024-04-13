package net.gafah.microservicios.programaciones.medicos.model;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ProgramacionDetalle  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProgramacionDetalle;

    private LocalDate fecha;

    private String diaSemana;
    private Integer numeroDiaSemana;
    private Boolean activo;

    private String numeroDocumento;
    private Integer idEmpresa;
    
    
    private Long idProgramacion;




}
