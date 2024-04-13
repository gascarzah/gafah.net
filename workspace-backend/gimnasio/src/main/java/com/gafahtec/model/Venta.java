package com.gafahtec.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVenta;
	private String numVenta;
	 @CreationTimestamp
	 @Column(updatable = false)
	private LocalDateTime fecha;
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_cliente"))
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "id_tipo_recibo", nullable = false, foreignKey = @ForeignKey(name = "FK_tipo_recibo"))
	private TipoRecibo tipoRecibo;
	
//	@ManyToMany(cascade = {
//	        CascadeType.PERSIST,
//	        CascadeType.MERGE
//	    })
//	@JoinTable(name = "venta_plan", 
//			   joinColumns = @JoinColumn(name = "id_venta", referencedColumnName = "idVenta"), 
//			   inverseJoinColumns = @JoinColumn(name = "id_plan", referencedColumnName = "idPlan"))
//	private List<Plan> planes;
//	@ManyToOne
//	@JoinColumn(name = "id_plan", nullable = false, foreignKey = @ForeignKey(name = "FK_plan"))
//	private Plan plan;
	private String randomId;
	
//	@ManyToMany(cascade = {
//	        CascadeType.PERSIST,
//	        CascadeType.MERGE
//	    })
//	@JoinTable(name = "venta_producto_detalle", 
//			   joinColumns = @JoinColumn(name = "id_venta", referencedColumnName = "idVenta"), 
//			   inverseJoinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "idProducto"))
//	private List<Producto> producto;
	
	@JsonIgnore
	@Builder.Default
	@OneToMany( mappedBy = "venta", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<VentaDetalle> ventaDetalles  = new ArrayList<>();
	private boolean activo;
	private Float efectivo;
	private Float visa;
	private Float mastercard;
	private Float total;
	
	
	
}
