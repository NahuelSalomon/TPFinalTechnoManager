package ClaseVenta;

import java.util.Date;
import java.util.HashMap;

import ClasesPersona.Cliente;
import ClasesPersona.Vendedor;
import ClasesPrendasDeVestir.PrendaDeVestir;

/**
 * Clase venta para registrar cada una de las ventas que realizan los clientes.
 * @author Nahuel
 *
 */
public class Venta {
	
	private Cliente cliente;
	private Vendedor vendedor;
	private Date fecha;
	private double monto;
	private HashMap<PrendaDeVestir, Integer> prendasCompradas;
	
	public Venta() {
		prendasCompradas = new HashMap<PrendaDeVestir, Integer>();
	}
	
	public Venta(Cliente cliente, Vendedor vendedor, Date fecha, double monto, HashMap<PrendaDeVestir, Integer> prendasCompradas) {
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
		return "Cliente: "+getCliente().getNombre()+" "+getCliente().getApellido()+"Vendedor: "+getVendedor().getNombre()+" "+getVendedor().getApellido()
				+"Fecha: "+getFecha();
	}
	
	
}
