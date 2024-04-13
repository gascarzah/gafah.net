package com.gafahtec.consultorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gafahtec.consultorio.model.Cita;

@Repository
public interface ICitaRepository extends IGenericRepository<Cita,Integer>{

    @Query("Select c from Cita c join c.programacionDetalle pro where pro.idProgramacionDetalle = :idProgramacionDetalle order by c.idCita ")
    List<Cita> findByProgramacionDetalleOrderByCita(@Param("idProgramacionDetalle")Integer idProgramacionDetalle);
    
    @Modifying
    @Query(value = "UPDATE Cita set id_cliente = null where id_cita = :idCita and id_cupo = :idCupo and id_programacion_detalle = :idProgramacionDetalle ", nativeQuery = true)
    Integer eliminar(@Param("idCita") Integer idCita, @Param("idCupo") Integer idCupo, @Param("idProgramacionDetalle") Integer idProgramacionDetalle);
    
    @Modifying
    @Query(value = "UPDATE Cita set atendido = 1 where id_cita = :idCita ", nativeQuery = true)
    Integer updateAtencion(@Param("idCita") Integer idCita);
    
}



