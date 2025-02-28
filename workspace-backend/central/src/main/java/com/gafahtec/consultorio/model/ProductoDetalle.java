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

//@ToString(exclude = { "compraDetalles" })
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class ProductoDetalle extends Auditoria{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProductoDetalle;
	
	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false, foreignKey = @ForeignKey(name = "FK_producto"))
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "id_insumo", nullable = false, foreignKey = @ForeignKey(name = "FK_detalle"))
	private Insumo insumo;
	
	private Integer cantidad;
	
	@ManyToOne
	@JoinColumn(name = "id_unidad", nullable = false, foreignKey = @ForeignKey(name = "FK_unidad"))
	private Unidad unidad;
}
