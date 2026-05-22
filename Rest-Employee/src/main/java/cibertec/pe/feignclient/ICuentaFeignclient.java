package cibertec.pe.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cibertec.pe.entity.Cuenta;

@FeignClient(name = "Employee-Cuenta-FeignClient", url="http://localhost:9003")
public interface ICuentaFeignClient {
	
	@PostMapping("/api/cuenta/createCuenta")
	Cuenta crearCuenta(@RequestBody Cuenta cuenta);
}
