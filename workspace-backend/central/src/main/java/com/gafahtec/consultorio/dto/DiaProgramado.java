package com.gafahtec.consultorio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaProgramado {
    private Integer numero;
    private String desc;
    private Boolean estado;
}
