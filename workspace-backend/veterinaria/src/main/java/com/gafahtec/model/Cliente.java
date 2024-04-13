package com.gafahtec.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gafahtec.model.cita.cliente.HistoriaClinicaCliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"mascotas" })
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	
	private String tipoDocumento;
	private String numeroDocumento;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String direccion;
	private String sexo;
	private LocalDateTime fechaIngreso;
	 @CreationTimestamp
	 @Column(updatable = false)
	private LocalDateTime fechaRegistro;
	
	private String correo;
	private String telefono;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_historia_clinica_cliente", referencedColumnName = "idHistoriaClinicaCliente")
	private HistoriaClinicaCliente historiaClinicaCliente;
	
	@JsonIgnore
	@Builder.Default
	@OneToMany(mappedBy = "cliente", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Mascota> mascotas = new ArrayList<>();
}
