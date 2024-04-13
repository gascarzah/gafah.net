package com.gafahtec.consultorio.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@ToString(exclude = { "compras", "ventas" })
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TipoRecibo extends Auditoria {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoRecibo;
	private String nombre;
	@JsonIgnore
	@Builder.Default
	@OneToMany(mappedBy = "tipoRecibo", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Compra> compras = new ArrayList<>();;
	@JsonIgnore
	@Builder.Default
	@OneToMany(mappedBy = "tipoRecibo", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Venta> ventas = new ArrayList<>();

}
