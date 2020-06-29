package ClaseVenta;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import ClasesPersona.Cliente;
import ClasesPersona.Vendedor;
import ClasesPrendasDeVestir.PrendaDeVestir;
import Listas.ListaDeClientes;
import Listas.ListaDeEmpleados;
import Listas.ListaDePrendas;

/**
 * Clase venta para registrar cada una de las ventas que realizan los clientes.
 * 
 * @author Nahuel
 *
 */
public class Venta implements Serializable{

	
	private static final long serialVersionUID = 1L;

	
	

	private int id;
	private Cliente cliente;
	private Vendedor vendedor;
	private String fecha;
	private double monto;
	private HashMap<PrendaDeVestir, Integer> prendasCompradas;

	public Venta() {
		prendasCompradas = new HashMap<PrendaDeVestir, Integer>();
	}

	public Venta(Cliente cliente, Vendedor vendedor, String fecha,
			HashMap<PrendaDeVestir, Integer> prendasCompradas) {
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.fecha = fecha;
		this.prendasCompradas = prendasCompradas;
		this.id = 0;
		this.monto = calcularMonto();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public String getFecha() {
		return fecha;
	}

	public double getMonto() {
		return monto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public HashMap<PrendaDeVestir, Integer> getPrendasCompradas() {
		return prendasCompradas;
	}

	@Override
	public String toString() {
		return "Id: "+getId()+"\nCliente: " + getCliente().getNombre() + " " + getCliente().getApellido() +
				"\nVendedor: "+getVendedor().getNombre()+" "+getVendedor().getApellido()+
				"\nFecha: " + getFecha()+"\nMonto: "+getMonto()+"\nPRENDAS COMPRADAS\n"+listarPrendasCompradas()+"\n\n";
	}

	
	/**
	 * Metodo para listar las prendas compradas con su respectiva cantidad en forma de String
	 * @return la informacion detallada anteriormente en forma de String
	 */
	public String listarPrendasCompradas() {
		StringBuilder builder = new StringBuilder();
		
		Set<Entry<PrendaDeVestir, Integer>> set = prendasCompradas.entrySet();
		Iterator<Entry<PrendaDeVestir, Integer>> itertor = set.iterator();
		
		while (itertor.hasNext()) {
			Entry<PrendaDeVestir, Integer> entry = itertor.next();
			String datosPrenda = entry.getKey().getMarca()+" "+entry.getKey().getModelo();
			builder.append("Prenda: "+datosPrenda+" - Cantidad: "+entry.getValue()+"\n");
		}
		
		return builder.toString();
	}
	
	/**
	 * Metodo para devolver la venta en un objeto de json
	 * @return la venta en forma de JSONObject
	 * @throws JSONException
	 */
	public JSONObject toJSONObject() throws JSONException { 
		JSONObject jsonObject = new JSONObject();
	
		jsonObject.put("Cliente", getCliente().getDni());
		jsonObject.put("Vendedor", getVendedor().getLegajo());
		jsonObject.put("Fecha", getFecha());
		jsonObject.put("Monto", getMonto());
		jsonObject.put("Prendas compradas", toJSONObjectPrendasCompradas());
		
		
		
	return jsonObject;
	}
	
	/**
	 * Metodo para importar un venta desde un objeto json
	 * @param jsonObject a importar
	 * @param listaDeClientes que se utiliza para buscar el cliente que realizo la compra, se busca por dni.
	 * @param listaDeEmpleados que se utiliza para buscar al empleado que realizo la venta, se busca por legajo.
	 * @param listaDePrendas que se utiliza para buscar las prendas que compro el cliente.
	 * @return la venta
	 * @throws JSONException
	 */
	public static Venta fromJSONObject(JSONObject jsonObject, ListaDeClientes listaDeClientes, ListaDeEmpleados listaDeEmpleados, ListaDePrendas listaDePrendas) throws JSONException {
		
		String fecha = jsonObject.getString("Fecha");
		String legajoDeVendedor = jsonObject.getString("Vendedor");
		String dniCliente = jsonObject.getString("Cliente");
		
		Cliente cliente = listaDeClientes.buscarClientePorDNI(dniCliente);
		Vendedor vendedor = (Vendedor) listaDeEmpleados.buscarEmpleado(legajoDeVendedor);
		HashMap<PrendaDeVestir, Integer> prendasCompradas = fromJSONObjectPrendasCompradas(listaDePrendas, jsonObject.getJSONObject("Prendas compradas"));	
		
		Venta venta = new Venta(cliente, vendedor, fecha, prendasCompradas);
	
	return venta;
	}
	
	/**
	 * Metodo para devolver las prendas compradas en un objeto de json
	 * @return las prendas en forma JSONObject
	 * @throws JSONException
	 */
	private JSONObject toJSONObjectPrendasCompradas() throws JSONException { 
		JSONObject jsonObject = new JSONObject();
		
		Set<Entry<PrendaDeVestir, Integer>> set = prendasCompradas.entrySet();
		Iterator<Entry<PrendaDeVestir, Integer>> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Entry <PrendaDeVestir, Integer> entry =  iterator.next();
			jsonObject.put(entry.getKey().getCodigo(), entry.getValue());
		}
		
		return jsonObject;
	}
	
	/**
	 * Metodo que se utiliza para importar un objeto json donde estan las prendas compradas por el cliente
	 * @param listaDePrendas para buscar las prendas que compro el cliente
	 * @param jsonObject a importar
	 * @return las prendas en una coleccion hashMap como clave la prenda y valor la cantidad
	 * @throws JSONException
	 */
	private static HashMap<PrendaDeVestir, Integer> fromJSONObjectPrendasCompradas(ListaDePrendas listaDePrendas,JSONObject jsonObject) throws JSONException{
	
		HashMap <PrendaDeVestir, Integer> prendasCompradas = new HashMap<PrendaDeVestir, Integer>();
		
		Iterator<String> keysItr= jsonObject.keys();
		
		while(keysItr.hasNext()) {
			String codigoPrendaDeVestir = keysItr.next();
			Integer cantidad  = jsonObject.getInt(codigoPrendaDeVestir);
			
			PrendaDeVestir prendaDeVestir = listaDePrendas.buscarPrenda(codigoPrendaDeVestir);
			prendasCompradas.put(prendaDeVestir, cantidad);	
		}
		return prendasCompradas;
	}
	
	public double calcularMonto() {
		double monto = 0;
		
		Set<Entry<PrendaDeVestir, Integer>> set = prendasCompradas.entrySet();
		Iterator<Entry<PrendaDeVestir, Integer>> iterator = set.iterator();
		
		while(iterator.hasNext()) { 
			Entry <PrendaDeVestir, Integer> entry =  iterator.next();
			monto = monto + (entry.getKey().getPrecio() * entry.getValue());
		}
		return monto;
	}
	
}
