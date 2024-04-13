package com.gafahtec.consultorio.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
public class Insumo extends Auditoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInsumo;
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "id_unidad", nullable = false, foreignKey = @ForeignKey(name = "FK_insumo_unidad"))
	private Unidad unidad;
	@ManyToOne
	@JoinColumn(name = "id_medida", nullable = false, foreignKey = @ForeignKey(name = "FK_insumo_medida"))
	private Medida medida;
	@ManyToOne
	@JoinColumn(name = "id_categoria_insumo", nullable = false, foreignKey = @ForeignKey(name = "FK_insumo_categoria"))
	private CategoriaInsumo categoriaInsumo;

	private Integer cantidadPorMedida;
	@Builder.Default
	private Integer stockMinimo = 0;
	private Float precioSugerido;

	@JsonIgnore
	@Builder.Default
	@OneToMany(mappedBy = "insumo", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<CompraDetalle> compraDetalles = new ArrayList<>();

}
