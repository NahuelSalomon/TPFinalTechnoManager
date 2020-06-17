package ClasesPersona;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase que engloba todas las caracter�sticas de un empleado. No puede ser
 * instanciada con el objetivo de que se tiene que definir el tipo de empleado.
 * 
 * @author Nahuel
 *
 */
public abstract class Empleado extends Persona implements Serializable{
	private int estadoCivil;
	private String legajo;
	private String contrase�a;
	
	public Empleado() {
		super();
		this.estadoCivil = 0;
		this.legajo = null;
		this.contrase�a = null;
	}
	
	public Empleado(String nombre, String apellido, String legajo, String contrase�a) {
		super(nombre, apellido);
		this.estadoCivil = 0;
		this.legajo = legajo;
		this.contrase�a = contrase�a;
	}

	public Empleado(String nombre, String apellido, String dni, int genero, String fechaNac, int estadoCivil,
			String legajo, String contrase�a) {
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

	public int getEstadoCivilInt() {
		return this.estadoCivil;
	}
	
	public String getEstadoCivil() {
		String rta = "";
		switch(this.estadoCivil) {
		case(1):
			rta = "Soltero/a";
			break;
		case(2):
			rta = "Comprometido/a";
			break;
		case(3):
			rta = "Noviazgo";
			break;
		case(4):
			rta = "Relacion";
			break;
		case(5):
			rta = "Casado/a";
			break;
		case(6):
			rta = "Union Libre";
			break;
		case(7):
			rta = "Separado/a";
			break;
		case(8):
			rta = "Divorciado/a";
			break;
		case(9):
			rta = "Viudo/a";
			break;
		default:
			rta = "No definido";
			break;
		}
		return rta;
	}

	public void setEstadoCivil(int estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String toString() {
		return super.toString() + "\nEstado Civil:" + getEstadoCivil() + "\nLegajo:" + getLegajo() + 
				"\nContrase�a:"+ getContrase�a();
	}

	/**
	 * Metodo abstracto que retorna el tipo de empleado.
	 * @return el tipo de empleado en forma de String.
	 */
	public abstract String tipoEmpleado();
	
	@Override
	public JSONObject toJSONObject() throws JSONException { 
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject = super.toJSONObject();
		jsonObject.put("Empleado: ", tipoEmpleado());
		jsonObject.put("Legajo: ", getLegajo());
		jsonObject.put("Estado civil: ", getEstadoCivil());
		jsonObject.put("Contrase�a: ", getContrase�a());
		
	return jsonObject;
	}
	
	

}
