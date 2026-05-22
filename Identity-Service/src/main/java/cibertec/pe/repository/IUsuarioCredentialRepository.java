package cibertec.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.pe.model.UsuarioCredential;
import java.util.Optional;


public interface IUsuarioCredentialRepository extends JpaRepository<UsuarioCredential, Integer>{
    Optional<UsuarioCredential> findByEmail(String email);
}
