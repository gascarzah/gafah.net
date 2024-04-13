package net.gafah.microservicios.commons.request.response.response;

import java.util.Date;
import java.util.Map;

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
public class ValidationErrors {

    private Map<String, String> errors;

    private Date timestamp;

}
