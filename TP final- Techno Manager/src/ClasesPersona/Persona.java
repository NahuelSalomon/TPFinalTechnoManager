package ClasesPersona;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Super clase Persona, reune todas las caracteristicas de todas las clases que
 * sean "personas".
 * 
 * @author Nicolas
 *
 */
public class Persona implements Serializable {

	private String nombre;
	private String apellido;
	private String dni;
	private int genero;
	private String fechaNac;

	public Persona() {
		super();
	}
	
	public Persona(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = null;
		this.genero = 0;
		this.fechaNac = null;
	}

	public Persona(String nombre, String apellido, String dni, int genero, String fechaNac) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.genero = genero;
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

	public int getGeneroInt() {
		return this.genero;
	}
	
	public String getGenero() {
		String rta = "";
		switch(this.genero) {
		case(1):
			rta = "Masculino";
			break;
		case(2):
			rta = "Femenino";
			break;
		case(3):
			rta = "Otros";
			break;
		default:
			rta = "No definido";
			break;
		}
		return rta;
	}
	
	public String getFechaNac() {
		return fechaNac.toString();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	/**
	 * Metodo que conviete una persona a un objeto de json
	 * @return la persona en forma de JSONObject
	 * @throws JSONException
	 */
	public JSONObject toJSONObject() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("Nombre", getNombre());
		jsonObject.put("Apellido", getApellido());
		jsonObject.put("DNI", getDni());
		jsonObject.put("Genero", getGenero());
		jsonObject.put("Fecha de nac", getFechaNac());
		
		return jsonObject;
	}
	
	public static Persona JSONObjectToPersona(JSONObject jsonObject) throws JSONException {
		
		String nombre = jsonObject.getString("Nombre"); 
		String apellido = jsonObject.getString("Apellido");
		String DNI = jsonObject.getString("DNI");
		Integer genero = jsonObject.getInt("Genero");
		String fechaNac = jsonObject.getString("Fecha de nac");
		Persona persona = new Persona(nombre, apellido, DNI, genero, fechaNac);
		
		return persona; 
	}
	
	@Override
	public String toString() {
		return "Nombre: " + getNombre() + "\nApellido: " + getApellido() + "\nDNI: " + getDni() + "\nGenero: "
				+ getGenero() + "\nFecha de nacimiento:" + getFechaNac();
	}

}
