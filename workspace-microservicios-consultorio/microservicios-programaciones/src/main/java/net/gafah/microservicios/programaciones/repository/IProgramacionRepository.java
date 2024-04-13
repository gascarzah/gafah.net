package net.gafah.microservicios.programaciones.repository;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.gafah.microservicios.programaciones.model.Programacion;

@Repository
public interface IProgramacionRepository extends JpaRepository<Programacion, Long>{
    Set<Programacion> findByActivo(Boolean activo);
    
    Set<Programacion> findByRango(String rango);
    

    
    @Query("Select p from Programacion p  " )
//    @Query("Select p from Programacion p where p.idEmpresa = :idEmpresa " )
    Page<Programacion> listarProgramacionPageable(@Param("idEmpresa") Integer idEmpresa, Pageable pageable);
    
    
    
}
