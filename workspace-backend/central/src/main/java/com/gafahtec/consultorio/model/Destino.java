package com.gafahtec.consultorio.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Destino extends Auditoria{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDestino;
	
	
	private String descripcion;
	
//	 @JsonIgnore
//	@Builder.Default
//	@OneToMany(mappedBy = "destino", cascade = { CascadeType.ALL }, orphanRemoval = true)
//	private List<Producto> productos  = new ArrayList<>();
}
