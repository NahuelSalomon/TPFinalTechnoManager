package ClasesPersona;




import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase que engloba todas las características de un cliente. No se puede
 * instanciar esta clase ya que se tiene que definir de que tipo es el cliente.
 * 
 * @author Nahuel
 *
 */
public abstract class Cliente extends Persona  {

	
	private static final long serialVersionUID = 1L;
	
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

	public Cliente(String nombre, String apellido, String dni, int genero, String fechaNac, String domicilio,
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

	@Override
	public JSONObject toJSONObject() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		
		jsonObject = super.toJSONObject();
		jsonObject.put("Tipo de cliente: ", tipoDeCliente());
		jsonObject.put("Domicilio: ", getDomicilio());
		jsonObject.put("Email: ", getEmail());
		
	return jsonObject;
	}
	
	


	@Override
	public String toString() {
		return super.toString() + "\nDomicilio: " + getDomicilio() + "\nEmail: " + getEmail();
	}

	/**
	 * Metodo que devuelve el tipo de cliente
	 * @return el tipo de cliente en forma de String
	 */
	public abstract String tipoDeCliente();

	
	
	
}
