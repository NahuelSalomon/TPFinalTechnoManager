package Listas;

import ClaseVenta.Venta;
import ContenedorGenericas.ContenedorClientesYVentas;
import Interfaces.IFuncionesBasicasListaVentas;


public class ListaDeVentas implements IFuncionesBasicasListaVentas{
	
	ContenedorClientesYVentas<Venta> ventas;
	
	public ListaDeVentas() {
		ventas = new ContenedorClientesYVentas<Venta>();
	}
	
	@Override
	public boolean agregarVenta(Venta venta) {
		return ventas.agragarElemento(venta);
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


}
