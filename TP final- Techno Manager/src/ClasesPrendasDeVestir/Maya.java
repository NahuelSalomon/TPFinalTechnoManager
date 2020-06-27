package ClasesPrendasDeVestir;



import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase para definir objetos del tipo remera Hija de clase abstracta
 * PrendaDeVestir y de PrendaInferior
 * 
 * @author Techno Manager
 *
 */
public class Maya extends PrendaInferior {

	
	private static final long serialVersionUID = 1L;
	
	private boolean esSecadoRapido;
	private boolean esPorArribaRodillas;

	public Maya() {
		super();
		this.esSecadoRapido = false;
		this.esPorArribaRodillas = false;
	}

	public Maya(int marca, String modelo, String color, int tipoDeMaterial, 
			boolean esSecadoRapido,	boolean esPorArribaRodillas) {
		super(marca, modelo, color, tipoDeMaterial);
		this.esSecadoRapido = esSecadoRapido;
		this.esPorArribaRodillas = esPorArribaRodillas;
	}

	public boolean isEsSecadoRapido() {
		return esSecadoRapido;
	}

	public void setEsSecadoRapido(boolean esSecadoRapido) {
		this.esSecadoRapido = esSecadoRapido;
	}
	
	public String getEsSecadoRapido() {
		String rta = "";
		if(esSecadoRapido) rta = "Es secado rapido";
		if(!esSecadoRapido) rta = "No es secado rapido";
		else rta = "No definido";
		return rta;
	}
	
	public boolean isEsPorArribaRodillas() {
		return esPorArribaRodillas;
	}

	public void setEsPorArribaRodillas(boolean esPorArribaRodillas) {
		this.esPorArribaRodillas = esPorArribaRodillas;
	}
	
	public String getEsPorArribaRodillas() {
		String rta = "";
		if(esPorArribaRodillas) rta = "No cubre las rodilla";
		if(!esPorArribaRodillas) rta = "Cubre las rodilla";
		else rta = "No definido";
		return rta;
	}

	@Override
	public String tipoDePrenda() {
		return "Maya";
	}

	public String toString() {
		return super.toString() + "\n" + getEsSecadoRapido() + "\n" + getEsPorArribaRodillas();
	}
	
	@Override
	public JSONObject toJSONObject() throws JSONException { 
		JSONObject jsonObject = new JSONObject();
	
		jsonObject = super.toJSONObject();
		jsonObject.put("Es secado rapido", getEsSecadoRapido());
		jsonObject.put("Es por arriba de rodillas", getEsPorArribaRodillas());
	
	return jsonObject;
	}
	
	public static Maya fromJSONObject(JSONObject jsonObject) throws JSONException {
		
		String codigo = jsonObject.getString("Codigo");
		int marca = jsonObject.getInt("Marca");
		String modelo = jsonObject.getString("Modelo");
		String color = jsonObject.getString("Color");
		int tipoDeMaterial = jsonObject.getInt("Tipo de material");
		boolean esSecadoRapido = jsonObject.getBoolean("Es secado rapido");
		boolean esPorArribaRodillas = jsonObject.getBoolean("Es por arriba de rodillas");
		HashMap<String, Integer> tallesYStock = TallesYStock.fromJSONObject(jsonObject.getJSONObject("Talles y stock"));		
	
		
		Maya maya = new Maya(marca, modelo, color, tipoDeMaterial, esSecadoRapido, esPorArribaRodillas);
		maya.setCodigo(codigo);
		maya.agregarVariosTallesYCantidad(tallesYStock);
		
		return maya;
	}
		
}
