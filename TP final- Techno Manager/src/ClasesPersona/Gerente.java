package ClasesPersona;

import java.util.Date;

public class Gerente extends Empleado{

	public Gerente() {
		super();
	}

	public Gerente(String nombre, String apellido, String dni, String genero, Date fechaNac, String estadoCivil,
			String legajo, String contrase�a) {
		super(nombre, apellido, dni, genero, fechaNac, estadoCivil, legajo, contrase�a);
	}	
}
