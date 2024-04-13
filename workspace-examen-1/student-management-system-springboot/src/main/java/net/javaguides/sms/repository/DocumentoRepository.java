package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.sms.entity.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long>{

}
