package Listas;


import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ClasesPersona.Cliente;
import ClasesPersona.ClienteMayorista;
import ClasesPersona.ClienteMinorista;
import ContenedorGenericas.ContenedorClientesYVentas;
import Interfaces.IFuncionesBasicasListaClientes;

/**
 * Lista la cual contiene un contenedor de la logica del manejo de los clientes
 * 
 * @author Nahuel
 *
 */

public class ListaDeClientes implements IFuncionesBasicasListaClientes, Serializable {

	
	private static final long serialVersionUID = 1L;
	
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

	public Cliente buscarClientePorDNI(String dni) {
		
		Cliente cliente = null;
		
		for(int i = 0; i < clientes.cantidadElementos() ; i++) {
			if(clientes.buscarElemento(i).getDni().equals(dni)) {
				cliente = clientes.buscarElemento(i);
			}
		}
		
		return cliente;
	}
	
	public int cantidadDeClientes() {
		return clientes.cantidadElementos();
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
	
	/**
	 * Devulve todos los clientes con su nombre, apellido, dni y tipo de cliente
	 * @return los datos de todos los clientes mencionados anteriormente en forma de String
	 */
	public String devolverClientesConSuNombreApellidoYDni() {
		StringBuilder builder = new StringBuilder();
		
		ArrayList<Cliente> clientes = devolverClientes();
		
		for (Cliente c : clientes) {
			builder.append(c.getDni()+" - "+c.getNombre()+" "+c.getApellido()+" - "+c.tipoDeCliente()+"\n");
		}
		
		return builder.toString();
	}
	
	/**
	 * Metodo para importar una lista de clientes desde un array de json
	 * @param jsonArray a importar
	 * @return la lista de clientes
	 * @throws JSONException
	 */
	public static ListaDeClientes fromJSONArray(JSONArray jsonArray) throws JSONException {
		
		ListaDeClientes listaDeClientes = new ListaDeClientes();
		
		for(int i = 0 ; i < jsonArray.length() ; i ++) {
			
			JSONObject jsonObjectCliente = (JSONObject) jsonArray.get(i); 
			
			if(jsonObjectCliente.getString("Tipo de cliente").equals("Mayorista")) {
				ClienteMayorista clienteMayorista = (ClienteMayorista) ClienteMayorista.JSONObjectToClienteMayorista(jsonObjectCliente); 
				listaDeClientes.agregarCliente(clienteMayorista);
			}
			else {
				if(jsonObjectCliente.getString("Tipo de cliente").equals("Minorista")) {
					ClienteMinorista clienteMinorista = (ClienteMinorista) ClienteMinorista.fromJSONObject(jsonObjectCliente);
					listaDeClientes.agregarCliente(clienteMinorista);
				}
			}
		}
		
		return listaDeClientes;
	}
	
	public boolean comparaNomApe(Cliente nuevoCliente) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
