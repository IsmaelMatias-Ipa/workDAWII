package cibertec.pe.Rest_Cuenta.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.pe.Rest_Cuenta.Model.Cuenta;

public interface ICuentaRepository extends JpaRepository<Cuenta, Integer>{
    
}
