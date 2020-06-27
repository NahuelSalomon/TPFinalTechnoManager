package ClasesPersona;




import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase que extiende de cliente, este es un cliente minorista.
 * 
 * @author Nahuel
 *
 */
public class ClienteMayorista extends Cliente {

	
	private static final long serialVersionUID = 1L;
	private String cuil;
	private int condicionFrenteIVA;

	public ClienteMayorista() {
		super();
		this.cuil = null;
		this.condicionFrenteIVA = 0; 
	}
	
	public ClienteMayorista(String nombre, String apellido, String cuil, int condicionFrenteIVA) {
		super(nombre, apellido);
		this.cuil = cuil;
		this.condicionFrenteIVA = condicionFrenteIVA;
	}

	public ClienteMayorista(String nombre, String apellido, String dni, int genero, String fechaNac,
			String domicilio, String email, String cuil, int condicionFrenteIVA) {
		super(nombre, apellido, dni, genero, fechaNac, domicilio, email);
		this.cuil = cuil;
		this.condicionFrenteIVA = condicionFrenteIVA;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public int getCondicionFrenteIVAInt() {
		return this.condicionFrenteIVA;
	}
	
	public String getCondicionFrenteIVA() {
		String rta = "";
		switch(this.condicionFrenteIVA) {
		case(1):
			rta = "Responsable Inscripto";
			break;
		case(2):
			rta = "Monotributista";
			break;
		case(3):
			rta = "Exento";
			break;
		case(4):
			rta = "No Responsable";
			break;
		case(5):
			rta = "Consumidor Final";
			break;
		default:
			rta = "No definido";
			break;
		}
		return rta;
	}

	public void setCondicionFrenteIVA(int condicionFrenteIVA) {
		this.condicionFrenteIVA = condicionFrenteIVA;
	}

	@Override
	public String toString() {
		return super.toString() + "\nCUIL: " + getCuil() + "\nCondicion frente al IVA: " + getCondicionFrenteIVA();
	}

	@Override
	public String tipoDeCliente() {
		return "Mayorista";
	}

	@Override
	public JSONObject toJSONObject() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		
		jsonObject = super.toJSONObject();
		jsonObject.put("CUIL", getCuil());
		jsonObject.put("Condicion frente al IVA", getCondicionFrenteIVAInt());
		
	return jsonObject;
	}

	public ClienteMayorista JSONObjectToClienteMayorista (JSONObject jsonObject) throws JSONException { 
		
		String nombre = jsonObject.getString("Nombre");
		String apellido = jsonObject.getString("Apellido");
		String dni = jsonObject.getString("DNI");
		int genero = jsonObject.getInt("Genero");
		String fechaNac = jsonObject.getString("Fecha de nac");
		String domicilio = jsonObject.getString("Domicilio");
		String email = jsonObject.getString("Email");
		String cuil = jsonObject.getString("CUIL");
		int condicionFrenteIVA = jsonObject.getInt("Condicion frente al IVA");
		
	ClienteMayorista clienteMayorista = new ClienteMayorista(nombre, apellido, dni, genero, fechaNac, domicilio, email, cuil, condicionFrenteIVA);
	
	return clienteMayorista; 
			
	}
}
