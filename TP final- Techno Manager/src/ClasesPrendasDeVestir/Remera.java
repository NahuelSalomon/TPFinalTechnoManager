package ClasesPrendasDeVestir;


import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase para definir objetos del tipo remera Hija de clase abstracta
 * PrendaDeVestir y de PrendaSuperior
 * 
 * @author Techno Manager
 *
 */
public class Remera extends PrendaSuperior {



	private static final long serialVersionUID = 1L;

	private String tipoEstampado;

	public Remera() {
		super();
		this.tipoEstampado = null;
	}

	public Remera(int marca, String modelo, String color, int tipoDeMaterial, boolean esMangaCorta,
			String tipoEstampado) {
		super(marca, modelo, color, tipoDeMaterial, esMangaCorta);
		this.tipoEstampado = tipoEstampado;
	}

	public String getTipoEstampado() {
		return tipoEstampado;
	}

	public void setTipoEstampado(String tipoEstampado) {
		this.tipoEstampado = tipoEstampado;
	}
	
	

	@Override
	public String tipoDePrenda() {
		return "Remera";
	}

	@Override
	public JSONObject toJSONObject() throws JSONException { 
		JSONObject jsonObject = new JSONObject();
	
		jsonObject = super.toJSONObject();
		jsonObject.put("Tipo de estampado: ", getTipoEstampado());
	
	return jsonObject;
	}
	
	public static Remera fromJSONObject(JSONObject jsonObject) throws JSONException {
		
		String codigo = jsonObject.getString("Codigo");
		int marca = jsonObject.getInt("Marca");
		String modelo = jsonObject.getString("Modelo");
		String color = jsonObject.getString("Color");
		int tipoDeMaterial = jsonObject.getInt("Tipo de material");
		boolean esMangaCorta = jsonObject.getBoolean("Es manga corta");
		HashMap<String, Integer> tallesYStock = TallesYStock.fromJSONObject(jsonObject.getJSONObject("Talles y stock"));
		
		
		
		Remera remera = new Remera(marca, modelo, color, tipoDeMaterial, esMangaCorta, color);
		remera.setCodigo(codigo);
		remera.agregarVariosTallesYCantidad(tallesYStock);
		
		return remera;
	}
	
	

	@Override
	public String toString() {
		return super.toString() + "\nTipo de estampado: " + getTipoEstampado();
	}
}
