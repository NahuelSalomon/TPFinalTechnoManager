package Interfaces;

/**
 * Interface generica para implentar la funciones básicas de las listas de prendas y empleados
 * @author Techno Manager
 *
 * @param <K> clave 
 * @param <V> valor
 */

public interface IFuncionesListasPrendasYEmpleados <K,V>{
	
	boolean agregarElemento(K clave, V valor);
	boolean bajaElemento(K clave);
	boolean modificarElemento(K clave);
	String listarElementos(K nom_clave, V nom_valor);
	V buscarElemento(K clave);
	
}
