package cibertec.pe.Entity;

public class Cuenta {
    private String banco;
    private String tipo;
    private int cod_Employee;
    
    public Cuenta() {
    }

    public Cuenta(String banco, String tipo, int cod_Employee) {
        this.banco = banco;
        this.tipo = tipo;
        this.cod_Employee = cod_Employee;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCod_Employee() {
        return cod_Employee;
    }

    public void setCod_Employee(int cod_Employee) {
        this.cod_Employee = cod_Employee;
    }

    
}
