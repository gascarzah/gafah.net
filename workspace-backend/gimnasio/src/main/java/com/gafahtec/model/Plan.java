package com.gafahtec.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPlan;
	private String nombre;
	private Integer dias;
	private Float precio;
	
//	@OneToOne(optional=false, mappedBy="plan")
//	private Cliente cliente;
	
//	@JsonIgnore
//	@Builder.Default
//	@OneToMany(mappedBy = "plan", cascade = { CascadeType.ALL }, orphanRemoval = true)
//	private List<Venta> ventas = new ArrayList<>();;
}
