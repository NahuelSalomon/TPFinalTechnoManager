package ClasesPersona;

import java.util.Date;

/**
 * Clase que engloba todas las caracterÝsticas de un cliente.
 * No se puede instanciar esta clase ya que se tiene que definir de que tipo es el cliente. 
 * @author Nahuel
 *
 */
public abstract class Cliente extends Persona {

	private String domicilio;
	private String email;
	
	public Cliente() {
		super();
	}
	
	
	public Cliente(String nombre, String apellido, String dni, String genero, Date fechaNac, String domicilio, String email) {
		super(nombre, apellido, dni, genero, fechaNac);
		this.email = email;
		this.domicilio = domicilio;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Metodo que devuelve el tipo de cliente 
	 * @return el tipo de cliente en forma de String
	 */
	public abstract String tipoDeCliente();
}
