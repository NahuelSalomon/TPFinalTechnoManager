package Interfaces;

import ClaseVenta.Venta;

/**
 * Esta intefaz se utiliza para que la lista de las ventas utilice los métodos
 * básicos.
 * 
 * @author Nicolas
 *
 */
public interface IFuncionesBasicasListaVentas {

	/**
	 * Agrega una venta a la lista de las ventas
	 * 
	 * @param venta a agregar
	 * @return true si se agrega correctamente, false en caso contrario
	 */
	boolean agregarVenta(Venta venta);

	/**
	 * Da de baja una venta de la lista
	 * 
	 * @param venta a dar de baja
	 * @return true si se da de baja correctamente, false en caso contrario.
	 */
	boolean bajaVenta(Venta venta);

	/**
	 * Da de baja una venta de la lista
	 * 
	 * @param index de la posicion de la venta en la lista a dar de baja
	 * @return la venta dada de baja
	 */
	Venta bajaVenta(int index);

	/**
	 * Lista todas las ventas de la lista.
	 * 
	 * @return las listas en forma de String.
	 */
	String listarVentas();

	/**
	 * Busca una venta por el indice en la venta.
	 * 
	 * @param index de la venta en la lista a buscar.
	 * @return la venta buscada
	 */
	Venta buscarVenta(int index);
}
