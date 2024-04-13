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


public class CompraDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompraDetalle;
	
	@ManyToOne
	@JoinColumn(name = "id_compra", nullable = false, foreignKey = @ForeignKey(name = "FK_detalle_compra"))
	private Compra compra;
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_insumo", nullable = false, foreignKey = @ForeignKey(name = "FK_insumo_compra"))
	private Insumo insumo;
	private Integer cantidad;
	private Float precioUnidad;
//	private Integer stock;
	
}
