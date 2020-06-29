package Listas;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ClaseVenta.Venta;

import ContenedorGenericas.ContenedorClientesYVentas;
import Interfaces.IFuncionesBasicasListaVentas;

/**
 * Lista la cual contiene un contenedor de la logica del manejo de las ventas
 * 
 * @author Nahuel
 *
 */
public class ListaDeVentas implements IFuncionesBasicasListaVentas,Serializable {


	private static final long serialVersionUID = 1L;
	public static int id = 0;
	
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
		venta.setId(id++);
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
	 * Metodo para buscar una venta por id
	 * @param id de la venta a buscar
	 * @return la venta
	 */
	public Venta buscarVentaPorID(int id) {
		Venta venta = null;
	
		ArrayList<Venta> arrayVentas = devolverVentas();
		
		for(Venta v : arrayVentas) {
			if(v.getId() == id) {
				venta = v;
				break;
			}
		}
		return venta;
	}
	
	/**
	 * Metodo para listar ventas con su id vendedor, cliente y fecha
	 * @return la informacion detallada anteriormente en forma de String
	 */
	public String listarVentasConIdVendedorClineteYFecha() {
		StringBuilder builder = new StringBuilder();
		
		ArrayList<Venta> arrayVentas = devolverVentas();
		
		for(Venta v : arrayVentas) {
			builder.append("ID: "+v.getId()+" - Cliente: "+v.getCliente().getNombre()+" "+v.getCliente().getApellido()
					+" - Vendedor: "+v.getVendedor().getNombre()+" "+v.getVendedor().getApellido()+" - Fecha: "+v.getFecha()+"\n");
			
		}
		
		return builder.toString();
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
	
	/**
	 * Metodo para importar una lista de ventas desde un array de json
	 * @param jsonArray a importar
	 * @param listaDeClientes para importar los clientes que realizan las compras
	 * @param listaDeEmpleados para importar los clientes que realizan las ventas
	 * @param listaDePrendas para importar los prendas que compran los clientes
	 * @return la lista de ventas
	 * @throws JSONException
	 */
	public static ListaDeVentas fromJSONArray(JSONArray jsonArray, ListaDeClientes listaDeClientes, ListaDeEmpleados listaDeEmpleados, ListaDePrendas listaDePrendas) throws JSONException {
		ListaDeVentas listaDeVentas = new ListaDeVentas();
		
		for(int i = 0 ; i < jsonArray.length() ; i++) {
			JSONObject jsonObjectVenta = jsonArray.getJSONObject(i);
			Venta venta = (Venta) Venta.fromJSONObject(jsonObjectVenta, listaDeClientes, listaDeEmpleados, listaDePrendas);
			listaDeVentas.agregarVenta(venta);
		}
		
		return listaDeVentas;
	} 
	
	

}
