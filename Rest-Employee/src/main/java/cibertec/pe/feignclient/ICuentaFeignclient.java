package cibertec.pe.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cibertec.pe.Entity.Cuenta;

@FeignClient(name = "Employee-Cuenta-FEignClient", url = "http//localhost:9003")
public interface ICuentaFeignclient {
    
    @PostMapping("/api/Cuenta/createCuenta")
    Cuenta crearCuenta(@RequestBody Cuenta cuenta);
}
