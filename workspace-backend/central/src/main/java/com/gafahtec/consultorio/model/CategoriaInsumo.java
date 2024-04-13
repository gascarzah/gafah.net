package com.gafahtec.consultorio.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

@ToString(exclude = { "insumos" })
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CategoriaInsumo extends Auditoria {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategoriaInsumo;
	private String nombre;
	private String descripcion;
	private boolean activo;
	 @CreationTimestamp
	 @Column(updatable = false)
	private LocalDateTime fechaRegistro;
	 @JsonIgnore
	@Builder.Default
	@OneToMany(mappedBy = "categoriaInsumo", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private  List<Insumo> insumos = new ArrayList<>();
}
