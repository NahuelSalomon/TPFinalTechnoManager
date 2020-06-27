package Ejecutable;

import javax.swing.JOptionPane;

import Archivos.archivoClientes;
import Archivos.archivoEmpleados;
import Archivos.archivoPrendas;
import Archivos.archivoVentas;
import ClaseVenta.Venta;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import ClasesPersona.Cliente;
import ClasesPersona.ClienteMayorista;
import ClasesPersona.ClienteMinorista;
import ClasesPersona.Empleado;
import ClasesPersona.Gerente;
import ClasesPersona.Vendedor;
import ClasesPrendasDeVestir.Buzo;
import ClasesPrendasDeVestir.Calzado;
import ClasesPrendasDeVestir.PrendaDeVestir;
import ClasesPrendasDeVestir.PrendaSuperior;
import ClasesPrendasDeVestir.Remera;
import Listas.ListaDeClientes;
import Listas.ListaDeEmpleados;
import Listas.ListaDePrendas;
import Listas.ListaDeVentas;

public class Main {

	public static void main(String[] args) {
	    
//    PrendaDeVestir prenda1 = new Calzado();
//    PrendaDeVestir prenda2 = new Remera();
//    Cliente cliente1 = new ClienteMayorista();
//    Cliente cliente2 = new ClienteMinorista();
//    Empleado vendedor = new Vendedor();
//    Empleado gerente = new Gerente();
//    Venta venta1 = new Venta();
//	  Empleado vendedorOp = new Vendedor("Nicolas","Gonzalez", "43312532", 3, "17/03/2001", 1,"2233013445", "007","contra");
//    
//    ListaDeClientes lc = new ListaDeClientes();
//    ListaDePrendas lp = new ListaDePrendas();
//    ListaDeEmpleados le = new ListaDeEmpleados();
//    ListaDeVentas lv = new ListaDeVentas();
//    lc.agregarCliente(cliente1);
//    lc.agregarCliente(cliente2);
//    lp.agregarPrenda("1", prenda1);
//    lp.agregarPrenda("2", prenda2);
//    le.agregarEmpleado("1", vendedor);
//    le.agregarEmpleado("2", gerente);
//    le.agregarEmpleado(vendedorOp.getLegajo(), vendedorOp);
//    lv.agregarVenta(venta1);
//    
//    archivoClientes.grabarClientes(lc);
//    archivoPrendas.grabarPrendas(lp);
//    archivoEmpleados.grabarEmpleados(le);
//    archivoVentas.grabarVentas(lv);
	
    TiendaDeRopa tiendaDeRopa = new TiendaDeRopa();	
	    
//	VentanaDeEntrada ventanaDeEntrada = new VentanaDeEntrada(tiendaDeRopa);
//	ventanaDeEntrada.setVisible(true);
	
	try {
		VentanaOpcionesEmpleado ventanaEmpeados = new VentanaOpcionesEmpleado("007", tiendaDeRopa);
		ventanaEmpeados.setVisible(true);
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
	
	    /*MenuCliente menuCliente = new MenuCliente(); 
		
		ListaDeClientes listaClientes = new ListaDeClientes();
	
		listaClientes.agregarElemento(cliente2);
		listaClientes.listarClientes();
		
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
		
		System.out.println(lista2.listarElementos());
		System.out.println("");
		System.out.println(listaP2.listarElementos("Claves:", "Valores:"));
		*/	
	}

}
