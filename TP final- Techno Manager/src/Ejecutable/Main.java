package Ejecutable;

import javax.swing.JOptionPane;

import Archivos.archivoClientes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import ClasesPersona.Cliente;
import ClasesPersona.ClienteMayorista;
import ClasesPersona.ClienteMinorista;
import ClasesPersona.Empleado;
import ClasesPersona.Vendedor;
import ClasesPrendasDeVestir.Calzado;
import ClasesPrendasDeVestir.PrendaDeVestir;
import Listas.ListaDeClientes;
import Listas.ListaDeEmpleados;
import Listas.ListaDePrendas;

public class Main {

	public static <OtraListaPrenda> void main(String[] args) {
		@SuppressWarnings("deprecation")
		Date fecha = new Date(1990,05,20);
		@SuppressWarnings("deprecation")
		Date fecha1 = new Date(2001,10,7);

		Cliente cliente2 = new ClienteMinorista("Lara", "Taylor");

	    Vendedor empleado = new Vendedor("lucas","zelaya","123","soy gay") ;
	    ListaDeEmpleados lista = new ListaDeEmpleados();
	    lista.agregarEmpleado(empleado.getLegajo(), empleado);
			
			
		

		
		/*
		
		
		ListaDeClientes listaClientes = new ListaDeClientes();
	
		listaClientes.agregarElemento(cliente2);
		//listaClientes.listarClientes();
		
		PrendaDeVestir prenda1 = new Calzado(2,"NuevoModelo","rojo",4,2);
		PrendaDeVestir prenda2 = new Calzado(3,"OtroModelo","azul",1,5);
		OtraListaPrendas listaPrendas = new ListaDeClientes();
		listaPrendas.agregarElemento("1", prenda1);
		listaPrendas.agregarElemento("2", prenda2);
		
		
		try {
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ListaDeClientes lista2 = new ListaDeClientes();
		ListaDeClientes listaP2 = new ListaDeClientes();
		
		try {
			
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
		
//		System.out.println(lista2.listarElementos());
//		System.out.println("");
		System.out.println(listaP2.listarElementos("Claves:", "Valores:"));
		
		
	
	*/	
	}

}
