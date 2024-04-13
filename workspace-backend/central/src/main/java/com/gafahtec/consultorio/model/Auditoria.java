package com.gafahtec.consultorio.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class Auditoria {


    @Column( updatable = false, nullable = false)
    @CreatedDate
    private LocalDateTime fechaCreacion;


    @LastModifiedDate
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(updatable = false, nullable = false)
    private String creadoPor;

    @LastModifiedBy
    private String modificadoPor;
}
