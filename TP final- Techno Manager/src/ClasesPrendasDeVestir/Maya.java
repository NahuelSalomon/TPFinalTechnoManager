package ClasesPrendasDeVestir;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase para definir objetos del tipo remera Hija de clase abstracta
 * PrendaDeVestir y de PrendaInferior
 * 
 * @author Techno Manager
 *
 */
public class Maya extends PrendaInferior implements Serializable{

	private boolean esSecadoRapido;
	private boolean esPorArribaRodillas;

	public Maya() {
		super();
		this.esSecadoRapido = (Boolean) null;
		this.esPorArribaRodillas = (Boolean) null;
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
		jsonObject.put("Es secado rapido: ", getEsSecadoRapido());
		jsonObject.put("Es por arriba de rodillas: ", getEsPorArribaRodillas());
	
	return jsonObject;
	}
		
}
