package cibertec.pe.Rest_Cuenta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cibertec.pe.Rest_Cuenta.Model.Cuenta;
import cibertec.pe.Rest_Cuenta.Service.CuentaImplement;

@RestController
@RequestMapping("api/Cuenta")
public class CuentaController {
    
    @Autowired
    private CuentaImplement cuempl;

    @GetMapping("/listAllCuentas")
	public List<Cuenta> listarCuentas(){
		return cuempl.getCuenta();
	}

    @PostMapping("/createCuenta")
	public Cuenta crearCuenta(@RequestBody Cuenta cuenta) {
		return cuempl.createCuenta(cuenta);
	}
}
