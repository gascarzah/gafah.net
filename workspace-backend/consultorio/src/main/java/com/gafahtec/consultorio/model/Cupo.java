package com.gafahtec.consultorio.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@ToString(exclude = { "citas" })
@Builder
public class Cupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCupo;

    private String descripcion;

    @JsonIgnore
    @Builder.Default
    @OneToMany(mappedBy = "cupo", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private List<Cita> citas  = new ArrayList<>();
}
