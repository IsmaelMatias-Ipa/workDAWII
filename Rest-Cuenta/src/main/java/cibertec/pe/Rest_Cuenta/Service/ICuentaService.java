package cibertec.pe.Rest_Cuenta.Service;

import java.util.List;

import cibertec.pe.Rest_Cuenta.Model.Cuenta;

public interface ICuentaService {
    
    public List<Cuenta> 		getCuenta();
	public Cuenta				createCuenta(Cuenta cuenta);

}
