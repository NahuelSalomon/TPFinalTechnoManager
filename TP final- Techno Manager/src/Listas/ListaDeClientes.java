package Listas;

import ClasesPersona.Cliente;
import ContenedorGenericas.ContenedorClientesYVentas;
import Interfaces.IFuncionesBasicasListaClientes;


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
	
	//TODO comentar
	/**
	 * C
	 * @param index
	 * @param nuevo_cliente
	 * @return
	 */
	public boolean modificarElemento(int index, Cliente nuevo_cliente) {
		return clientes.modificarElemento(index, nuevo_cliente);
	}

}
