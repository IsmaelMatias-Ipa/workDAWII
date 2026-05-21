package cibertec.pe.Rest_Cuenta.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.Rest_Cuenta.Model.Cuenta;
import cibertec.pe.Rest_Cuenta.Repository.ICuentaRepository;

@Service
public class CuentaImplement implements ICuentaService{

    @Autowired
    private ICuentaRepository cuentRepo;

    @Override
    public List<Cuenta> getCuenta() {
        return cuentRepo.findAll();
    }

    @Override
    public Cuenta createCuenta(Cuenta cuenta) {
        return cuentRepo.save(cuenta);
    }

    
}
