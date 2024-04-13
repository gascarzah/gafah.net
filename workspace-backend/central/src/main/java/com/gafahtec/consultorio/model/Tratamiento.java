package com.gafahtec.consultorio.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
public class Tratamiento extends Auditoria{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTratamiento;
	private String nombre;
//	@JsonIgnore
//	@Builder.Default
//	@OneToMany( mappedBy = "tratamiento", cascade = { CascadeType.ALL }, orphanRemoval = true)
//	private List<HistoriaClinicaDetalle> historiaClinicaDetalles  = new ArrayList<>();
}
