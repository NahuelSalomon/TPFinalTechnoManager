package ClasesPersona;

import java.util.Date;

/**
 * Super clase Persona, reune todas las caracteristicas de todas las clases que sean "personas".
 * @author Nicolas
 *
 */
public class Persona {
	
	private String nombre;
	private String apellido;
	private String dni;
	private String genero;
	private Date fechaNac;
	
	public Persona(){
		super();
	}
	
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
	
	/**
	 * Método para comprobar que el genero ingresado sea correcto, solo hay tres opciones. 
	 * @param genero es el genero a comprobar
	 * @return el genero comprobado, si es incorrecto asigna "Personalizado" por default 
	 */
	public String comprobarGenero(String genero) {
		String generoComprobado = "Personalizado";
		
		if(genero.equalsIgnoreCase("Masculino") || genero.equalsIgnoreCase("Femenino")
				|| genero.equalsIgnoreCase("Personalizado")) {
			generoComprobado = genero;
		}
		return generoComprobado;
	}
	
	@Override
	public String toString() {
		return "Nombre: "+getNombre()+"\nApellido: "+getApellido()+"\nDNI: "+getDni()+
				"\nGenero: "+getGenero()+"\nFecha de nacimiento:"+getFechaNac();
	}
	
	
}
