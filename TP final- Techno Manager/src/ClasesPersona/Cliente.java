package ClasesPersona;

import java.util.Date;

/**
 * Clase que engloba todas las características de un cliente. No se puede
 * instanciar esta clase ya que se tiene que definir de que tipo es el cliente.
 * 
 * @author Nahuel
 *
 */
public class Cliente extends Persona {

	private String domicilio;
	private String email;

	public Cliente() {
		super(null, null, null, 0, null);
		this.email = null;
		this.domicilio = null;
	}
	
	public Cliente(String nombre, String apellido) {
		super(nombre, apellido);
		this.email = null;
		this.domicilio = null;
	}

	public Cliente(String nombre, String apellido, String dni, int genero, Date fechaNac, String domicilio,
			String email) {
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

	public String tipoDeCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return super.toString() + "\nDomicilio: " + getDomicilio() + "\nEmail: " + getEmail();
	}

	/**
	 * Metodo que devuelve el tipo de cliente
	 * 
	 * @return el tipo de cliente en forma de String
	 */
	// public abstract String tipoDeCliente();
}
