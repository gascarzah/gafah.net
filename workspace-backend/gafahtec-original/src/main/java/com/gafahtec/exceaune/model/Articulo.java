package com.gafahtec.exceaune.model;

import java.util.Date;

import lombok.Data;


@Data
public  class Articulo {

	private Integer articuloid;
	private Integer tipartid;
	private String titulo;
	private String contenido;
	private Date fecha;
	private String rutafoto;
	private Integer orden;
	private Integer estado;
}
