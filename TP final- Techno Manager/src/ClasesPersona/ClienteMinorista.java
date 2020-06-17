package ClasesPersona;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase que extiende de cliente, este es un cliente mayorista.
 * 
 * @author Nahuel
 *
 */
public class ClienteMinorista extends Cliente implements Serializable{

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
		return super.toString();
	}

	@Override
	public String tipoDeCliente() {
		return "Minorista";
	}

	@Override
	public JSONObject toJSONObject() throws JSONException {	
		return super.toJSONObject();
	}
	

	
}
