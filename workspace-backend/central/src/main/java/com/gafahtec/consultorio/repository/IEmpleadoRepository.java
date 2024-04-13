package com.gafahtec.consultorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gafahtec.consultorio.model.Empleado;

public interface IEmpleadoRepository extends IGenericRepository<Empleado, Integer>{
    @Query("SELECT emp FROM Usuario u join u.empleado emp join  u.roles r where r.idRol = :tipoEmpleado   ")
    List<Empleado> findByTipoEmpleado(@Param("tipoEmpleado")Integer tipoEmpleado);

}
