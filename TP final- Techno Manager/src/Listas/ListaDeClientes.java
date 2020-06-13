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


public class ListaDeClientes implements IFuncionesBasicasListaClientes, Serializable{
	
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
	
	public void guardarListaClientes() {
		String file = "listaCliente.bin";
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(this);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void guardar() throws FileNotFoundException, IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("file"));
        output.writeObject(this);
        output.close();
    }
	
	public void abrir() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("file"));
        ListaDeClientes lista = (ListaDeClientes) input.readObject();
        input.close();
        
        lista.listarClientes();
    }

}
