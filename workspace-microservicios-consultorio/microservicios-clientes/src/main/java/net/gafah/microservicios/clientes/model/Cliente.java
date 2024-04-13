package net.gafah.microservicios.clientes.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString(exclude = { "citas" })
//@EqualsAndHashCode(exclude = {  "citas" })
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Cliente {

	@Id
	private String numeroDocumento;

	private String nombres;

	private String apellidoPaterno;

	private String apellidoMaterno;

	private String tipoDocumento;

	private String direccion;

	private String telefono;
	private String celular;

	private String email;



}
