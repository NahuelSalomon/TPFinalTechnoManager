package ClasesPrendasDeVestir;



import java.util.Collection;
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
public class Buzo extends PrendaSuperior {

	
	private static final long serialVersionUID = 1L;
	private boolean esTipoCanguro;

	public Buzo() {
		super();
		this.esTipoCanguro = false;
	}

	public Buzo(int marca, String modelo, String color, int tipoDeMaterial, boolean esMangaCorta, boolean esTipoCanguro, double precio) {
		super(marca, modelo, color, tipoDeMaterial, esMangaCorta, precio);
		this.esTipoCanguro = esTipoCanguro;
	}

	public boolean esTipoCanguro() {
		return esTipoCanguro;
	}

	public String getEsTipoCanguro() {
		String rta = "";
		if(esTipoCanguro) rta = "Tiene Canguro";
		if(!esTipoCanguro) rta = "No tiene Canguro";
		else rta = "No definido";
		return rta;
	}

	public void setEsTipoCanguro(boolean esTipoCanguro) {
		this.esTipoCanguro = esTipoCanguro;
	}

	
	
	private boolean getEsTipoCanguroBoolean() {
		return esTipoCanguro;
	}

	/**
	 * Metodo para importar un Buzo desde un objeto JSON
	 * @param jsonObject a importar
	 * @return el Buzo
	 * @throws JSONException
	 */
	public static Buzo fromJSONObject(JSONObject jsonObject) throws JSONException {
		
		String codigo = jsonObject.getString("Codigo");
		int marca = jsonObject.getInt("Marca");
		String modelo = jsonObject.getString("Modelo");
		String color = jsonObject.getString("Color");
		int tipoDeMaterial = jsonObject.getInt("Tipo de material");
		boolean esMangaCorta = jsonObject.getBoolean("Es manga corta");
		boolean esTipoCanguro = jsonObject.getBoolean("Es tipo canguro");
		double precio = jsonObject.getDouble("Precio");
		HashMap<String, Integer> tallesYStock = TallesYStock.fromJSONObject(jsonObject.getJSONObject("Talles y stock"));		
		
		
		Buzo buzo = new Buzo(marca, modelo, color, tipoDeMaterial, esMangaCorta, esTipoCanguro, precio);
		buzo.setCodigo(codigo);
		buzo.agregarVariosTallesYCantidad(tallesYStock);
		
		
		
		return buzo;
	}
	
	@Override
	public String tipoDePrenda() {
		return "Buzo";
	}

	@Override
	public JSONObject toJSONObject() throws JSONException { 
		JSONObject jsonObject = new JSONObject();
	
		jsonObject = super.toJSONObject();
		jsonObject.put("Es tipo canguro", getEsTipoCanguroBoolean());
	
	return jsonObject;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nEs tipo canguro: " + esTipoCanguro()+"\n";
	}
}
