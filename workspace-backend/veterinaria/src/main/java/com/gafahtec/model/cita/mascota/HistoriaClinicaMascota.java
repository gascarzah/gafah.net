package com.gafahtec.model.cita.mascota;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gafahtec.model.Mascota;

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
public class HistoriaClinicaMascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHistoriaClinicaMascota;
	
	private String ectoscopia;
	private String alergia;
	private String motivo;
	private String antecedentesMedicos;
	
	@OneToOne(mappedBy = "historiaClinicaMascota")
	private Mascota mascota;
	
	@JsonIgnore
	@Builder.Default
	@OneToMany( mappedBy = "historiaClinicaMascota", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<HistoriaClinicaMascotaDetalle> historiaClinicaMascotaDetalles  = new ArrayList<>();
}
