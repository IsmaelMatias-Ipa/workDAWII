package cibertec.pe.Rest_Cuenta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RestCuentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestCuentaApplication.class, args);

		System.out.println("-----Iniciado cuenta-----");
	}

}
