package Interfaces;

import ClaseVenta.Venta;

public interface IFuncionesBasicasListaVentas {
	
	boolean agregarVenta(Venta elemento);
	boolean bajaVenta(Venta elemento);
	Venta bajaVenta(int index);
	String listarVentas();
	Venta buscarVenta(int index);
}
