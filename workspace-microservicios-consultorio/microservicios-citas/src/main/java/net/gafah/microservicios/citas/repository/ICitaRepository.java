package net.gafah.microservicios.citas.repository;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.gafah.microservicios.citas.model.Cita;
@Repository
public interface ICitaRepository extends JpaRepository<Cita, Long>{



}



