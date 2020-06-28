package Ejecutable;

import java.util.ArrayList;

import Archivos.archivoClientes;
import Archivos.archivoEmpleados;
import Archivos.archivoPrendas;
import Archivos.archivoVentas;
import ClaseVenta.Venta;
import ClasesPersona.Cliente;
import ClasesPersona.Empleado;
import ClasesPrendasDeVestir.PrendaDeVestir;
import Listas.ListaDeClientes;
import Listas.ListaDeEmpleados;
import Listas.ListaDePrendas;
import Listas.ListaDeVentas;

/**
 * Esta es clase tienda de ropa que admisnistra empleados, clietes, prendas de
 * vestir, ventas, y su relacion entre ellos.
 * 
 * @author Nahuel
 *
 */
public class TiendaDeRopa {

	private ListaDeClientes clientes;
	private ListaDeEmpleados empleados;
	private ListaDePrendas prendasDeVestir;
	private ListaDeVentas ventas;

	public TiendaDeRopa() {

		clientes = new ListaDeClientes(archivoClientes.leerClientes());
		empleados = new ListaDeEmpleados(archivoEmpleados.leerEmpleados());
		prendasDeVestir = new ListaDePrendas(archivoPrendas.leerPrendas());
		ventas = new ListaDeVentas(archivoVentas.leerVentas());
	}

	/**
	 * Agrega un cliente a la tienda de ropa
	 * 
	 * @param cliente a agregar
	 * @return true si se agrega correctamente, false en caso contrario
	 */
	public boolean agregarCliente(Cliente cliente) {
		return clientes.agregarCliente(cliente);
	}

	/**
	 * Da de baja un cliente de la tienda de ropa
	 * 
	 * @param cliente a dar de baja
	 * @return true si se da de baja, false en caso contrario
	 */
	public boolean bajaCliente(Cliente cliente) {
		return clientes.bajaCliente(cliente);
	}

	/**
	 * Da de baja un cliente de la tienda de ropa
	 * 
	 * @param index del cliente en la lista a dar de baja
	 * @return true si se da de baja correctamente, false en caso contrario
	 */
	public Cliente bajaCliente(int index) {
		return clientes.bajaCliente(index);
	}

	/**
	 * Lista todos los clientes de la tienda de ropa.
	 * 
	 * @return los cliente en forma de String.
	 */
	public String listarClientes() {
		return clientes.listarClientes();
	}

	/**
	 * Busca un cliente en la tienda de ropa
	 * 
	 * @param index de la lista de clientes
	 * @return los clientes en forma de String
	 */
	public Cliente buscarCliente(int index) {
		return clientes.buscarCliente(index);
	}

	/**
	 * Agrega un empleado a la tienda de ropa
	 * 
	 * @param legajo   del empleado agregado
	 * @param empleado a agregar
	 * @return true si se agrega correctamente, false en caso contrario
	 */
	public boolean agregarEmpleado(String legajo, Empleado empleado) {
		return empleados.agregarEmpleado(legajo, empleado);
	}

	/**
	 * Da de baja un cliente de la lista
	 * 
	 * @param legajo del empleado a dar de baja
	 * @return true si se da de baja correctamente, false en caso contrario
	 */
	public boolean bajaEmpleado(String legajo) {
		return empleados.bajaEmpleado(legajo);
	}

	/**
	 * Modifica un empleado de la tienda de ropa
	 * 
	 * @param legajo             del empleado a modificar
	 * @param empleadoModificado empleado ya modificado.
	 * @return true si se modifica correctamente, false en caso contrario
	 */
	public boolean modificarEmpleado(String legajo, Empleado empleadoModificado) {
		return empleados.modificarEmpleado(legajo, empleadoModificado);
	}

	/**
	 * Lista todos los empleados de la tienda de ropa
	 * 
	 * @return los empleados en forma de String
	 */
	public String listarEmpleados() {
		return empleados.listarEmpleados();
	}

	/**
	 * Busca un empleado de la tienda de ropa
	 * 
	 * @param legajo del empleado buscado
	 * @return el empleado buscado.
	 */
	public Empleado buscarEmpleado(String legajo) {
		return empleados.buscarEmpleado(legajo);
	}

	/**
	 * Agrega una prenda de vestir a la tienda de ropa
	 * 
	 * @param codigo         de la prenda de ropa
	 * @param prendaDeVestir a agregar
	 * @return true si se agregar la prenda correctamente, false en caso contrario
	 */
	public boolean agregarPrenda(String codigo, PrendaDeVestir prendaDeVestir) {
		return prendasDeVestir.agregarPrenda(codigo, prendaDeVestir);
	}

	/**
	 * Da de baja una prenda de la tienda de ropa
	 * 
	 * @param codigo de la prenda a dar de baja
	 * @return true si se da de baja correctamente, false en caso contrario.
	 */
	public boolean bajaPrenda(String codigo) {
		return prendasDeVestir.bajaPrenda(codigo);
	}

	/**
	 * Modifica una prenda de la tienda de ropa
	 * 
	 * @param codigo           de la prenda a modificar
	 * @param prendaModificada prenda ya modificadad
	 * @return true si se modifica correctamente, false en caso contrario
	 */
	public boolean modificarPrenda(String codigo, PrendaDeVestir prendaModificada) {
		return prendasDeVestir.modificarPrenda(codigo, prendaModificada);
	}

	/**
	 * Lista todas las prendas de tienda de ropa
	 * 
	 * @return las prendas en forma de String
	 */
	public String listarPrenda() {
		return prendasDeVestir.listarPrendas();
	}

	/**
	 * Busca una prenda de vestir en la tienda de ropa
	 * 
	 * @param codigo de la prenda buscada
	 * @return la prenda buscada
	 */
	public PrendaDeVestir buscarPrenda(String codigo) {
		return prendasDeVestir.buscarPrenda(codigo);
	}
	
	public ArrayList<PrendaDeVestir> devolverPrendas(){
		return prendasDeVestir.devolverListaDePrendas();
	}
	
	/**
	 * Agrega un registro de venta a la tienda de ropa
	 * 
	 * @param venta agregada
	 * @return true si se agrego correctamente, false en caso contrario
	 */
	public boolean agregarVenta(Venta venta) {
		return ventas.agregarVenta(venta);
	}

	/**
	 * Da de baja un registro de venta en la tienda de ropa
	 * 
	 * @param venta a dar de baja
	 * @return true si se da de baja correctamente, false en caso contrario.
	 */
	public boolean bajaVenta(Venta venta) {
		return ventas.bajaVenta(venta);
	}

	/**
	 * Da de baja una venta de la tienda de ropa
	 * 
	 * @param index indice de la prenda en la lista de prendas de la tienda de ropa
	 *              para dar de baja
	 * @return la venta dada de baja
	 */
	public Venta bajaVenta(int index) {
		return ventas.bajaVenta(index);
	}

	/**
	 * Lista las ventas de la tienda de ropa
	 * 
	 * @return las ventas en forma de String
	 */
	public String listarVentas() {
		return ventas.listarVentas();
	}

	/**
	 * Busca una venta en la tienda de ropa
	 * 
	 * @param index de la venta de la lista de ventas de la tienda de ropa
	 * @return la venta buscada
	 */
	public Venta buscarVenta(int index) {
		return ventas.buscarVenta(index);
	}

	/**
	 * Metodo para verificar si existe un cliente en la tienda de ropa
	 * 
	 * @param cliente a verificar
	 * @return true si existe , false en caso contrario
	 */
	public boolean existeCliente(Cliente cliente) {
		return clientes.existeCliente(cliente);
	}

	/**
	 * Metodo para verificar si existe una venta en la tienda de ropa
	 * 
	 * @param venta a verificar
	 * @return true si existe , false en caso contrario
	 */
	public boolean existeVenta(Venta venta) {
		return ventas.existeVenta(venta);
	}

	/**
	 * Metodo para verificar si existe un empleado en la tienda de ropa
	 * 
	 * @param legajo del empleado a verificar
	 * @return true si existe , false en caso contrario
	 */
	public boolean existeEmpleado(String legajo) {
		return empleados.existeEmpleado(legajo);
	}

	/**
	 * Metodo para verificar si existe una prenda en la tienda de ropa
	 * 
	 * @param codigo de la prenda a verificar
	 * @return true si existe , false en caso contrario
	 */
	public boolean existePrenda(String codigo) {
		return prendasDeVestir.existePrendaDeVesitr(codigo);
	}

	/**
	 * se encargar de validar los datos del usuario que ingreso con los cargados de el inicialmente
	 * 
	 * @param legajo recibe el legajo que el usuario ingreso
	 * @param contraseña recibe la contraseña ingresada por el usuario
	 * @param tipoDeEmpleado recibe el tipo de emleado que ingreso el usuario
	 * @return true si los datos fueron ingresados bien, false en caso contrario
	 */
	public boolean verificarEmpleado(String legajo, String contraseña, String tipoDeEmpleado)
	{
		return empleados.verificarEmpleado(legajo, contraseña, tipoDeEmpleado);
	}
	
	/**
	 * Utiliza las clases de Archivos para guardar las Listas
	 */
	public void guardarTiendaDeRopa() {
		archivoEmpleados.grabarEmpleados(empleados);
		archivoClientes.grabarClientes(clientes);;
		archivoPrendas.grabarPrendas(prendasDeVestir);
		archivoVentas.grabarVentas(ventas);
	}
	
	public ArrayList<Cliente> devolverClientes(){
		return clientes.devolverClientes();
	}

}
