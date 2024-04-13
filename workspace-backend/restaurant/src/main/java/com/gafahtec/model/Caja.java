package com.gafahtec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
public class Caja {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCaja;
	private String nombre;
	private boolean estado;
	private String monto;
	
}
