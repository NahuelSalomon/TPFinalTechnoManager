package ClasesPrendasDeVestir;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase para definir objetos del tipo remera Hija de clase abstracta
 * PrendaDeVestir
 * 
 * @author Techno Manager
 *
 */
public class Calzado extends PrendaDeVestir implements Serializable{

	private int tipoDeSuela;

	public Calzado() {
		super();
		this.tipoDeSuela = 0;
	}

	public Calzado(int marca, String modelo, String color, int tipoDeMaterial, int tipoDeSuela) {
		super(marca, modelo, color, tipoDeMaterial);
		this.tipoDeSuela = tipoDeSuela;
	}
	
	public void setTipoDeSuela(int tipoDeSuela) {
		this.tipoDeSuela = tipoDeSuela;
	}

	public String getTipoDeSuela() {
		String rta = "";
		switch(this.tipoDeSuela) {
		case(1):
			rta = "Poliuretano";
			break;
		case(2):
			rta = "Crepe";
			break;
		case(3):
			rta = "Cuero";
			break;
		default:
			rta = "No definido";
			break;
		}
		return rta;
	}

	@Override
	public String tipoDePrenda() {
		return "Calzado";
	}

	public String toString() {
		return super.toString() + "\nTipo de suela: " + getTipoDeSuela();
	}

	@Override
	public JSONObject toJSONObject() throws JSONException { 
		JSONObject jsonObject = new JSONObject();
	
		jsonObject = super.toJSONObject();
		jsonObject.put("Tipo de suela: ", getTipoDeSuela());
	
	return jsonObject;
	}
}
