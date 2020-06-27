package Listas;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import ClaseVenta.Venta;
import ClasesPersona.Cliente;
import ContenedorGenericas.ContenedorClientesYVentas;
import Interfaces.IFuncionesBasicasListaVentas;

/**
 * Lista la cual contiene un contenedor de la logica del manejo de las ventas
 * 
 * @author Nahuel
 *
 */
public class ListaDeVentas implements IFuncionesBasicasListaVentas,Serializable {

	private ContenedorClientesYVentas<Venta> ventas;

	public ListaDeVentas() {
		ventas = new ContenedorClientesYVentas<Venta>();
	}

	public ListaDeVentas(ListaDeVentas listaDeVentas) {
		ventas = new ContenedorClientesYVentas<Venta>();
		this.agragarListaDeVentas(listaDeVentas.devolverVentas());
	}
	
	@Override
	public boolean agregarVenta(Venta venta) {
		return ventas.agregarElemento(venta);
	}

	@Override
	public boolean bajaVenta(Venta venta) {
		return ventas.bajaElemento(venta);
	}

	@Override
	public Venta bajaVenta(int index) {
		return ventas.bajaElemento(index);
	}

	@Override
	public String listarVentas() {
		return ventas.listarElementos();
	}

	@Override
	public Venta buscarVenta(int index) {
		return ventas.buscarElemento(index);
	}

	public int cantidadDeVentas() {
		return ventas.cantidadElementos();
	}
	
	/**
	 * @param venta a verificar si existe
	 * @return true si existe la venta, false en caso contrario
	 */
	public boolean existeVenta(Venta venta) {
		return ventas.existeElemento(venta);
	}

	/**
	 * Metodo para devolver toods los clientes
	 * @return los clientes en un ArrayList
	 */
	public ArrayList<Venta> devolverVentas() {
		ArrayList<Venta> listaDeVentas = new ArrayList<Venta>();
		
		for(int i = 0 ; i < ventas.cantidadElementos() ; i++) {
			listaDeVentas.add(ventas.buscarElemento(i));
		}
		
		return listaDeVentas;
	} 
	
	/**
	 * Agrega varias ventas a la lista de ventas 
	 * @param listaDeClientes en forma de ArrayList
	 */
	public void agragarListaDeVentas(ArrayList<Venta> listaDeVentas) {
		
		for(Venta venta : listaDeVentas) {
			this.ventas.agregarElemento(venta);
		}
	}
	
	/**
	 * Devuelve la lista de ventas en un arreglo de json
	 * @return las ventas en un JSONArray
	 * @throws JSONException 
	 */
	public JSONArray toJsonArray() throws JSONException {
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0 ; i < ventas.cantidadElementos() ; i++ ) {
			jsonArray.put(ventas.buscarElemento(i).toJSONObject());
		}
		
		return jsonArray;
	}

}
