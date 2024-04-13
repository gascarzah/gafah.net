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
import javax.validation.constraints.NotEmpty;

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
@ToString(exclude = { "usuarios", "programacionDetalles" })
@EqualsAndHashCode(callSuper=false)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Empleado extends Auditoria{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmpleado;
	private String tipoDocumento;
	@NotEmpty(message = "Numero de documento no puede estar vacio")
	private String numeroDocumento;
	@NotEmpty(message = "Campo nombres no puede estar vacio")
	private String nombres;
	@NotEmpty(message = "Campo apellido paterno no puede estar vacio")
	private String apellidoPaterno;
	@NotEmpty(message = "Campo apellido materno no puede estar vacio")
	private String apellidoMaterno;
	private String direccion;
	private String sexo;
	private LocalDateTime fechaIngreso;
	 @CreationTimestamp
	 @Column(updatable = false)
	private LocalDateTime fechaRegistro;

	private String telefono;
	private String celular;

	private String tipoEmpleado;
	
	@JsonIgnore
	@Builder.Default
	@OneToMany(mappedBy = "empleado", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Usuario> usuarios = new ArrayList<>();

//	@JsonIgnore
//    @Builder.Default
//    @OneToMany( mappedBy = "empleado", cascade = { CascadeType.ALL }, orphanRemoval = true)
//    private List<ProgramacionEmpleado> ProgramacionMedicos  = new ArrayList<>();
	
	@JsonIgnore
	@Builder.Default
	@OneToMany( mappedBy = "empleado", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<ProgramacionDetalle> programacionDetalles  = new ArrayList<>();
}
