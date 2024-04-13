package net.gafah.microservicios.commons.request.response.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class ApiResponse<T> {

    private int status;
    private String message;
    private Object result;




}
