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
	public boolean agregarVenta(Venta elemento) {
		return ventas.agragarElemento(elemento);
	}

	@Override
	public boolean bajaVenta(Venta elemento) {
		return ventas.bajaElemento(elemento);
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
