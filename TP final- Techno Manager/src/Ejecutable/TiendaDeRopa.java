package Ejecutable;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import Archivos.archivoClientes;
import Archivos.archivoEmpleados;
import Archivos.archivoPrendas;
import Archivos.archivoVentas;
import ClaseVenta.Venta;
import ClasesPersona.Cliente;
import ClasesPersona.Empleado;
import ClasesPrendasDeVestir.PrendaDeVestir;
import Excepciones.ErrorDeBusquedaExcepcion;
import Excepciones.LimiteExedidoDeGerenteExcepcion;
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

	public TiendaDeRopa(ListaDeClientes listaDeClientes, ListaDeEmpleados listaDeEmpleados, ListaDePrendas listaDePrendas, ListaDeVentas listaDeVentas) {
		this.clientes = listaDeClientes;
		this.empleados = listaDeEmpleados;
		this.prendasDeVestir = listaDePrendas;
		this.ventas = listaDeVentas;
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
	 * @throws LimiteExedidoDeGerenteExcepcion 
	 */
	public boolean agregarEmpleado(String legajo, Empleado empleado) throws LimiteExedidoDeGerenteExcepcion {
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
	 * @throws ErrorDeBusquedaExcepcion 
	 */
	public Empleado buscarEmpleado(String legajo) throws ErrorDeBusquedaExcepcion {
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
	 * @throws ErrorDeBusquedaExcepcion 
	 */
	public PrendaDeVestir buscarPrenda(String codigo) throws ErrorDeBusquedaExcepcion {
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
	 * @throws ErrorDeBusquedaExcepcion 
	 */
	public boolean verificarEmpleado(String legajo, String contraseña, String tipoDeEmpleado) throws ErrorDeBusquedaExcepcion
	{
		return empleados.verificarEmpleado(legajo, contraseña, tipoDeEmpleado);
	}
	
	/**
	 * Metodo para devolver los empleados con su legajo, nombre y apellido.
	 * @return los empleados con su legajo nombre y apellido en forma de String
	 */
	public String devolverNombreYApellidoEmpleadosConLegajo() {
		return empleados.devolverNombreYApellidoEmpleadosConLegajo();
	}
	
	/**
	 * Devulve todas la prendas con su respectivo codigo 
	 * @return las prendas con su codigo en forma de String 
	 */
	public String devolverPrendasConSuCodigo() {
		return prendasDeVestir.devolverPrendasConSuCodigo();
	} 
	
	/**
	 * Busca una venta por su id
	 * @param id de la venta a buscar
	 * @return la venta
	 * @throws ErrorDeBusquedaExcepcion 
	 */
	public Venta buscarVentaPorID(int id) throws ErrorDeBusquedaExcepcion {
		return ventas.buscarVentaPorID(id);
	}
	
	/**
	 * Utiliza las clases de Archivos para guardar las Listas
	 */
	public void guardarTiendaDeRopa() {
		archivoEmpleados.grabarEmpleados(empleados);
		archivoClientes.grabarClientes(clientes);
		archivoPrendas.grabarPrendas(prendasDeVestir);
		archivoVentas.grabarVentas(ventas);
	}
	
	/**
	 * Devuelve los cliente en forma de arrayList
	 * @return el arrayList de los clientes
	 */
	public ArrayList<Cliente> devolverClientes(){
		return clientes.devolverClientes();
	}
	
	/**
	 * Metodo que agrega una determinanda cantidad de prendas a un determinado talle
	 * @param codigo de la prenda a agregar
	 * @param talle a agregar
	 * @param cantidad a agregar
	 * @throws ErrorDeBusquedaExcepcion
	 */
	public void agregarCantidadATalleEnPrenda(String codigo, String talle, Integer cantidad) throws ErrorDeBusquedaExcepcion {
		prendasDeVestir.buscarPrenda(codigo).agregarCantidadATalle(talle, cantidad);
	}
	
	
	/**
	 * Busca un cliente por dni
	 * @param dni del cliente a buscar
	 * @return el cliente
	 * @throws ErrorDeBusquedaExcepcion 
	 */
	public Cliente buscarClientePorDni(String dni) throws ErrorDeBusquedaExcepcion {
		return clientes.buscarClientePorDNI(dni);
	}
	
	/**
	 * Lista todas las ventas de un determinado vendedor
	 * @param legajo del vendedor a listar ventas
	 * @return las ventas en forma de String
	 */
	public String listarVentasDeUnVendedor(String legajo) {
		return ventas.listarVentasDeUnVendedor(legajo);
	
	}
	
	
	/**
	 * Lista todas las ventas hechas de un determinado cliente
	 * @param dni del cliente a listar las ventas
	 * @return las ventas en forma de String
	 */
	public String listarVentasDeUnCliente(String dni) {
		return ventas.listarVentasDeUnCliente(dni);
	}
	
	/**
	 * Metodo que devuelve las ventas promedios
	 * @return las ventas promedios mediante un valor real 
	 */
	public double devolverVentasPromedio() {
		return ventas.devolverVentasPromedio();
	}
	
	/**
	 * Metodo que devuelve las ventas totales
	 * @return las ventas totales mediante un valor real 
	 */
	public double devolverVentasTotales() {
		return ventas.devolverVentasTotales();
	}
	
	/**
	 * Metodo para convertir la tienda de ropa a un objecto json
	 * @return el jsonObject
	 * @throws JSONException 
	 */
	public JSONObject toJsonObject () throws JSONException {
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("Clientes", clientes.toJsonArray());
		jsonObject.put("Empleados", empleados.toJsonArray());
		jsonObject.put("Prendas de vestir", prendasDeVestir.toJsonArray());
		jsonObject.put("Ventas", ventas.toJsonArray());
		
		return jsonObject;
	
	}
	
	/**
	 * Metodo para importar una tienda de ropa desde un objecto JSON
	 * @param jsonObject a importar
	 * @return la tienda de ropa
	 * @throws JSONException
	 */
	public static TiendaDeRopa fromJSONObject(JSONObject jsonObject) throws JSONException {
		
		ListaDeClientes listaDeClientes = ListaDeClientes.fromJSONArray(jsonObject.getJSONArray("Clientes"));
		ListaDeEmpleados listaDeEmpleados = ListaDeEmpleados.fromJSONArray(jsonObject.getJSONArray("Empleados"));
		ListaDePrendas listaDePrendas = ListaDePrendas.fromJSONArray(jsonObject.getJSONArray("Prendas de vestir"));
		ListaDeVentas listaDeVentas = ListaDeVentas.fromJSONArray(jsonObject.getJSONArray("Ventas"), listaDeClientes, listaDeEmpleados, listaDePrendas);
	
		TiendaDeRopa tiendaDeRopa = new TiendaDeRopa(listaDeClientes, listaDeEmpleados, listaDePrendas, listaDeVentas);
		
		return tiendaDeRopa;
	}
	
	/**
	 * Devulve todos los clientes con su nombre, apellido, dni y tipo de cliente
	 * @return los datos de todos los clientes mencionados anteriormente en forma de String
	 */
	public String devolverClientesConSuNombreApellidoYDni() { 
		return clientes.devolverClientesConSuNombreApellidoYDni();
	}
	
	/**
	 * Metodo para actualizar la tienda de ropa a travez del archivo
	 */
	public void actualizarTiendaDeRopa() {
		clientes = archivoClientes.leerClientes();
		empleados = archivoEmpleados.leerEmpleados();
		prendasDeVestir = archivoPrendas.leerPrendas();
		ventas = archivoVentas.leerVentas();
	} 
	
	/**
	 * Lista las ventas con su id, cliente vendedor y fecha
	 * @return
	 */
	public String devolverVentasConIDClienteVendedorYFecha() {
		return ventas.listarVentasConIdVendedorClineteYFecha();
	}

	
	/**
	 * Devuelve la cantidad de ventas
	 * @return la cantidad de ventas totales
	 */
	public int devolverCantidadDeVentas() {
		return ventas.cantidadDeVentas();
	}
	
	/**
	 * Devuelve la cantidad de prendas vendidas a travez de un valor como entero
	 * @return
	 */
	public int cantidadDePrendasVendidas() {
		return ventas.cantidadDePrendasVendidas();
	}

	public void modificarCliente(String dniClienteAModificar, Cliente clienteModificado) {
		
		int i = 0;
		boolean fueModificado = false;
		
			while((i < clientes.cantidadDeClientes()) && (!fueModificado)) {
				if(clientes.buscarCliente(i).getDni().equals(dniClienteAModificar)) {
					clientes.bajaCliente(i);
					clientes.agregarCliente(clienteModificado);
					fueModificado = true;
				}
				i++;	
			}
		}
		
	}
	



