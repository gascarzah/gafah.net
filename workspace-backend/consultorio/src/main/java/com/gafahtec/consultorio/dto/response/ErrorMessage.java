package com.gafahtec.consultorio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private Date timestamp;

    private String message;

    private int status;
    private String description;
}
