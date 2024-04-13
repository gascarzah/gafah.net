package com.gafahtec.consultorio.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
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

public class Venta extends Auditoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVenta;
	private String numVenta;
	 @CreationTimestamp
	 @Column(updatable = false)
	private LocalDateTime fecha;
//	@ManyToOne
//	@JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_cliente"))
//	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "id_pedido", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_pedido"))
	private Pedido pedido;
	@ManyToOne
	@JoinColumn(name = "id_tipo_recibo", nullable = false, foreignKey = @ForeignKey(name = "FK_tipo_recibo"))
	private TipoRecibo tipoRecibo;

	private Float efectivo;
	private Float visa;
	private Float mastercard;
	private Float total;
	
	
	
}
