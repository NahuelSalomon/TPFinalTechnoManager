package ClasesPrendasDeVestir;

import java.io.Serializable;
import java.util.Random;

import javax.rmi.CORBA.Util;

import org.json.JSONException;
import org.json.JSONObject;

import ClasesPersona.Gerente;

/**
 * Clase padre de cualquier prenda de vestir, es abstracta con la finalidad de
 * que se tiene que definir bien de que tipo es la prenda
 * 
 * @author Techno Manager
 *
 */
public abstract class PrendaDeVestir implements Serializable{

	private String codigo;

	private int marca;
	private String modelo;
	private String color;
	private int tipoDeMaterial;
	private TallesYStock stockPrenda;

	public PrendaDeVestir() {
		super();
		this.codigo = getRandomString(10);
		this.marca = 0;
		this.modelo = null;
		this.color = null;
		this.tipoDeMaterial = 0;
		stockPrenda = new TallesYStock();
	}

	public PrendaDeVestir(int marca, String modelo, String color, int tipoDeMaterial) {
		super();
		this.codigo = getRandomString(10);
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.tipoDeMaterial = tipoDeMaterial;
		this.stockPrenda = new TallesYStock();
	}
	
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		if(codigo.length() == 0 && codigo.length()>10) {
			this.codigo = getRandomString(10);
		}
		else this.codigo = codigo;
	}
	
	private int getRandomCode() {
		int x = (int) (Math.random() * ((99999999 - 0) + 0)) + 1;
	    return x;
	}
	
	private String getRandomString(int targetStringLength) {
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    if(targetStringLength<=0 && targetStringLength>10) targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    return generatedString;
	}
	
//	- 1. Zara
//	- 2. Nike
//	- 3. Gucci
//	- 4. Adidas
//	- 5. Lacoste
//	- 6. Chanel
//	- 7. Levi’s

	public String getMarca() {
		String rta = "";
		switch(this.marca) {
		case(1):
			rta = "Zara";
			break;
		case(2):
			rta = "Nike";
			break;
		case(3):
			rta = "Gucci";
			break;
		case(4):
			rta = "Adidas";
			break;
		case(5):
			rta = "Lacoste";
			break;
		case(6):
			rta = "Chanel";
			break;
		case(7):
			rta = "Levi’s";
			break;
		default:
			rta = "No definido";
			break;
		}
		return rta;
	}

	public void setMarca(int marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public String getTipoDeMaterial() {
		String rta = "";
		switch(this.tipoDeMaterial) {
		case(1):
			rta = "Algodon";
			break;
		case(2):
			rta = "Terciopelo";
			break;
		case(3):
			rta = "Calico";
			break;
		case(4):
			rta = "Fieltro";
			break;
		case(5):
			rta = "Seda";
			break;
		default:
			rta = "No definido";
			break;
		}
		return rta;
	}

	public void setTipoDeMaterial(int tipoDeMaterial) {
		this.tipoDeMaterial = tipoDeMaterial;
	}

	/**
	 * Lista el stock disponible
	 * 
	 * @return el stock en forma de String
	 */
	public String listarStock() {
		return stockPrenda.listarTallesYStock();
	}
	
	public int cantidadDeTallas() {
		return stockPrenda.cantidadDeTallas();
	}
	
	/**
	 * Verifica si existe un Talle ingresado
	 * 
	 * @param talle
	 * @return True o false segun corresponda
	 */
	public boolean existeTalle(String talle) {
		return stockPrenda.existeTalle(talle);
	}

	/**
	 * Agrega un talle al stock con una cantidad
	 * 
	 * @param talle    a agregar
	 * @param cantidad agregada
	 * @return true si se agrega, false en caso contrario
	 */
	public boolean agregarCantidadATalle(String talle, Integer cantidad) {
		return stockPrenda.agregarCantidadATalle(talle, cantidad);
	}

	/**
	 * Agrega un nuevo talle al stock con su respectiva cantidad
	 * 
	 * @param talle    a agregar
	 * @param cantidad del talle agregado
	 * @return true si se agrega, false en caso contrario.
	 */
	public boolean agregarNuevoTalleConCantidad(String talle, Integer cantidad) {
		return stockPrenda.agregarNuevoTalleConCantidad(talle, cantidad);
	}

	/**
	 * Quita un talle del stock
	 * 
	 * @param talle a quitar
	 * @return true si se quita, false en caso contrario
	 */
	public boolean quitarUnTalle(String talle) {
		return stockPrenda.quitarUnTalle(talle);
	}

	/**
	 * Quita una determinada cantidad a un talle del stock
	 * 
	 * @param talle    a quitar cantidad
	 * @param cantidad quitada
	 * @return true si se quita, false en caso contrario
	 */
	public boolean quitarCantidadATalle(String talle, Integer cantidad) {
		return stockPrenda.quitarCantidadATalle(talle, cantidad);
	}

	public String toString() {
		return "Marca: " + getMarca() + "\nModelos: " + getModelo() + "\nColor: " + getColor() + ""
				+ "\nTipo de material: "+ getTipoDeMaterial();
	}

	/**
	 * Retorna el tipo de prenda
	 * 
	 * @return tipo prenda en forma de string
	 */
	public abstract String tipoDePrenda();

	
	/**
	 * Devuelve la prenda de vestir en forma de un objeto de json 
	 * @return la prenda de forma de JSONObject
	 * @throws JSONException
	 */
	public JSONObject toJSONObject() throws JSONException { 
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("Codigo: ", getCodigo());
		jsonObject.put("Marca: ", getMarca());
		jsonObject.put("Modelo: : ", getModelo());
		jsonObject.put("Color: ", getColor());
		jsonObject.put("Tipo de material: ", getTipoDeMaterial());
		jsonObject.put("Talles y stock: ", stockPrenda.toJSONObject());
		
	return jsonObject;
	}
}
