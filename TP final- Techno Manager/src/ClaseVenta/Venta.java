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

/**
 * Clase venta para registrar cada una de las ventas que realizan los clientes.
 * 
 * @author Nahuel
 *
 */
public class Venta implements Serializable{

	private Cliente cliente;
	private Vendedor vendedor;
	private Date fecha;
	private double monto;
	private HashMap<PrendaDeVestir, Integer> prendasCompradas;

	public Venta() {
		prendasCompradas = new HashMap<PrendaDeVestir, Integer>();
	}

	public Venta(Cliente cliente, Vendedor vendedor, Date fecha, double monto,
			HashMap<PrendaDeVestir, Integer> prendasCompradas) {
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.fecha = fecha;
		this.prendasCompradas = prendasCompradas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public Date getFecha() {
		return fecha;
	}

	public double getMonto() {
		return monto;
	}

	public HashMap<PrendaDeVestir, Integer> getPrendasCompradas() {
		return prendasCompradas;
	}

	@Override
	public String toString() {
		return "Cliente: " + getCliente().getNombre() + " " + getCliente().getApellido() + "Vendedor: "
				+ getVendedor().getNombre() + " " + getVendedor().getApellido() + "Fecha: " + getFecha();
	}

	/**
	 * Metodo para devolver la venta en un objeto de json
	 * @return la venta en forma de JSONObject
	 * @throws JSONException
	 */
	public JSONObject toJSONObject() throws JSONException { 
		JSONObject jsonObject = new JSONObject();
	
		jsonObject.put("Cliente: ", getCliente().getNombre()+" "+getCliente().getApellido());
		jsonObject.put("Vendedor: ", getVendedor().getNombre()+" "+getVendedor().getApellido());
		jsonObject.put("Fecha: ", getFecha());
		jsonObject.put("Monto: ", getMonto());
		jsonObject.put("Prendas compradas: ", toJSONObjectPrendasCompradas());
		
	return jsonObject;
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
			jsonObject.put(entry.getKey().tipoDePrenda(), entry.getValue());
		}
		
		return jsonObject;
	}
}
