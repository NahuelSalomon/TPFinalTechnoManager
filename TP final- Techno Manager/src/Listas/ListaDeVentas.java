package Listas;

import ClaseVenta.Venta;
import ContenedorGenericas.ContenedorClientesYVentas;
import Interfaces.IFuncionesListasClientesYVentas;

public class ListaDeVentas implements IFuncionesListasClientesYVentas<Venta>{
	
	ContenedorClientesYVentas<Venta> ventas;
	
	public ListaDeVentas() {
		ventas = new ContenedorClientesYVentas<Venta>();
	}

	@Override
	public boolean agregarElemento(Venta elemento) {
		return ventas.agragarElemento(elemento);
	}

	@Override
	public boolean bajaElemento(Venta elemento) {
		return ventas.bajaElemento(elemento);
	}

	@Override
	public Venta bajaElemento(int index) {
		return ventas.bajaElemento(index);
	}

	@Override
	public String listarElementos() {
		return ventas.listarElementos();
	}

	@Override
	public Venta buscarElemento(int index) {
		return ventas.buscarElemento(index);
	}


}
