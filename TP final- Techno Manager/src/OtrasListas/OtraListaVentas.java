package OtrasListas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import ClaseVenta.Venta;
import ClasesPersona.Cliente;
import ClasesPersona.Empleado;

public class OtraListaVentas extends Venta implements Serializable{
	
	private ArrayList<Venta> contenedor;

	/**
	 * Constructor de Contenedor de clientes y ventas
	 */
	public OtraListaVentas() {
		super();
		contenedor = new ArrayList<Venta>();
	}

	/**
	 * Agrega un elemento al ArrayList
	 * 
	 * @param elemento
	 * @return boolean Retorna True si se agrego el elemento, False en caso
	 *         contrario
	 */
	public boolean agregarElemento(Venta elemento) {
		return contenedor.add(elemento);
	}

	/**
	 * Quita un elemento del ArrayList por el contenido
	 * 
	 * @param elemento
	 * @return boolean Retorna True si se elimino el elemento, False en caso
	 *         contrario
	 */
	public boolean bajaElemento(Venta elemento) {
		return contenedor.remove(elemento);
	}

	/**
	 * Quita un elemento del ArrayList por el indice
	 * 
	 * @param index
	 * @return boolean Retorna True si se elimino el elemento, False en caso
	 *         contrario
	 */
	public Venta bajaElemento(int index) {
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
	public boolean modificarElemento(int index, Venta modificacion) {
		boolean modificado = false;
		if ((index < 0) && (index < cantidadElementos())) {
			contenedor.add(index, modificacion);
			;
			modificado = true;
		}
		return modificado;
	}

	/**
	 * Retorna la cantidad de elementos en el ArrayList
	 * 
	 * @return int cantidad de elementos
	 */
	private int cantidadElementos() {
		return contenedor.size();
	}

	/**
	 * Lista los elementos en forma de String
	 * 
	 * @return String Texto de elentos del ArrayList
	 */
	public String listarElementos() {
		StringBuilder builder = new StringBuilder();

		for (Venta elemento : contenedor) {
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
	public Venta buscarElemento(int index) {
		return contenedor.get(index);
	}

	/**
	 * Comprueba si un elemento existe en el contenedor
	 * 
	 * @param elemento buscado
	 * @return true si existe, false en caso contrario
	 */
	public boolean existeElemento(Venta elemento) {
		return contenedor.contains(elemento);
	}
	
	public void guardar() throws FileNotFoundException, IOException {
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("fileVentas"));
		output.writeObject(this.contenedor);
		output.close();
	}

	public void abrir() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("fileVentas"));
		contenedor = (ArrayList<Venta>) input.readObject();
		input.close();
	}

}
