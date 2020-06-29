package ContenedorGenericas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;




import java.util.Map.Entry;

/**
 * Contenedor generico que esta pensado para abstraer el comportamiento del
 * HashMap.
 * 
 * @author Nicolas
 * @param <K> clave esperando por el Objeto
 * @param <V> valor esperado por el objeto, podria se una prenda o un empleado
 */
public class ContenedorPrendasYEmpleados<K, V> implements Serializable{


	private static final long serialVersionUID = 1L;
	private HashMap<K, V> contenedor;

	/**
	 * Constructor del contenedor de Personas y Empleados
	 */
	public ContenedorPrendasYEmpleados() {
		super();
		contenedor = new HashMap<K, V>();
	}

	/**
	 * Agregar Elementos al HashMap
	 * 
	 * @param clave elemento que reprecenta la clave
	 * @param valor elemento que reprecenta el contenido del elemento
	 * @return boolean Retorna True si se agrego el elemento, False en caso
	 *         contrario
	 */
	public boolean agregarElemento(K clave, V valor) {
		boolean agregado = false;
		if (!existeClave(clave)) {
			contenedor.put(clave, valor);
			agregado = true;
		}
		return agregado;
	}

	/**
	 * Elimina un elemento del HashMap
	 * 
	 * @param clave elemento que distingue un elemento de otro
	 * @return boolean Retorna True si se eleimina el elemento, False en caso
	 *         contrario
	 */
	public boolean bajaElemento(K clave) {
		boolean eliminado = false;
		if (existeClave(clave)) {
			contenedor.remove(clave);
			eliminado = true;
		}
		return eliminado;
	}

	/**
	 * Modifica un elemento por el indicador "clave"
	 * 
	 * @param clave valor que distingue el elemento en el HashMap
	 * @param valor del elemento que sobre escribirá
	 * @return boolean Retorna True si se modifico el elemento, False en caso
	 *         contrario
	 */
	public boolean modificarElemento(K clave, V valor) {
		boolean modificado = false;
		if (existeClave(clave)) {
			contenedor.put(clave, valor);
			modificado = true;
		}
		return modificado;
	}

	/**
	 * Lista los elementos del HashMap
	 * 
	 * @param nom_claves  nombre que tomaran las claves
	 * @param nom_valores nombre que tomaran los valores
	 * @return String cuerpo de texto del HashMap
	 */
	public String listarElementos(String nom_claves, String nom_valores) {
		StringBuilder builder = new StringBuilder();

		Set<Entry<K, V>> set = contenedor.entrySet();
		Iterator<Entry<K, V>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Entry<K, V> entry = iterator.next();
			builder.append("\n\n"+nom_claves + ": " + entry.getKey() + " " + "\n\n"+nom_valores + ": " + entry.getValue());
		}

		return builder.toString();
	}

	/**
	 * Determina si existe la clave parametrada
	 * 
	 * @param clave valor a verificar
	 * @return boolean Retorna True si existe el elemento, False en caso contrario
	 */
	public boolean existeClave(K clave) {
		return contenedor.containsKey(clave);
	}

	/**
	 * Este metodo busca un elemento por la clave y lo retorna S
	 * 
	 * @param clave
	 * @return el elemento si existe y sino retorna null.
	 */
	
	/**
	 * Busca un elemento, si no existe retorna null.
	 * @param clave para buscar el elemento
	 * @return el elemento
	 */
	public V buscarElemento(K clave) {

		if (existeClave(clave)) {
			return contenedor.get(clave);
		} else {
			return null;
		}

	}
	
	/**
	 * Devuelve todos los elementos del contenedor en forma de Arraylist
	 * @return el ArrayList con los elementos
	 */
	public ArrayList<V> devolverElementos() {
		ArrayList <V> elementos = new ArrayList<V>();
		
		Set<Entry<K, V>> set = contenedor.entrySet();
		Iterator<Entry<K, V>> iterator = set.iterator();
		
		while (iterator.hasNext()) {
			Entry<K, V> entry = iterator.next();
			elementos.add(entry.getValue());
		}
		return elementos;
	}
	
	

}
