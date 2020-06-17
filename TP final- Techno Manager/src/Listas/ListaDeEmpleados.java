package Listas;




import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;
import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import ClasesPersona.Cliente;

import ClasesPersona.Empleado;
import ContenedorGenericas.ContenedorPrendasYEmpleados;
import Interfaces.IFuncionesBasicasListaEmpleados;

/**
 * Lista la cual contiene un contenedor de la logica del manejo de los empleados
 * 
 * @author Nahuel
 *
 */
public class ListaDeEmpleados implements IFuncionesBasicasListaEmpleados,Serializable {

	private ContenedorPrendasYEmpleados<String, Empleado> empleados;

	public ListaDeEmpleados() {
		empleados = new ContenedorPrendasYEmpleados<String, Empleado>();
	}

	public ListaDeEmpleados(ListaDeEmpleados listaDeEmpleados) { 
		empleados = new ContenedorPrendasYEmpleados<String, Empleado>();
		this.agragarListaDeClientes(listaDeEmpleados.devolverListaDeEmpleados());
	}
	
	
	@Override
	public boolean agregarEmpleado(String clave, Empleado valor) {
		return empleados.agregarElemento(clave, valor);
	}

	@Override
	public boolean bajaEmpleado(String clave) {
		return empleados.bajaElemento(clave);
	}

	@Override
	public boolean modificarEmpleado(String clave, Empleado nuevoValor) {
		return empleados.modificarElemento(clave, nuevoValor);
	}

	@Override
	public String listarEmpleados() {
		return empleados.listarElementos("Legajo", "Empleado");
	}

	@Override
	public Empleado buscarEmpleado(String legajo) {
		return empleados.buscarElemento(legajo);
	}

	/**
	 * se encargar de validar los datos del usuario que ingreso con los cargados de el inicialmente
	 * 
	 * @param legajo recibe el legajo que el usuario ingreso
	 * @param contrase�a recibe la contrase�a ingresada por el usuario
	 * @param tipoDeEmpleado recibe el tipo de emleado que ingreso el usuario
	 * @return true si los datos fueron ingresados bien, false en caso contrario
	 */
	public boolean verificarEmpleado(String legajo, String contrase�a, String tipoDeEmpleado)
	{
		boolean existe = false;
		Empleado empleado = null;
		if(empleados.existeClave(legajo))
		{
			if(contrase�a.equals(buscarEmpleado(legajo).getContrase�a()))
			{
				empleado = buscarEmpleado(legajo);
				String tipo = empleado.tipoEmpleado();
				String tipo2 = tipoDeEmpleado;
				if(tipo.equalsIgnoreCase(tipo2))
				{
					existe = true;
					
				}
				
			}
		}
		return existe;
	}
	
	
	
	/**
	 * Verifica si existe un empleado
	 * 
	 * @param empleado a comprobar si existe
	 * @return true si se existe, false no existe
	 */
	public boolean existeEmpleado(Empleado empleado) {
		return empleados.existeClave(empleado.getLegajo());
	}

	
	/**
	 * Verifica si existe un empleado
	 * 
	 * @param legajo del empleado a verificar
	 * @return true si existe, false si no existe
	 */
	public boolean existeEmpleado(String legajo) {
		return empleados.existeClave(legajo);
	}

	
	/**
	 * Agrega varios clientes a la lista de clientes 
	 * @param listaDeClientes en forma de ArrayList
	 */
	public void agragarListaDeClientes(ArrayList<Empleado> listaDeEmpleados) {
		
		for(Empleado empleado : listaDeEmpleados) {
			this.empleados.agregarElemento(empleado.getLegajo(),empleado);
		}
	}
	
	/**
	 * Metodo para devolver toods los clientes
	 * @return los clientes en un ArrayList
	 */
	public ArrayList<Empleado> devolverListaDeEmpleados() {
		return empleados.devolverElementos();
	}
	
	/**
	 * Covierte la lista de empleados a un arreglo de JSON
	 * @return el JSONArray con los empleados 
	 * @throws JSONException
	 */
	public JSONArray toJsonArray() throws JSONException {
		ArrayList<Empleado> todosLosEmpleados = empleados.devolverElementos();
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0 ; i < todosLosEmpleados.size() ; i++ ) {
			jsonArray.put(todosLosEmpleados.get(i).toJSONObject());
		}
		
		return jsonArray;
	}
	
	
}
