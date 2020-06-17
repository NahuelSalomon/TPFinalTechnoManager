package ClasesPersona;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase gerente que extiende de empleado.
 * 
 * @author Nahuel
 *
 */
public class Gerente extends Empleado implements Serializable{

	public Gerente() {
		super();
	}
	
	public Gerente(String nombre, String apellido, String legajo, String contraseña) {
		super(nombre, apellido, legajo, contraseña);
	}

	public Gerente(String nombre, String apellido, String dni, int genero, String fechaNac, int estadoCivil,
			String legajo, String contraseña) {
		super(nombre, apellido, dni, genero, fechaNac, estadoCivil, legajo, contraseña);
	}

	@Override
	public String toString() {
		return super.toString() + "Tipo de empleado: " + tipoEmpleado();
	}

	@Override
	public String tipoEmpleado() {
		return "Gerente";
	}
	
	@Override
	public JSONObject toJSONObject() throws JSONException { 
		return super.toJSONObject();
	}

	public Gerente JSONObjectToGerente(JSONObject jsonObject) throws JSONException { 
		
		String nombre = jsonObject.getString("Nombre");
		String apellido = jsonObject.getString("Apellido");
		String dni = jsonObject.getString("DNI");
		Integer genero = jsonObject.getInt("Genero");
		String fechaNac = jsonObject.getString("Fehca de naciemiento");
		Integer estadoCivil = jsonObject.getInt("Estado civil");
		String legajo = jsonObject.getString("Legajo");
		String contraseña = jsonObject.getString("Contraseña");
		
		Gerente gerente = new Gerente(nombre, apellido, dni, genero, fechaNac, estadoCivil, legajo, contraseña);
			
		return gerente;
		}
	

}
