package ClasesPrendasDeVestir;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Esta clase tiene la finalidad de darle una abstraccion a como esta
 * implementado el sistema para ver el stock Se abstrae de que se utiliza un
 * mapa
 * 
 * @author Techno Manager
 *
 */
public class TallesYStock implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Integer> tallesYStock;

	/**
	 * Constructor de la Clase
	 */
	public TallesYStock() {
		tallesYStock = new HashMap<String, Integer>();
	}

	/**
	 * Confirma si el talle ingresado por parametro esta precente en el HashMap de
	 * la prenda
	 * 
	 * @param talle valor a comparar con los que conforman el HashMap
	 * @return boolean Retorna True si se encontro el talle en el HashMap, False en
	 *         caso contrario
	 */
	public boolean existeTalle(String talle) {
		return tallesYStock.containsKey(talle);
	}

	/**
	 * Este metodo agrega una nueva cantidad a un determinado talle
	 * 
	 * @param talle    a agregar la cantidad
	 * @param cantidad agregada
	 * @return true se se agrega, false en caso contrario
	 */
	public boolean agregarCantidadATalle(String talle, Integer cantidad) {
		boolean seAgrego = false;

		if (cantidad > 0) {
			if (existeTalle(talle)) {
				Integer nuevaCantidad = tallesYStock.get(talle) + cantidad;
				tallesYStock.put(talle, nuevaCantidad);
				seAgrego = true;
			}
			else {
				agregarNuevoTalleConCantidad(talle, cantidad);
			}
		}
		return seAgrego;
	}

	/**
	 * Agrega un nuevo talle al stock con una respectiva cantidad de prendas
	 * 
	 * @param talle    a agregar
	 * @param cantidad que se agrega con el nuevo talle
	 * @return true si se agrega, false en caso contrario
	 */
	public boolean agregarNuevoTalleConCantidad(String talle, Integer cantidad) {
		boolean seAgrego = false;

		if (!existeTalle(talle)) {
			tallesYStock.put(talle, cantidad);
			seAgrego = true;
		}

		return seAgrego;
	}

	/**
	 * Quita todo un talle del stock
	 * 
	 * @param talle a quitar
	 * @return true si se quita, false en caso contrario
	 */
	public boolean quitarUnTalle(String talle) {
		boolean seQuito = false;

		if (existeTalle(talle)) {
			tallesYStock.remove(talle);
			seQuito = true;
		}

		return seQuito;
	}

	/**
	 * Quita una determinada cantidad de stock a un determinado talle
	 * 
	 * @param talle    a sacar stock
	 * @param cantidad a sarle al talle
	 * @return true se se quita, false en caso contrario
	 */
	public boolean quitarCantidadATalle(String talle, Integer cantidad) {
		boolean seQuito = false;

		Integer cantidadActual = tallesYStock.get(talle);

		if ((cantidad > 0) && (cantidadActual >= cantidad)) {
			if (existeTalle(talle)) {
				Integer nuevaCantidad = cantidadActual - cantidad;
				tallesYStock.put(talle, nuevaCantidad);
				seQuito = true;
			}
		}
		return seQuito;
	}


	/**
	 * Este metodo es para listar todos los talles con sus respectivas cantidades
	 * 
	 * @return los talles con sus respectivas cantidades en forma de String
	 */
	public String listarTallesYStock() {
		StringBuilder builder = new StringBuilder("<html>");

		Set<Entry<String, Integer>> set = tallesYStock.entrySet();
		Iterator<Entry<String, Integer>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Entry<String, Integer> entry = iterator.next();
			builder.append("<p>Talle: " + entry.getKey() + " / Cantidad: " + entry.getValue() + "</p>");
		}
		builder.append("</html>");

		return builder.toString();
	}
	
	public String listarTallesYStockParaString() {
		StringBuilder builder = new StringBuilder();

		Set<Entry<String, Integer>> set = tallesYStock.entrySet();
		Iterator<Entry<String, Integer>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Entry<String, Integer> entry = iterator.next();
			builder.append("\n  Talle: " + entry.getKey() + "- Cantidad: " + entry.getValue());
		}

		String tallesYStock = builder.toString();
		
		if(tallesYStock.isEmpty()) {
			tallesYStock = "No hay stock";
		}
		
		return tallesYStock;
	}
	
	public int cantidadDeTallas() {
		return tallesYStock.size();
	}

	
	/**
	 * Metodo para exportar a un objeto JSON los talles con sus respectivas cantidades
	 * @return un jsonObject devolvindo talles y cantidades.
	 * @throws JSONException
	 */
	public JSONObject toJSONObject() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		
		Set<Entry<String, Integer>> set = tallesYStock.entrySet();
		Iterator<Entry<String, Integer>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Entry<String, Integer> entry = iterator.next();
			jsonObject.put(entry.getKey(), entry.getValue());
		}
		return jsonObject;
	}
	
	
	/**
	 * Metodo para importar de un objecto JSON los talles con sus respectivas cantidades.
	 * @param jsonObject es el objeto a importar
	 * @return los talles con sus cantidades a travez de un hashmap con sus clave valor
	 * @throws JSONException
	 */
	public static HashMap<String, Integer> fromJSONObject(JSONObject jsonObject) throws JSONException {
		
		HashMap<String, Integer> tallesYStock = new HashMap<String, Integer>();

	    Iterator<String> keysItr = jsonObject.keys();
	   
	    while(keysItr.hasNext()) {
	        String talle = keysItr.next();
	        Integer cantidad = (Integer) jsonObject.get(talle);
	        
	        tallesYStock.put(talle, cantidad);	        
	    	}
	    return tallesYStock;
	}   
	
	
	
}
