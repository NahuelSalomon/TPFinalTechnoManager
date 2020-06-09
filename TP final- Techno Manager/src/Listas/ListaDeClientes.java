package Listas;

import ClasesPersona.Cliente;
import ContenedorGenericas.ContenedorClientesYVentas;
import Interfaces.IFuncionesListasClientesYVentas;

public class ListaDeClientes implements IFuncionesListasClientesYVentas<Cliente>{
	
	ContenedorClientesYVentas<Cliente> clientes;
	
	public ListaDeClientes() {
		clientes = new ContenedorClientesYVentas<Cliente>();
	}

	@Override
	public boolean agregarElemento(Cliente elemento) {
		return clientes.agragarElemento(elemento);
	}

	@Override
	public boolean bajaElemento(Cliente elemento) {
		return clientes.bajaElemento(elemento);
	}

	@Override
	public Cliente bajaElemento(int index) {
		return clientes.bajaElemento(index);
	}

	@Override
	public String listarElementos() {
		return clientes.listarElementos();
	}

	@Override
	public Cliente buscarElemento(int index) {
		return clientes.buscarElemento(index);
	}
	
	public boolean modificarElemento(int index, Cliente nuevo_cliente) {
		return clientes.modificarElemento(index, nuevo_cliente);
	}
	
}
