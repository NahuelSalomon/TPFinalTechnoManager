package ClasesPersona;

import java.util.Date;

/**
 * Clase gerente que extiende de empleado.
 * 
 * @author Nahuel
 *
 */
public class Gerente extends Empleado {

	public Gerente() {
		super();
	}
	
	public Gerente(String nombre, String apellido, String legajo, String contraseña) {
		super(nombre, apellido, legajo, contraseña);
	}

	public Gerente(String nombre, String apellido, String dni, int genero, Date fechaNac, int estadoCivil,
			String legajo, String contraseña) {
		super(nombre, apellido, dni, genero, fechaNac, estadoCivil, legajo, contraseña);
	}

	@Override
	public String toString() {
		return super.toString() + "Tipo de empleado: " + tipoEmpleado();
	}

	@Override
	public String tipoEmpleado() {
		return "Gerente";
	}

}
