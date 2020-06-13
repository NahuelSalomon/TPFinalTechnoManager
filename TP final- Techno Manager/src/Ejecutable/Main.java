package Ejecutable;

import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import ClasesPersona.Cliente;
import ClasesPersona.ClienteMayorista;
import ClasesPersona.ClienteMinorista;
import Listas.ListaDeClientes;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		Date fecha = new Date(1990,05,20);
		@SuppressWarnings("deprecation")
		Date fecha1 = new Date(2001,10,7);
		Cliente cliente1 = new ClienteMayorista("Pepe", "Lopes", "23415432235", 3);
		Cliente cliente2 = new ClienteMinorista("Lara", "Taylor", "76584657", 2, fecha1, "casa9867", "lara@gmailcom");
		
		ListaDeClientes listaClientes = new ListaDeClientes();
		listaClientes.agregarCliente(cliente1);
		listaClientes.agregarCliente(cliente2);
		//listaClientes.listarClientes();
		
		
		try {
			listaClientes.guardar();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ListaDeClientes lista2 = new ListaDeClientes();
		
		try {
			lista2.abrir();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lista2.listarClientes();
		
		JOptionPane.showMessageDialog(null, "hola");	
	}

}
