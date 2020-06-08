package ClasesPersona;

import java.util.Date;

public class Vendedores extends Empleado{
	
	private String telefono;

	public Vendedores() {
		super();
	}

	public Vendedores(String nombre, String apellido, String dni, String genero,
			Date fechaNac, String estadoCivil, String telefono, String legajo, String contraseña) {
		super(nombre, apellido, dni, genero, fechaNac, estadoCivil, legajo, contraseña);
		this.telefono = telefono;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String toString() {
		return super.toString()+"\nTelefono:"+getTelefono();
	}
	
}
