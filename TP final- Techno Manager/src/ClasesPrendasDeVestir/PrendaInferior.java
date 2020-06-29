package ClasesPrendasDeVestir;



import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase para prendas inferiores de ropa Es abstracta con la finalidad de que
 * una prenda inferior tiene que ser bien definida que tipo de prenda es
 * 
 * @author Techno Manager
 *
 */
public abstract class PrendaInferior extends PrendaDeVestir {


	
	private static final long serialVersionUID = 1L;

	public PrendaInferior() {
		super();
	}

	public PrendaInferior(int marca, String modelo, String color, int tipoDeMaterial, double precio) {
		super(marca, modelo, color, tipoDeMaterial, precio);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public JSONObject toJSONObject() throws JSONException { 
		return super.toJSONObject();
	}
	
}
