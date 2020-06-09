package Interfaces;

/**
 * Interface generica para implentar la funciones básicas de las listas de clientes y ventas
 * @author Techno Manager
 *
 * @param <K> clave 
 * @param <V> valor
 */

public interface IFuncionesListasClientesYVentas <E>{
	
	boolean agregarElemento(E elemento);
	boolean bajaElemento(E elemento);
	E bajaElemento(int index);
	String listarElementos();
	E buscarElemento(int index);
	
}
