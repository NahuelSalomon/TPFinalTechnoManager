package ClasesPersona;

import java.util.Date;

/**
 * Clase gerente que extiende de empleado. 
 * @author Nahuel
 *
 */
public class Gerente extends Empleado{

	public Gerente() {
		super();
	}

	public Gerente(String nombre, String apellido, String dni, String genero, Date fechaNac, String estadoCivil,
			String legajo, String contraseña) {
		super(nombre, apellido, dni, genero, fechaNac, estadoCivil, legajo, contraseña);
	}

	@Override
	public String toString() {
		return super.toString()+"Tipo de empleado: "+tipoEmpleado();
	}

	@Override
	public String tipoEmpleado() {
		return "Gerente";
	}
	
}
