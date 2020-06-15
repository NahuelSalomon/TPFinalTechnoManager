package OtrasListas;

import java.io.*;
import java.util.ArrayList;

import ClaseVenta.Venta;
import ClasesPersona.Cliente;
import Listas.ListaDeClientes;

public class OtraListaClientes extends Cliente implements Serializable{

	private ArrayList<Cliente> contenedor;

	/**
	 * Constructor de Contenedor de clientes y ventas
	 */
	public OtraListaClientes() {
		super();
		contenedor = new ArrayList<Cliente>();
	}

	/**
	 * Agrega un elemento al ArrayList
	 * 
	 * @param elemento
	 * @return boolean Retorna True si se agrego el elemento, False en caso
	 *         contrario
	 */
	public boolean agregarElemento(Cliente elemento) {
		return contenedor.add(elemento);
	}

	/**
	 * Quita un elemento del ArrayList por el contenido
	 * 
	 * @param elemento
	 * @return boolean Retorna True si se elimino el elemento, False en caso
	 *         contrario
	 */
	public boolean bajaElemento(Cliente elemento) {
		return contenedor.remove(elemento);
	}

	/**
	 * Quita un elemento del ArrayList por el indice
	 * 
	 * @param index
	 * @return boolean Retorna True si se elimino el elemento, False en caso
	 *         contrario
	 */
	public Cliente bajaElemento(int index) {
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
	public boolean modificarElemento(int index, Cliente modificacion) {
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

		for (Cliente elemento : contenedor) {
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
	public Cliente buscarElemento(int index) {
		return contenedor.get(index);
	}

	/**
	 * Comprueba si un elemento existe en el contenedor
	 * 
	 * @param elemento buscado
	 * @return true si existe, false en caso contrario
	 */
	public boolean existeElemento(Cliente elemento) {
		return contenedor.contains(elemento);
	}
	
	public void guardar() throws FileNotFoundException, IOException {
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("fileClientes"));
		output.writeObject(this.contenedor);
		output.close();
	}

	public void abrir() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("fileClientes"));
		contenedor = (ArrayList<Cliente>) input.readObject();
		input.close();
	}
	
	public boolean comparaNomApe(Cliente cliente) {
		boolean rta = false;
		
		for(Cliente elem : contenedor) {
			if(elem.getNombre().contentEquals(cliente.getNombre()) &&
					elem.getApellido().contentEquals(cliente.getApellido())) {
				rta = true;
			}
		}
		
		return rta;
	}
}
