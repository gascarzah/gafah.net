package com.gafahtec.consultorio.bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.gafahtec.consultorio.model.Cliente;
import com.gafahtec.consultorio.model.Empleado;
import com.gafahtec.consultorio.model.PedidoDetalle;

import lombok.Data;
@Data
public class PedidoBean {

	private Integer idPedido;
	private Empleado empleado;

	private Cliente cliente;

	private LocalDateTime fecha;
	private String randomId;
	private boolean pagado ;
	private Integer estado;
	private Float total ;
	private List<PedidoDetalle> pedidosDetalle  = new ArrayList<>();
	private boolean expandible ;
}
