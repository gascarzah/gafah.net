package net.gafah.microservicios.commons.historia.clinica.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
import lombok.ToString;
@Setter
@Getter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class HistoriaClinica {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idHistoriaClinica;
	private String numeroHistoriaClinica;
	private String ectoscopia;
	private String alergia;
	private String motivo;
	private String antecedentesMedicos;
	private String numeroDocumento;
	private Long idCliente;
	
}
