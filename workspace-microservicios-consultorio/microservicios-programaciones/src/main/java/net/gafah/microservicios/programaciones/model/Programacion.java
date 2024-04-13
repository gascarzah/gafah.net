package net.gafah.microservicios.programaciones.model;

import java.util.Date;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Programacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProgramacion;


	
	private Date fechaInicial;
	private Date fechaFinal;

	private String strFechaInicial;
	private String strFechaFinal;

	private String rango;
	private Boolean activo;

}
