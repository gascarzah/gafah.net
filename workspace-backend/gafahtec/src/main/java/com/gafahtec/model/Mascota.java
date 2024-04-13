package com.gafahtec.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

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
public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMascota;
	private String nombre;
//	private String imagen;
	private String peso;
//	private String tamanio;
//	private String email;
	private String sexo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_raza", nullable = false, foreignKey = @ForeignKey(name = "FK_mascota_raza"))
	private Raza raza;
//	private LocalDate fechaNacimiento;
	
	 @CreationTimestamp
	 @Column(updatable = false)
	private LocalDateTime fechaRegistro;

	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_mascota_cliente"))
	 private Cliente cliente;
}
