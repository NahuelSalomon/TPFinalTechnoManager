package ClasesPersona;

import java.util.Date;

/**
 * Clase que engloba todas las características de un empleado.
 * No puede ser instanciada con el objetivo de que se tiene que definir el tipo de empleado.
 * @author Nahuel
 *
 */
public abstract class Empleado extends Persona{
	private String estadoCivil;
	private String legajo;
	private String contraseña;

	public Empleado(String nombre, String apellido, String dni, String genero, Date fechaNac,
			String estadoCivil, String legajo, String contraseña) {
		super(nombre, apellido, dni, genero, fechaNac);
		this.estadoCivil = estadoCivil;
		this.legajo = legajo;
		this.contraseña = contraseña;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Empleado() {
		super();
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	
	public String toString() {
		return super.toString()+"\nEstado Civil:"+getEstadoCivil()+"\nLegajo:"+getLegajo()+"\nContraseña:"+getContraseña();
	}
	
	
	/**
	 * Metodo abstracto que retorna el tipo de empleado.
	 * @return el tipo de empleado en forma de String.
	 */
	public abstract String tipoEmpleado();
}
