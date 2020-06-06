package ClasesPrendasDeVestir;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;


/**
 * Esta clase tiene la finalidad de darle una abstraccion a como esta implementado el sistema para ver el stock
 * Se abstrae de que se utiliza un mapa
 * @author Techno Manager
 *
 */
public class TallesYStock {

	private HashMap<String, Integer> tallesYStock;

	public TallesYStock() {
		tallesYStock = new HashMap<String, Integer>();
	}

	private boolean existeTalle(String talle) {
		return tallesYStock.containsKey(talle);
	}
	
	/**
	 * Este metodo agrega una nueva cantidad a un determinado talle 
	 * @param talle a agregar la cantidad
	 * @param cantidad agregada
	 * @return true se se agrega, false en caso contrario
	 */
	public boolean agregarCantidadATalle (String talle, Integer cantidad) {
		boolean seAgrego = false;
		
		if(cantidad > 0) {
			if(existeTalle(talle)) {
				Integer nuevaCantidad = tallesYStock.get(talle) + cantidad;
				tallesYStock.put(talle, nuevaCantidad);	
				seAgrego = true;
			} 	
		}
		return seAgrego;
	}
	
	/**
	 * Agrega un nuevo talle al stock con una respectiva cantidad de prendas
	 * @param talle a agregar
	 * @param cantidad que se agrega con el nuevo talle
	 * @return true si se agrega, false en caso contrario
	 */
	public boolean agregarNuevoTalleConCantidad(String talle, Integer cantidad) {
		boolean seAgrego = false;
		
		if(!existeTalle(talle)) {
			tallesYStock.put(talle, cantidad);
			seAgrego = true;
		}
		
		return seAgrego;
	}
	
	/**
	 * Quita todo un talle del stock
	 * @param talle a quitar
	 * @return true si se quita, false en caso contrario
	 */
	public boolean quitarUnTalle(String talle) {
		boolean seQUito = false;
		
		if(existeTalle(talle)) {
			tallesYStock.remove(talle);
			seQUito = true;
		}
		
		return seQUito;
	}
	
	/**
	 * Quita una determinada cantidad de stock a un determinado talle
	 * @param talle a sacar stock 
	 * @param cantidad a sarle al talle
	 * @return true se se quita, false en caso contrario
	 */
	public boolean quitarCantidadATalle(String talle, Integer cantidad) {
		boolean seQuito = false;
		
		Integer cantidadActual = tallesYStock.get(talle); 
		
		if((cantidad > 0) && (cantidadActual >= cantidad)) {
			if(existeTalle(talle)) {
				Integer nuevaCantidad = cantidadActual - cantidad;
				tallesYStock.put(talle, nuevaCantidad);
				seQuito = true;
			}
		}
	return seQuito;
	}
	
	/**
	 * Este metodo es para listar todos los talles con sus respectivas cantidades
	 * @return los talles con sus respectivas cantidades en forma de String
	 */
	public String listarTallesYStock() {
		StringBuilder builder = new StringBuilder();
		
		Set<Entry<String, Integer>> set = tallesYStock.entrySet();
		Iterator<Entry<String, Integer>> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Entry<String, Integer> entry = iterator.next();
			builder.append("Talle: "+entry.getKey()+"Cantidad: "+entry.getValue());
		}
		
		return builder.toString();
	}
	
}
