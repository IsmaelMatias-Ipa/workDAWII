package cibertec.pe.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_Employee;
	
	private String nom_Employee;
	private String ape_Employee;
	private String em_Employee;
	
	public Employee() {	}
	
	public Employee(int cod_Employee, String nom_Employee, String ape_Employee, String em_Employee) {
		this.cod_Employee = cod_Employee;
		this.nom_Employee = nom_Employee;
		this.ape_Employee = ape_Employee;
		this.em_Employee = em_Employee;
	}
	
	public Employee(String nom_Employee, String ape_Employee, String em_Employee) {
		this.nom_Employee = nom_Employee;
		this.ape_Employee = ape_Employee;
		this.em_Employee = em_Employee;
	}

	public int getCod_Employee() {
		return cod_Employee;
	}
	public void setCod_Employee(int cod_Employee) {
		this.cod_Employee = cod_Employee;
	}
	public String getNom_Employee() {
		return nom_Employee;
	}
	public void setNom_Employee(String nom_Employee) {
		this.nom_Employee = nom_Employee;
	}
	public String getApe_Employee() {
		return ape_Employee;
	}
	public void setApe_Employee(String ape_Employee) {
		this.ape_Employee = ape_Employee;
	}
	public String getEm_Employee() {
		return em_Employee;
	}
	public void setEm_Employee(String em_Employee) {
		this.em_Employee = em_Employee;
	}
}
