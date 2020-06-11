package Interfaces;

import ClasesPersona.Cliente;

/**
 * Esta intefaz se utiliza para que la lista de los clientes utilice los métodos básicos.
 * @author Nicolas
 *
 */
public interface IFuncionesBasicasListaClientes {

	/**
	 * Agrega un cliente a la lista
	 * @param cliente agregado
	 * @return true si se agrega, false en caso contrario
	 */
	boolean agregarCliente(Cliente cliente);
	
	/**
	 * Da de baja un cliente de la lista 
	 * @param cliente dado de baja.
	 * @return true si se da de baja correctamente, false en caso contrario.
	 */
	boolean bajaCliente(Cliente cliente);
	
	/**
	 * Da de baja un cliente de la lista
	 * @param index de la lista donde se encuentra el cliente a dar de baja
	 * @return true si se da de baja correctamente, false en caso contrario.
	 */
	Cliente bajaCliente(int index);
	
	/**
	 * Lista todos los cliente de la lista
	 * @return los clientes en forma de String
	 */
	String listarClientes();
	
	/**
	 * Devuelve un cliente en particular buscandolo a travéz del indice de la lista
	 * @param index
	 * @return
	 */
	Cliente buscarCliente(int index);
	
}