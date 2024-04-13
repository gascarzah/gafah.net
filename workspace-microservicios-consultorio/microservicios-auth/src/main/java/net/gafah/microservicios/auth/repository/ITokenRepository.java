package net.gafah.microservicios.auth.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.gafah.microservicios.commons.usuarios.model.Token;

public interface ITokenRepository extends JpaRepository<Token, Long> {

  @Query(value = """
      select t from Token t inner join Usuario u\s
      on t.usuario.idUsuario = u.idUsuario\s
      where u.id = :id and (t.expired = false or t.revoked = false)\s
      """)
  List<Token> findAllValidTokenByUser(Long id);

  Optional<Token> findByToken(String token);
}
