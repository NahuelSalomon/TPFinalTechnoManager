package ClasesPrendasDeVestir;



import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase para prendas superiores de ropa Es abstracta con la finalidad de que
 * una prenda superior tiene que ser bien definida que tipo de prenda es
 * 
 * @author Techno Manager
 *
 */
public abstract class PrendaSuperior extends PrendaDeVestir {

	
	private static final long serialVersionUID = 1L;
	
	private boolean esMangaCorta;

	public PrendaSuperior() {
		super();
		this.esMangaCorta = false;
	}

	public PrendaSuperior(int marca, String modelo, String color, int tipoDeMaterial, boolean esMangaCorta) {
		super(marca, modelo, color, tipoDeMaterial);
		this.esMangaCorta = esMangaCorta;
	}

	public String getEsMangaCorta() {
		String rta = "";
		if(esMangaCorta) rta = "Es manga corta";
		if(!esMangaCorta) rta = "No es manga corta";
		else rta = "No definido";
		return rta;
	}

	public void setEsMangaCorta(boolean esMangaCorta) {
		this.esMangaCorta = esMangaCorta;
	}

	public String toString() {
		return super.toString() + "\n" + getEsMangaCorta();
	}
	
	@Override
	public JSONObject toJSONObject() throws JSONException { 
		JSONObject jsonObject = new JSONObject();
	
		jsonObject = super.toJSONObject();
		jsonObject.put("Es manga corta", getEsMangaCorta());
	
	return jsonObject;
	}

}
