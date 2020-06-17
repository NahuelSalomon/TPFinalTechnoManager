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
public class Remera extends PrendaSuperior implements Serializable{

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
	
	public String toString() {
		return super.toString() + "\nTipo de estampado: " + getTipoEstampado();
	}
}
