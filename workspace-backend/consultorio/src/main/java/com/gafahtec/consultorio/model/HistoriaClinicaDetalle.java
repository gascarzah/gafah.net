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
@EntityListeners(AuditingEntityListener.class)
//@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class HistoriaClinicaDetalle extends Auditoria{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHistoriaClinicaDetalle;
	
//	@ManyToOne
//	@JoinColumn(name = "id_tratamiento", nullable = true, foreignKey = @ForeignKey(name = "FK_historia_clinica_tratamiento"))
//	private Tratamiento tratamiento;
//	private boolean pagado;
	
	private String informe;
	
	@ManyToOne
	@JoinColumn(name = "id_historia_clinica", nullable = true,  foreignKey = @ForeignKey(name = "FK_hc_hcdet"))
	private HistoriaClinica historiaClinica;
}
