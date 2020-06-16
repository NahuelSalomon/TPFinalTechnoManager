package ClasesPersona;

import java.util.Date;

/**
 * Subclase vendedor que extiende de empleado.
 * 
 * @author Nahuel
 *
 */
public class Vendedor extends Empleado {

	private String telefono;

	public Vendedor() {
		super();
		this.telefono = null;
	}

	public Vendedor(String nombre, String apellido, String legajo, String contraseña) {
		super(nombre, apellido, legajo, contraseña);
		this.telefono = null;
	}
	
	public Vendedor(String nombre, String apellido, String dni, int genero, Date fechaNac, int estadoCivil,
			String telefono, String legajo, String contraseña) {
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
		return super.toString() + "\nTelefono:" + getTelefono() + "Tipo de empleado: " + tipoEmpleado();
	}

	@Override
	public String tipoEmpleado() {
		return "vendedor";
	}

}
