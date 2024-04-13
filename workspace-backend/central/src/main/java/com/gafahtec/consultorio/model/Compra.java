package com.gafahtec.consultorio.model;

import java.time.LocalTime;
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

import org.hibernate.annotations.CreationTimestamp;
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

@ToString(exclude = { "compraDetalles" })
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Compra extends Auditoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompra;

	private String codigoCompra;

	@ManyToOne
	@JoinColumn(name = "id_proveedor", nullable = false, foreignKey = @ForeignKey(name = "FK_compra_proveedor"))
	private Proveedor proveedor;
	@ManyToOne
	@JoinColumn(name = "id_tipo_recibo", nullable = false, foreignKey = @ForeignKey(name = "FK_compra_tipo_recibo"))
	private TipoRecibo tipoRecibo;

	private String numeroRecibo;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalTime fecha;
	private String observacion;
	private Float valor;
	private Float igv;
	private Float total;
	private String randomId;
	@JsonIgnore
	@Builder.Default
	@OneToMany(mappedBy = "compra", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<CompraDetalle> compraDetalles = new ArrayList<>();;
}
