package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.Entity.Cuenta;
import cibertec.pe.feignclient.ICuentaFeignclient;
import cibertec.pe.modelo.Employee;
import cibertec.pe.repository.IEmployeeRepository;

@Service
public class EmployeeImplement implements IEmployeeService {

	@Autowired
	private IEmployeeRepository emplRepo;
	
	@Autowired
	private ICuentaFeignclient cuentaFeign;
	
	@Override
	public List<Employee> getEmployees() {
		return emplRepo.findAll();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return emplRepo.save(employee);
	}

	@Override
	public Optional<Employee> findEmployee(int codigo) {		
		return emplRepo.findById(codigo);
	}

	@Override
	public String editEmployee(int codigo, Employee employee) {
		Employee empl = emplRepo.findById(codigo).get();
		if(empl != null) {
			empl.setNom_Employee(employee.getNom_Employee());
			empl.setApe_Employee(employee.getApe_Employee());
			empl.setEm_Employee(employee.getEm_Employee());
			
			emplRepo.save(empl);
			return "Empleado actualizado";
			
		}else return "Error";
			
	}

	@Override
	public void deleteEmployee(int codigo) {
		emplRepo.deleteById(codigo);
	}

	@Override
	public Cuenta crearCuenta(int codigo, Cuenta cuenta) {
		cuenta.setCod_Employee(codigo);
		System.out.println("codigo: " + codigo);
		return cuentaFeign.crearCuenta(cuenta);
		
		
	}

	

}
