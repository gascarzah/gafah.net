package com.gafahtec.model.cita;

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
import com.gafahtec.model.cita.cliente.HistoriaClinicaClienteDetalle;

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
public class Tratamiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTratamiento;
	private String nombre;
	private String tipoTratamiento;
	
	@JsonIgnore
	@Builder.Default
	@OneToMany( mappedBy = "tratamiento", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<HistoriaClinicaClienteDetalle> historiaClinicaDetalles  = new ArrayList<>();;
}
