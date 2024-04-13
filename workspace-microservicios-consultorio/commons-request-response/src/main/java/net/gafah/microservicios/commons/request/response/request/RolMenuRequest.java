package net.gafah.microservicios.commons.request.response.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class RolMenuRequest implements Serializable {
private Integer idRol;
private Integer[] idsMenu;
}
