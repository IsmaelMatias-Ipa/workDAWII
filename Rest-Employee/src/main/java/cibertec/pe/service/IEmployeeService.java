package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import cibertec.pe.Entity.Cuenta;
import cibertec.pe.modelo.Employee;

public interface IEmployeeService {
	
	public List<Employee> 		getEmployees();
	public Employee				createEmployee(Employee employee);
	public Optional<Employee>	findEmployee(int codigo);
	public String				editEmployee(int codigo, Employee employee);
	public void					deleteEmployee(int codigo);
	public Cuenta				crearCuenta(int codigo, Cuenta cuenta);

}
