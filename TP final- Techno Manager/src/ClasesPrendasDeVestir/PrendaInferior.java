package ClasesPrendasDeVestir;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase para prendas inferiores de ropa Es abstracta con la finalidad de que
 * una prenda inferior tiene que ser bien definida que tipo de prenda es
 * 
 * @author Techno Manager
 *
 */
public abstract class PrendaInferior extends PrendaDeVestir implements Serializable{


	public PrendaInferior() {
		super();
	}

	public PrendaInferior(int marca, String modelo, String color, int tipoDeMaterial) {
		super(marca, modelo, color, tipoDeMaterial);
	}

	public String toString() {
		return super.toString();
	}

	@Override
	public JSONObject toJSONObject() throws JSONException { 
		return super.toJSONObject();
	}
	
}
