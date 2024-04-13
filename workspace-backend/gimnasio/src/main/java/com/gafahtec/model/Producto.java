package com.gafahtec.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	@Schema(description = "nombre del producto")
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	private String descripcion;
	private Float precio;
	private Integer stock;
	private String randomId;
	
	
	@JsonIgnore
	@Builder.Default
	@OneToMany(mappedBy = "producto", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<VentaDetalle> ventaDetalles  = new ArrayList<>();
	
}
