package com.gafahtec.model.cita.cliente;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gafahtec.model.cita.Tratamiento;

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
public class HistoriaClinicaClienteDetalle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHistoriaClinicaClienteDetalle;
	
	@ManyToOne
	@JoinColumn(name = "id_tratamiento", nullable = true, foreignKey = @ForeignKey(name = "FK_historia_clinica_cliente_tratamiento"))
	private Tratamiento tratamiento;
	private boolean pagado;
	
	@ManyToOne
	@JoinColumn(name = "id_historia_clinica_cliente", nullable = true, foreignKey = @ForeignKey(name = "FK_hc_hccdet"))
	private HistoriaClinicaCliente historiaClinicaCliente;
}
