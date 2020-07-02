package ClasesPrendasDeVestir;



import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase para definir objetos del tipo remera Hija de clase abstracta
 * PrendaDeVestir
 * 
 * @author Techno Manager
 *
 */
public class Calzado extends PrendaDeVestir {



	private static final long serialVersionUID = 1L;

	private int tipoDeSuela;

	public Calzado() {
		super();
		this.tipoDeSuela = 0;
	}

	public Calzado(int marca, String modelo, String color, int tipoDeMaterial, int tipoDeSuela, double precio) {
		super(marca, modelo, color, tipoDeMaterial, precio);
		this.tipoDeSuela = tipoDeSuela;
	}
	
	public void setTipoDeSuela(int tipoDeSuela) {
		this.tipoDeSuela = tipoDeSuela;
	}
	
	public int getTipoDeSuelaInt() {
		return this.tipoDeSuela;
	}

	public String getTipoDeSuela() {
		String rta = "";
		switch(this.tipoDeSuela) {
		case(1):
			rta = "Poliuretano";
			break;
		case(2):
			rta = "Crepe";
			break;
		case(3):
			rta = "Cuero";
			break;
		default:
			rta = "No definido";
			break;
		}
		return rta;
	}

	@Override
	public String tipoDePrenda() {
		return "Calzado";
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nTipo de suela: " + getTipoDeSuela()+"\n";
	}

	@Override
	public JSONObject toJSONObject() throws JSONException { 
		JSONObject jsonObject = new JSONObject();
	
		jsonObject = super.toJSONObject();
		jsonObject.put("Tipo de suela", getTipoDeSuela());
	
	return jsonObject;
	}
	
	/**
	 * Metodo para importar calzado desde un objeto JSON
	 * @param jsonObject a importar
	 * @return el Calzado
	 * @throws JSONException
	 */
	public static Calzado fromJSONObject(JSONObject jsonObject) throws JSONException {
		
		String codigo = jsonObject.getString("Codigo");
		int marca = jsonObject.getInt("Marca");
		String modelo = jsonObject.getString("Modelo");
		String color = jsonObject.getString("Color");
		int tipoDeMaterial = jsonObject.getInt("Tipo de material");
		int tipoDeSuela = jsonObject.getInt("Tipo de suela");
		double precio = jsonObject.getDouble("Precio");
		HashMap<String, Integer> tallesYStock = TallesYStock.fromJSONObject(jsonObject.getJSONObject("Talles y stock"));		
	
		
		Calzado calzado = new Calzado(marca, modelo, color, tipoDeMaterial, tipoDeSuela, precio);
		calzado.setCodigo(codigo);
		calzado.agregarVariosTallesYCantidad(tallesYStock);
		
		return calzado;
	}
	
}
