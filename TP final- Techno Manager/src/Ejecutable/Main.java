package Ejecutable;

import javax.swing.JOptionPane;

import org.json.JSONException;

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
import ClasesPrendasDeVestir.Maya;
import ClasesPrendasDeVestir.Pantalon;
import ClasesPrendasDeVestir.PrendaDeVestir;
import ClasesPrendasDeVestir.PrendaSuperior;
import ClasesPrendasDeVestir.Remera;
import Excepciones.LimiteExedidoDeGerenteExcepcion;
import Excepciones.ErrorDeBusquedaExcepcion;
import Listas.ListaDeClientes;
import Listas.ListaDeEmpleados;
import Listas.ListaDePrendas;
import Listas.ListaDeVentas;

public class Main {

	public static void main(String[] args) {

	
	TiendaDeRopa tiendaDeRopa = new TiendaDeRopa();
	
		//CODIGO AUXILIAR EN CASO QUE SE ROMPAN ARCHIVOS

	/*Cliente cliente = new ClienteMinorista("Juan", "Perez", "43569871", 1, "12/2/1999", "Brown 1888", "juanmdq@hotmail.com");
	Cliente cliente2 = new ClienteMayorista("Pedro", "Soto", "41658791", 1, "10/4/7", "Avellaneda 1555", "pedrosoto@hotmail.com", "25897461918", 3);
	Cliente cliente3 = new ClienteMinorista("Cecs", "Fábregas", "69456321", 1, "14/8/2016", "Castelli 1455", "cecsfabregas@hotmail.com");
	Cliente cliente4 = new ClienteMayorista("Pepe", "Solis", "23147963", 1, "5/8/2014", "Saavedra 3698", "solispepe@hotmail.com", "25874136987", 6);
	
	Empleado empleado = new Vendedor("Ricardo", "Jose", "223693147", 1, "22/8/1978", 2, "22598741", "69326", "12345");
	Empleado empleado2 = new Vendedor("Mariano", "Gonzales", "229693187", 1, "22/7/1978", 1, "22598742", "69327", "12345");
	Empleado empleado3 = new Vendedor("Fabricio", "Polo", "225693199", 1, "25/8/1985", 2, "22598743", "69328", "12345");
	Empleado empleado4 = new Gerente("Mariana", "Mendez", "225693147", 3, "22/8/1999", 3, "69329", "12345");
	
	PrendaDeVestir prenda1 = new Buzo(3, "King of seduction", "Verde", 1, false, true, 500);
	PrendaDeVestir prenda2 = new Pantalon(6, "Polska", "Rojo", 1, true, 1200);
	PrendaDeVestir prenda3 = new Remera(7, "Hunter", "Azul", 2, true, "Batman", 1600);
	PrendaDeVestir prenda4 = new Maya(9, "2.0", "Amarillo", 1, true, true, 450);
	
	
	
	HashMap<PrendaDeVestir, Integer> prendasCompradas = new HashMap<PrendaDeVestir, Integer>();
	HashMap<PrendaDeVestir, Integer> prendasCompradas2 = new HashMap<PrendaDeVestir, Integer>();
	HashMap<PrendaDeVestir, Integer> prendasCompradas3 = new HashMap<PrendaDeVestir, Integer>();
	HashMap<PrendaDeVestir, Integer> prendasCompradas4 = new HashMap<PrendaDeVestir, Integer>();
	prendasCompradas.put(prenda1, 6);
	prendasCompradas.put(prenda3, 5);
	prendasCompradas2.put(prenda2, 2);
	prendasCompradas2.put(prenda4, 9);
	prendasCompradas3.put(prenda3, 7);
	prendasCompradas3.put(prenda4, 2);
	prendasCompradas4.put(prenda1, 3);
	prendasCompradas4.put(prenda2, 9);
	
	Venta venta = new Venta(cliente, (Vendedor) empleado, "25/8/20", prendasCompradas);
	Venta venta2 = new Venta(cliente2, (Vendedor) empleado2, "12/4/20", prendasCompradas2);
	Venta venta3 = new Venta(cliente3, (Vendedor) empleado3, "5/8/19",  prendasCompradas3);
	Venta venta4 = new Venta(cliente4, (Vendedor) empleado, "6/7/2019", prendasCompradas4);
	
    	
	   
    tiendaDeRopa.agregarCliente(cliente);
    tiendaDeRopa.agregarCliente(cliente2);
    tiendaDeRopa.agregarCliente(cliente3);
    tiendaDeRopa.agregarCliente(cliente4);
    
    try {
    tiendaDeRopa.agregarEmpleado(empleado.getLegajo(), empleado);
    tiendaDeRopa.agregarEmpleado(empleado2.getLegajo(), empleado2);
    tiendaDeRopa.agregarEmpleado(empleado3.getLegajo(), empleado3);
    tiendaDeRopa.agregarEmpleado(empleado4.getLegajo(), empleado4);
    }
    catch (LimiteExedidoDeGerenteExcepcion e) {
		e.printStackTrace();
	}
    
    tiendaDeRopa.agregarPrenda(prenda1.getCodigo(), prenda1);
    tiendaDeRopa.agregarPrenda(prenda2.getCodigo(), prenda2);
    tiendaDeRopa.agregarPrenda(prenda3.getCodigo(), prenda3);
    tiendaDeRopa.agregarPrenda(prenda4.getCodigo(), prenda4);
    
    tiendaDeRopa.agregarVenta(venta);
    tiendaDeRopa.agregarVenta(venta2);
    tiendaDeRopa.agregarVenta(venta3);
    tiendaDeRopa.agregarVenta(venta4);
    
	/*try {
		
		System.out.println("Antes de JSON\n\n\n");
		System.out.println(tiendaDeRopa.listarClientes());
		System.out.println(tiendaDeRopa.listarEmpleados());
		System.out.println(tiendaDeRopa.listarPrenda());
		System.out.println(tiendaDeRopa.listarVentas());
		
		System.out.println("\n\n\nExportado a JSON");
		System.out.println(tiendaDeRopa.toJsonObject());
	
		System.out.println("\n\n\nImportado a JSON");
		System.out.println(TiendaDeRopa.fromJSONObject(tiendaDeRopa.toJsonObject()).listarClientes());
		System.out.println(TiendaDeRopa.fromJSONObject(tiendaDeRopa.toJsonObject()).listarEmpleados());
		System.out.println(TiendaDeRopa.fromJSONObject(tiendaDeRopa.toJsonObject()).listarPrenda());
		System.out.println(TiendaDeRopa.fromJSONObject(tiendaDeRopa.toJsonObject()).listarVentas());
	
		
	}	
    catch (JSONException e) {
		e.printStackTrace();
	}
    
	tiendaDeRopa.guardarTiendaDeRopa();
	
	System.out.println(tiendaDeRopa.listarClientes());
	System.out.println(tiendaDeRopa.listarEmpleados());
	System.out.println(tiendaDeRopa.listarPrenda());
	System.out.println(tiendaDeRopa.listarVentas());*/

	VentanaDeEntrada ventanaDeEntrada = new VentanaDeEntrada(tiendaDeRopa);
	ventanaDeEntrada.setVisible(true);

//	Empleado empleado2 = null;
//	try {
//		empleado2 = tiendaDeRopa.buscarEmpleado("69344");
//	} catch (ErrorDeBusquedaExcepcion e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
//	
//	try {
//		VentanaOpcionesEmpleado ventanaOpcionesEmpleado = new VentanaOpcionesEmpleado(empleado2, tiendaDeRopa);
//		ventanaOpcionesEmpleado.setVisible(true);
//	} catch (FileNotFoundException e) {
//		e.printStackTrace();
//	} catch (ClassNotFoundException e) {
//		e.printStackTrace();
//	} catch (IOException e) {
//		e.printStackTrace();
//	} 
	
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
