package ClasesPrendasDeVestir;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase para definir objetos del tipo remera Hija de clase abstracta
 * PrendaDeVestir y de PrendaSuperior
 * 
 * @author Techno Manager
 *
 */
public class Buzo extends PrendaSuperior implements Serializable{

	private boolean esTipoCanguro;

	public Buzo() {
		super();
		this.esTipoCanguro = (Boolean) null;
	}

	public Buzo(int marca, String modelo, String color, int tipoDeMaterial, boolean esMangaCorta, boolean esTipoCanguro) {
		super(marca, modelo, color, tipoDeMaterial, esMangaCorta);
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

	@Override
	public String tipoDePrenda() {
		return "Buzo";
	}

	@Override
	public JSONObject toJSONObject() throws JSONException { 
		JSONObject jsonObject = new JSONObject();
	
		jsonObject = super.toJSONObject();
		jsonObject.put("Es tipo canguro: ", getEsTipoCanguro());
	
	return jsonObject;
	}
	
	public String toString() {
		return super.toString() + "\nEs tipo canguro: " + esTipoCanguro();
	}
}
