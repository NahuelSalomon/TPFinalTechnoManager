package Interfaces;

import ClasesPersona.Cliente;

public interface IFuncionesBasicasListaClientes {

	boolean agregarCliente(Cliente elemento);
	boolean bajaCliente(Cliente elemento);
	Cliente bajaCliente(int index);
	String listarClientes();
	Cliente buscarCliente(int index);
	
}