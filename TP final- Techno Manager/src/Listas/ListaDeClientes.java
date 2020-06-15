package Listas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import ClasesPersona.Cliente;
import ContenedorGenericas.ContenedorClientesYVentas;
import Interfaces.IFuncionesBasicasListaClientes;

/**
 * Lista la cual contiene un contenedor de la logica del manejo de los clientes
 * 
 * @author Nahuel
 *
 */

public class ListaDeClientes implements IFuncionesBasicasListaClientes, Serializable {

	ContenedorClientesYVentas<Cliente> clientes;

	public ListaDeClientes() {
		clientes = new ContenedorClientesYVentas<Cliente>();
	}

	@Override
	public boolean agregarCliente(Cliente elemento) {
		return clientes.agregarElemento(elemento);
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

//	/**
//	 * Modifica un cliente de la lista
//	 * 
//	 * @param index             del cliente a modificar
//	 * @param clienteModificado cliente ya modificado
//	 * @return true si se modifica correctamente, false en caso contrario.
//	 */
//	public boolean modificarElemento(int index, Cliente clienteModificado) {
//		return clientes.modificarElemento(index, clienteModificado);
//	}
//
//	public void guardarListaClientes() {
//		String file = "listaCliente.bin";
//		try {
//			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//			oos.writeObject(this);
//			oos.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public void guardar() throws FileNotFoundException, IOException {
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("fileClientes"));
		output.writeObject(this);
		output.close();
	}

	public ListaDeClientes abrir() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("fileClientes"));
		ListaDeClientes lista = (ListaDeClientes) input.readObject();
		input.close();
		return lista;
	}

	/**
	 * Metodo para comprobar si existe un cliente
	 * 
	 * @param cliente a verificar
	 * @return true si existe, false en caso contrario
	 */
	public boolean existeCliente(Cliente cliente) {
		return clientes.existeElemento(cliente);
	}
	
	public boolean comparaNomApe(Cliente cliente) {
		return clientes.comparaNomApe(cliente);
	}
}
