package ContenedorGenericas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import ClaseVenta.Venta;
import ClasesPersona.Persona;

/**
 * Contenedor generico que esta pensado para abstraer el comportamiento del
 * ArrayList.
 * 
 * @author Nicolas
 * @param <E> Tipo de dato esperodo por el objeto. podria se un cliente o una
 *            venta.
 */
public class ContenedorClientesYVentas<E> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<E> contenedor;

	/**
	 * Constructor de Contenedor de clientes y ventas
	 */
	public ContenedorClientesYVentas() {
		super();
		contenedor = new ArrayList<E>();
	}

	/**
	 * Agrega un elemento al ArrayList
	 * 
	 * @param elemento
	 * @return boolean Retorna True si se agrego el elemento, False en caso
	 *         contrario
	 */
	public boolean agregarElemento(E elemento) {
		return contenedor.add(elemento);
	}

	/**
	 * Quita un elemento del ArrayList por el contenido
	 * 
	 * @param elemento
	 * @return boolean Retorna True si se elimino el elemento, False en caso
	 *         contrario
	 */
	public boolean bajaElemento(E elemento) {
		return contenedor.remove(elemento);
	}

	/**
	 * Quita un elemento del ArrayList por el indice
	 * 
	 * @param index
	 * @return boolean Retorna True si se elimino el elemento, False en caso
	 *         contrario
	 */
	public E bajaElemento(int index) {
		return contenedor.remove(index);
	}

	/**
	 * Modifica un elemento del ArrayList por el indice, y lo cambia por el
	 * parametro "modificacion"
	 * 
	 * @param index        int que indica el indice dentro del ArrayList
	 * @param modificacion E que remplazara al elemento del ArrayList
	 * @return boolean Retorna True si se modifica el elemento, False en caso
	 *         contrario
	 */
	public boolean modificarElemento(int index, E modificacion) {
		boolean modificado = false;
		if ((index < 0) && (index < cantidadElementos())) {
			contenedor.add(index, modificacion);
			modificado = true;
		}
		return modificado;
	}

	/**
	 * Retorna la cantidad de elementos en el ArrayList
	 * 
	 * @return int cantidad de elementos
	 */
	public int cantidadElementos() {
		return contenedor.size();
	}

	/**
	 * Lista los elementos en forma de String
	 * 
	 * @return String Texto de elentos del ArrayList
	 */
	public String listarElementos() {
		StringBuilder builder = new StringBuilder();

		for (E elemento : contenedor) {
			builder.append(elemento.toString());
		}

		return builder.toString();
	}

	/**
	 * Busca un elemento en el contenedor
	 * 
	 * @param index del elemento a buscar
	 * @return el elemento buscado
	 */
	public E buscarElemento(int index) {
		return contenedor.get(index);
	}

	/**
	 * Comprueba si un elemento existe en el contenedor
	 * 
	 * @param elemento buscado
	 * @return true si existe, false en caso contrario
	 */
	public boolean existeElemento(E elemento) {
		return contenedor.contains(elemento);
	}
	
	/**
	 * 
	 * @param cliente
	 * @return
	 */
	public boolean comparaNomApe(E cliente) {
		boolean rta = false;
		
		for(E elem : contenedor) {
			if(((Persona) elem).getNombre().contentEquals(((Persona) cliente).getNombre()) &&
					((Persona) elem).getApellido().contentEquals(((Persona) cliente).getApellido())) {
				rta = true;
			}
		}
		
		return rta;
	}
	
	/**
	 * Modifica el legajo de un Vendedor en la lista de ventas para cuando se cambia el legajo en datos personale
	 * para no perder el registro actualizado del vendedor que realizo las ventas.
	 * @param legajoViejo String legajo anterior del vendedor.
	 * @param legajoNuevo String legajo nuevo del vendedor.
	 */
	public void modificarVendedorEnListaVentas(String legajoViejo, String legajoNuevo) {
		int index = 0;
		ArrayList<E> copia = contenedor;
		HashMap<Integer, Venta> cambios = new HashMap<Integer, Venta>();
		
		for(E venta : copia) {
			if(((Venta) venta).getVendedor().getLegajo().equals(legajoViejo)) {
				Venta ventaMod = (Venta) venta;
				ventaMod.getVendedor().setLegajo(legajoNuevo);
				cambios.put(index, ventaMod);
			}
			index++;
		}
		
		Set<Entry<Integer, Venta>> set = cambios.entrySet();
		Iterator<Entry<Integer, Venta>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Entry<Integer, Venta> entry = iterator.next();
			contenedor.set(entry.getKey(), (E)entry.getValue());
		}
	}


	
}
