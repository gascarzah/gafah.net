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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
//import lombok.ToString;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = { "citas" })
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Cliente extends Auditoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	@NotEmpty(message = "Campo nombres no puede estar vacio")
	private String nombres;
	@NotEmpty(message = "Campo apellido paterno no puede estar vacio")
	private String apellidoPaterno;
	@NotEmpty(message = "Campo apellido materno no puede estar vacio")
	private String apellidoMaterno;

	private String tipoDocumento;
	@NotEmpty(message = "Numero de documento no puede estar vacio")
	private String numeroDocumento;

	private String direccion;

	private String telefono;
	private String celular;

	@OneToOne(mappedBy = "cliente")
	private HistoriaClinica historiaClinica;

	@JsonIgnore
	@Builder.Default
	@OneToMany(mappedBy = "cliente", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Cita> citas = new ArrayList<>();

}
