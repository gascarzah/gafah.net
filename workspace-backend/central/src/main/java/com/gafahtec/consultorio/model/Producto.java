package com.gafahtec.consultorio.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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

import io.swagger.v3.oas.annotations.media.Schema;
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
@ToString(exclude = { "productoDetalles", "pedidoDetalles" })
//@ToString(exclude = {"categoriaProducto","destino", "productoDetalles", "pedidoDetalles" })
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })


public class Producto extends Auditoria{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	@Schema(description = "nombre del producto")
//	@Size(min=3, message = "{persona.nombres}" )
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	private String descripcion;
	private Float precio;
	private Integer stock;
	@ManyToOne
	@JoinColumn(name = "id_categoria_producto", nullable = false, foreignKey = @ForeignKey(name = "FK_producto_categoria"))
	private CategoriaProducto categoriaProducto;
	private String imagen;
//	@ManyToOne
//	@JoinColumn(name = "id_destino", nullable = true, foreignKey = @ForeignKey(name = "FK_destino_producto"))
//	private Destino destino;
	private String randomId;
	
	@JsonIgnore
	@Builder.Default
	@OneToMany(mappedBy = "producto", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<ProductoDetalle> productoDetalles  = new ArrayList<>();
	
	@JsonIgnore
	@Builder.Default
	@OneToMany(mappedBy = "producto", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<PedidoDetalle> pedidoDetalles  = new ArrayList<>();
	
}
