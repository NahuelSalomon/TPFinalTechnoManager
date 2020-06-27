package ClasesPersona;


import org.json.JSONException;
import org.json.JSONObject;

/**
 * Subclase vendedor que extiende de empleado.
 * 
 * @author Nahuel
 *
 */
public class Vendedor extends Empleado {

	

	private static final long serialVersionUID = 1L;

	private String telefono;

	public Vendedor() {
		super();
		this.telefono = null;
	}

	public Vendedor(String nombre, String apellido, String legajo, String contraseña) {
		super(nombre, apellido, legajo, contraseña);
		this.telefono = null;
	}
	
	public Vendedor(String nombre, String apellido, String dni, int genero, String fechaNac, int estadoCivil,
			String telefono, String legajo, String contraseña) {
		super(nombre, apellido, dni, genero, fechaNac, estadoCivil, legajo, contraseña);
		this.telefono = telefono;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String toString() {
		return super.toString() + "\nTelefono:" + getTelefono() + "Tipo de empleado: " + tipoEmpleado();
	}

	@Override
	public String tipoEmpleado() {
		return "vendedor";
	}

	@Override
	public JSONObject toJSONObject() throws JSONException { 
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject = super.toJSONObject();
		jsonObject.put("Telefono: ", getTelefono());
		
		return jsonObject;
	}

	public Vendedor JSONObjectToVendedor(JSONObject jsonObject) throws JSONException { 
			
		String nombre = jsonObject.getString("Nombre");
		String apellido = jsonObject.getString("Apellido");
		String dni = jsonObject.getString("DNI");
		Integer genero = jsonObject.getInt("Genero");
		String fechaNac = jsonObject.getString("Fehca de naciemiento");
		Integer estadoCivil = jsonObject.getInt("Estado civil");
		String telefono = jsonObject.getString("Telefono");
		String legajo = jsonObject.getString("Legajo");
		String contraseña = jsonObject.getString("Contraseña");
		
		Vendedor vendedor = new Vendedor(nombre, apellido, dni, genero, fechaNac, estadoCivil, telefono, legajo, contraseña);
			
		return vendedor;
		}
	

	
	
}
