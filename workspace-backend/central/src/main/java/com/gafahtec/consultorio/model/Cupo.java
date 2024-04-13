package com.gafahtec.consultorio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
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
