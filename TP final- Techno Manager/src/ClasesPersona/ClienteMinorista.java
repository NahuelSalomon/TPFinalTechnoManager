package ClasesPersona;



import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase que extiende de cliente, este es un cliente mayorista.
 * 
 * @author Nahuel
 *
 */
public class ClienteMinorista extends Cliente {

	
	private static final long serialVersionUID = 1L;

	public ClienteMinorista() {
		super();
	}
	
	public ClienteMinorista(String nombre, String apellido) {
		super(nombre, apellido);
	}

	public ClienteMinorista(String nombre, String apellido, String dni, int genero, String fechaNac, 
			String domicilio, String email) {
		super(nombre, apellido, dni, genero, fechaNac, domicilio, email);
	}

	@Override
	public String toString() {
		return super.toString()+"\n\n";
	}

	@Override
	public String tipoDeCliente() {
		return "Minorista";
	}

	@Override
	public JSONObject toJSONObject() throws JSONException {	
		return super.toJSONObject();
	}
	
	/**
	 * Metodo para importar un cliente minorista desde un objeto JSON
	 * @param jsonObject a importar
	 * @return el cliente minorista
	 * @throws JSONException
	 */
	public static ClienteMinorista fromJSONObject(JSONObject jsonObject) throws JSONException {	 
		
		String nombre = jsonObject.getString("Nombre");
		String apellido = jsonObject.getString("Apellido");
		String dni = jsonObject.getString("DNI");
		Integer genero = jsonObject.getInt("Genero");
		String fechaNac = jsonObject.getString("Fecha de nac");
		String domicilio = jsonObject.getString("Domicilio");
		String email = jsonObject.getString("Email");
		
		ClienteMinorista clienteMinorista = new ClienteMinorista(nombre, apellido, dni, genero, fechaNac, domicilio, email);
		
		return clienteMinorista;
	}
}
