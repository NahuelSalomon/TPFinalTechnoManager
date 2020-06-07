package ClasesPersona;

import java.util.Date;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String dni;
	private String genero;
	private Date fechaNac;
	
	public Persona(String nombre, String apellido, String dni, String genero, Date fechaNac) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.genero = comprobarGenero(genero);
		this.fechaNac = fechaNac;
	}

	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public String getGenero() {
		return genero;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setGenero(String genero) {
		this.genero = comprobarGenero(genero);
	}
	
	public String comprobarGenero(String genero) {
		String generoComprobado = "Personalizado";
		
		if(genero.equalsIgnoreCase("Masculino") && genero.equalsIgnoreCase("Femenino") && genero.equalsIgnoreCase("Personalizado")) {
			generoComprobado = genero;
		}
		
		
		return generoComprobado;
	}
	
	
}