package com.gafahtec.consultorio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Usuario{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	@Column(nullable = false, length = 255)
	private String email;

	@Column(nullable = false)
	private String password;
	
	
	@ManyToOne
	@JoinColumn(name = "empleado_id", foreignKey = @ForeignKey(name = "FK_empleado_usuario"))
	private Empleado empleado;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol", 
		joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"), 
		inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
	private Set<Rol> roles;	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime fechaRegistro;
	

}
