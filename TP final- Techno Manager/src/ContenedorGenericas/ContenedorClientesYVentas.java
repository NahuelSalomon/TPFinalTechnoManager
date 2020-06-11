package ContenedorGenericas;

import java.util.ArrayList;

/**
 * Contenedor generico que esta pensado para abstraer el comportamiento del ArrayList.
 * @author Nicolas
 * @param <E>  Tipo de dato esperodo por el objeto. podria se un cliente o una venta.
 */
public class ContenedorClientesYVentas <E>{
	
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
	 * @param elemento 
	 * @return boolean Retorna True si se agrego el elemento, False en caso contrario
	 */
	public boolean agragarElemento(E elemento){
		return contenedor.add(elemento);
	}
	
	/**
	 * Quita un elemento del ArrayList por el contenido
	 * @param elemento
	 * @return boolean Retorna True si se elimino el elemento, False en caso contrario
	 */
	public boolean bajaElemento(E elemento) {
		return contenedor.remove(elemento);
	}
	
	/**
	 * Quita un elemento del ArrayList por el indice
	 * @param index
	 * @return boolean Retorna True si se elimino el elemento, False en caso contrario
	 */
	public E bajaElemento(int index) {
		return contenedor.remove(index);
	}
	
	/**
	 * Modifica un elemento del ArrayList por el indice, y lo cambia por el parametro "modificacion"
	 * @param index int que indica el indice dentro del ArrayList
	 * @param modificacion E que remplazara al elemento del ArrayList
	 * @return boolean Retorna True si se modifica el elemento, False en caso contrario
	 */
	public boolean modificarElemento(int index, E modificacion) {
		boolean modificado = false;
		if((index < 0) && (index < cantidadElementos())){
			contenedor.add(index, modificacion);;
			modificado = true;
		}
		return modificado;
	}
	
	/**
	 * Retorna la cantidad de elementos en el ArrayList
	 * @return int cantidad de elementos
	 */
	private int cantidadElementos() {
		return contenedor.size();
	}

	/**
	 * Lista los elementos en forma de String
	 * @return String Texto de elentos del ArrayList
	 */
	public String listarElementos() {
		StringBuilder builder = new StringBuilder();
		
		for(E elemento : contenedor) {
			builder.append(elemento.toString());
		}
				
		return builder.toString();
	}

	public E buscarElemento(int index) {
		return contenedor.get(index);
	}
	
	
}
