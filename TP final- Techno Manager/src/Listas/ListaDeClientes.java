package Listas;

import ClasesPersona.Cliente;
import ContenedorGenericas.ContenedorClientesYVentas;
import Interfaces.IFuncionesBasicasListaClientes;

/**
 * Lista la cual contiene un contenedor de la logica del manejo de los clientes
 * @author Nahuel
 *
 */
public class ListaDeClientes implements IFuncionesBasicasListaClientes{
	
	ContenedorClientesYVentas<Cliente> clientes;
	
	public ListaDeClientes() {
		clientes = new ContenedorClientesYVentas<Cliente>();
	}	
	
	@Override
	public boolean agregarCliente(Cliente elemento) {
		return clientes.agragarElemento(elemento);
	}

	@Override
	public boolean bajaCliente(Cliente elemento) {
		return clientes.bajaElemento(elemento);
	}

	@Override
	public Cliente bajaCliente(int index) {
		return clientes.bajaElemento(index);
	}

	@Override
	public String listarClientes() {
		return clientes.listarElementos();
	}

	@Override
	public Cliente buscarCliente(int index) {
		return clientes.buscarElemento(index);
	}
	
	
	/**
	 * Modifica un cliente de la lista 
	 * @param index del cliente a modificar
	 * @param clienteModificado cliente ya modificado
	 * @return true si se modifica correctamente, false en caso contrario.
	 */
	public boolean modificarElemento(int index, Cliente clienteModificado) {
		return clientes.modificarElemento(index, clienteModificado);
	}

	/**
	 * Metodo para comprobar si existe un cliente
	 * @param cliente a verificar
	 * @return true si existe, false en caso contrario
	 */
	public boolean existeCliente(Cliente cliente) { 
		return clientes.existeElemento(cliente);
	}
}
