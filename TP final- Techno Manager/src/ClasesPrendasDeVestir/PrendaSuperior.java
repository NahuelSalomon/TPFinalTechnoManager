package ClasesPrendasDeVestir;



import java.util.Collection;

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

	public PrendaSuperior(int marca, String modelo, String color, int tipoDeMaterial, boolean esMangaCorta, double precio) {
		super(marca, modelo, color, tipoDeMaterial, precio);
		this.esMangaCorta = esMangaCorta;
	}

	public boolean esMangaCorta() {
		return esMangaCorta;
	}
	
	public String getEsMangaCorta() {
		String rta = "";
		
		if(esMangaCorta) {
			rta = "Si";
		}
		else {
			if(!esMangaCorta) {
				rta = "No";
			}
			else {
				rta = "No definido";
			} 
		}
		return rta;
	}

	public void setEsMangaCorta(boolean esMangaCorta) {
		this.esMangaCorta = esMangaCorta;
	}
	
	@Override
	public String toString() {
		return super.toString() +"\nEs manga corta: "+getEsMangaCorta();
	}
	
	@Override
	public JSONObject toJSONObject() throws JSONException { 
		JSONObject jsonObject = new JSONObject();
	
		jsonObject = super.toJSONObject();
		jsonObject.put("Es manga corta", getEsMangaCortaBoolean());
	
	return jsonObject;
	}

	private boolean getEsMangaCortaBoolean() {
		return esMangaCorta;
	}

}
