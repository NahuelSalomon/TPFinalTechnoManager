package ListasGenericas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Contenedor generico que esta pensado para abstraer el comportamiento del HashMap.
 * @author Nicolas
 * Tipo de dato, esperando un Objeto.
 * @param <K>
 * @param <V>
 */
public class ContenedorPrendasYEmpleados <K,V>{
	
	private HashMap<K,V> contenedor;
	
	/**
	 * Constructor cel contenedor de Personas y Empleados
	 */
	public ContenedorPrendasYEmpleados() {
		super();
		contenedor = new HashMap<K,V>();
	}
	
	/**
	 * Agregar Elementos al HashMap
	 * @param clave elemento que reprecenta la clave
	 * @param valor elemento que reprecenta el contenido del elemento
	 * @return boolean Retorna True si se agrego el elemento, False en caso contrario
	 */
	public boolean agragarElemento(K clave, V valor){
		boolean agregado = false;
		if(!existeClave(clave)){
			contenedor.put(clave, valor);
			agregado = true;
		}
		return agregado;
	}
	
	/**
	 * Elimina un elemento del HashMap
	 * @param clave elemento que distingue un elemento de otro
	 * @return boolean Retorna True si se eleimina el elemento, False en caso contrario
	 */
	public boolean bajaElemento(K clave) {
		boolean eliminado = false;
		if(existeClave(clave)){
			contenedor.remove(clave);
			eliminado = true;
		}
		return eliminado;
	}
	
	/**
	 * Modifica un elemento por el indicador "clave"
	 * @param clave valor que distingue el elemento en el HashMap 
	 * @param valor del elemento que sobre escribirá 
	 * @return boolean Retorna True si se modifico el elemento, False en caso contrario
	 */
	public boolean modificarElemento(K clave, V valor) {
		boolean modificado = false;
		if(existeClave(clave)){
			contenedor.put(clave, valor);
			modificado = true;
		}
		return modificado;
	}
	
	/**
	 * Lista los elementos del HashMap
	 * @param nom_claves nombre que tomaran las claves
	 * @param nom_valores nombre que tomaran los valores
	 * @return String cuerpo de texto del HashMap
	 */
	public String listarElementos(String nom_claves, String nom_valores) {
		StringBuilder builder = new StringBuilder();
		
		Set<Entry<K, V>> set = contenedor.entrySet();
		Iterator<Entry<K, V>> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Entry<K, V> entry = iterator.next();
			builder.append(nom_claves+": "+entry.getKey()+" "+nom_valores+": "+entry.getValue());
		}
		
		return builder.toString();
	}
	
	/**
	 * Determina si existe la clave parametrada
	 * @param clave valor a verificar
	 * @return boolean Retorna True si existe el elemento, False en caso contrario
	 */
	public boolean existeClave(K clave) {
		return contenedor.containsKey(clave);
	}
}
