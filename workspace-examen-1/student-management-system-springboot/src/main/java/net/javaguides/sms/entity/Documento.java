package net.javaguides.sms.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "documentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Documento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nit")
	private String nit;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Transient
    private Long diasVencimiento;
	
	@Column(name = "fechaRespuesta")
	private LocalDate fechaRespuesta;
	
	@Column(name = "fechaRegistro")
	private LocalDate fechaRegistro;
	
	@Column(name = "respuesta")
	private int respuesta;

	@PostLoad
	public void cargarDiasVencimiento() {
		LocalDate from = LocalDate.now();
		LocalDate to = fechaRespuesta;
		diasVencimiento =  ChronoUnit.DAYS.between(from, to);
		
//		documentos.stream().map(d -> {
//			LocalDate from = LocalDate.now();
//			LocalDate to = d.getFechaRegistro();
//			long result = ChronoUnit.DAYS.between(from, to);
//			System.out.println(result);
//			d.setDiasVencimiento(result);
//			res = result;
//			return d;
//		});
	}

	 


}
