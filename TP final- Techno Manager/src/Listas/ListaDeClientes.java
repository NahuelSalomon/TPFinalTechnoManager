package Listas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import ClasesPersona.Cliente;
import ContenedorGenericas.ContenedorClientesYVentas;
import Interfaces.IFuncionesBasicasListaClientes;

/**
 * Lista la cual contiene un contenedor de la logica del manejo de los clientes
 * 
 * @author Nahuel
 *
 */

public class ListaDeClientes implements IFuncionesBasicasListaClientes, Serializable {

	private ContenedorClientesYVentas<Cliente> clientes;

	public ListaDeClientes() {
		clientes = new ContenedorClientesYVentas<Cliente>();
	}

	public ListaDeClientes(ListaDeClientes listaDeClientes) {
		clientes = new ContenedorClientesYVentas<Cliente>();
		this.agragarListaDeClientes(listaDeClientes.devolverClientes()); 
	}
	
	
	@Override
	public boolean agregarCliente(Cliente elemento) {
		return clientes.agregarElemento(elemento);
	}

	@Override
	public boolean bajaCliente(Cliente elemento) {
		return clientes.bajaElemento(elemento);
	}

	@Override
	public Cliente bajaCliente(int index) {
		return clientes.bajaElemento(index);
	}

	@Override
	public String listarClientes() {
		return clientes.listarElementos();
	}

	@Override
	public Cliente buscarCliente(int index) {
		return clientes.buscarElemento(index);
	}

	public boolean existeCliente(Cliente cliente) {
		return clientes.existeElemento(cliente);
	}
	
	/**
	 * Metodo para devolver toods los clientes
	 * @return los clientes en un ArrayList
	 */
	public ArrayList<Cliente> devolverClientes() {
		ArrayList<Cliente> listaDeclientes = new ArrayList<Cliente>();
		
		for(int i = 0 ; i < clientes.cantidadElementos() ; i++) {
			listaDeclientes.add(clientes.buscarElemento(i));
		}
		
		return listaDeclientes;
	} 
	
	/**
	 * Agrega varios clientes a la lista de clientes 
	 * @param listaDeClientes en forma de ArrayList
	 */
	public void agragarListaDeClientes(ArrayList<Cliente> listaDeClientes) {
		
		for(Cliente cliente : listaDeClientes) {
			this.clientes.agregarElemento(cliente);
		}
	}
	
	/**
	 * Convierte la lista de clientes en un arreglo de JSON 
	 * @return un JSONArray con los clientes
	 * @throws JSONException 
	 */
	public JSONArray toJsonArray() throws JSONException {
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0 ; i < clientes.cantidadElementos() ; i++ ) {
			jsonArray.put(clientes.buscarElemento(i).toJSONObject());
		}
		
		return jsonArray;
	}

	public boolean comparaNomApe(Cliente nuevoCliente) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
