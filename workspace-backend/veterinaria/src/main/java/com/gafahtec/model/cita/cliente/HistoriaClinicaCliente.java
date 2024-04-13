package com.gafahtec.model.cita.cliente;

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
import com.gafahtec.model.Cliente;

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
public class HistoriaClinicaCliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHistoriaClinicaCliente;
	
	private String ectoscopia;
	private String alergia;
	private String motivo;
	private String antecedentesMedicos;
	
	@OneToOne(mappedBy = "historiaClinicaCliente")
	private Cliente cliente;
	
	@JsonIgnore
	@Builder.Default
	@OneToMany( mappedBy = "historiaClinicaCliente", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<HistoriaClinicaClienteDetalle> historiaClinicaClienteDetalles  = new ArrayList<>();
}
