package cibertec.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cibertec.pe.entity.Cuenta;
import cibertec.pe.modelo.Employee;
import cibertec.pe.service.EmployeeImplement;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeImplement empl;
	
	@GetMapping("/listAllEmployees")
	public List<Employee> listarEmpleados(){
		return empl.getEmployees();
	}
	
	@PostMapping("/createEmployee")
	public Employee crearEmpleado(@RequestBody Employee employee) {
		return empl.createEmployee(employee);
	}
	
	@DeleteMapping("/deleteEmployee/{codigo}")
	public void eliminarEmpleado(@PathVariable int codigo) {
		empl.deleteEmployee(codigo);
	}
	
	@PutMapping("/updateEmployee/{codigo}")
	public String actulizarEmpleado(@PathVariable int codigo, 
			@RequestBody Employee employee) 
	{
		return empl.editEmployee(codigo, employee);
	}
	
	@PostMapping("/createCt/{codigo}")
	public void crearCuenta(@PathVariable int codigo, @RequestBody Cuenta cuenta) {
		System.out.println("Cod URL" + codigo);
		empl.crearCuenta(codigo, cuenta);
	}
	
}
