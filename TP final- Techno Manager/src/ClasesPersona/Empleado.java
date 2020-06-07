package ClasesPersona;

import java.util.Date;

public class Empleado extends Persona{
	private String estadoCivil;
	private String legajo;
	private String contrase�a;

	public Empleado(String nombre, String apellido, String dni, String genero, Date fechaNac,
			String estadoCivil, String legajo, String contrase�a) {
		super(nombre, apellido, dni, genero, fechaNac);
		this.estadoCivil = estadoCivil;
		this.legajo = legajo;
		this.contrase�a = contrase�a;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
		return super.toString()+"\nEstado Civil:"+getEstadoCivil()+"\nLegajo:"+getLegajo()+"\nContrase�a:"+getContrase�a();
	}
	
}
