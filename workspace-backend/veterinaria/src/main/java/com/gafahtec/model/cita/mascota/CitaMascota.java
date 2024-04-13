package com.gafahtec.model.cita.mascota;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gafahtec.model.cita.Programacion;

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
public class CitaMascota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCitaMascota;
	@ManyToOne
	@JoinColumn(name = "id_programacion", nullable = true, foreignKey = @ForeignKey(name = "FK_cita_programacio_mascota"))
	private Programacion programacion;
	
	@ManyToOne
	@JoinColumn(name = "id_historia_clinica_mascota", nullable = true, foreignKey = @ForeignKey(name = "FK_cita_mascota"))
	private HistoriaClinicaMascota historiaClinicaMascota;
}
