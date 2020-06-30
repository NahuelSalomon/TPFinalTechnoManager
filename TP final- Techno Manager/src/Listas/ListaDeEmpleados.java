package Listas;





import java.io.Serializable;
import java.util.ArrayList;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import ClasesPersona.Empleado;
import ClasesPersona.Gerente;
import ClasesPersona.Vendedor;
import ContenedorGenericas.ContenedorPrendasYEmpleados;
import Excepciones.ErrorDeBusquedaExcepcion;
import Excepciones.LimiteExedidoDeGerenteExcepcion;
import Interfaces.IFuncionesBasicasListaEmpleados;

/**
 * Lista la cual contiene un contenedor de la logica del manejo de los empleados
 * 
 * @author Nahuel
 *
 */
public class ListaDeEmpleados implements IFuncionesBasicasListaEmpleados,Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private ContenedorPrendasYEmpleados<String, Empleado> empleados;

	public ListaDeEmpleados() {
		empleados = new ContenedorPrendasYEmpleados<String, Empleado>();
	}

	public ListaDeEmpleados(ListaDeEmpleados listaDeEmpleados) { 
		empleados = new ContenedorPrendasYEmpleados<String, Empleado>();
		this.agragarListaDeClientes(listaDeEmpleados.devolverListaDeEmpleados());
	}
	
	
	@Override
	public boolean agregarEmpleado(String clave, Empleado valor) throws LimiteExedidoDeGerenteExcepcion {
		boolean seAgrego = false;
		
		if(valor instanceof Gerente) {
			if(!existeGerente()) {
				empleados.agregarElemento(clave, valor);
				seAgrego = true;
			}
			else {
				throw new LimiteExedidoDeGerenteExcepcion("Ya existe un gerente");
			}
		}
		else {
			empleados.agregarElemento(clave, valor);
			seAgrego = true;
		}
		
		return seAgrego;
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
		return empleados.listarElementos("LEGAJO", "EMPLEADO");
	}

	@Override
	public Empleado buscarEmpleado(String legajo) throws ErrorDeBusquedaExcepcion {
	
		Empleado empleado = null;
		
		if(empleados.existeClave(legajo)) {
			empleado = empleados.buscarElemento(legajo);
		}
		else {
			throw new ErrorDeBusquedaExcepcion("Empleado no encontrado");
		}
		
		return empleado;
	}

	/**
	 * Metodo para devolver empleados con su nombre y apellido  
	 * @return
	 */
	public String devolverNombreYApellidoEmpleadosConLegajo() {
		StringBuilder builder = new StringBuilder();
		
		ArrayList<Empleado> arrayEmpleados = empleados.devolverElementos();
		
		for(Empleado e : arrayEmpleados) {
			builder.append(e.getLegajo()+" - "+e.getNombre()+" "+e.getApellido()+"\n");
		}
	
		return builder.toString();
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
		boolean existe = false;
		Empleado empleado = null;
			if(contraseña.equals(buscarEmpleado(legajo).getContraseña()))
			{
				empleado = buscarEmpleado(legajo);
				String tipo = empleado.tipoEmpleado();
				String tipo2 = tipoDeEmpleado;
				if(tipo.equalsIgnoreCase(tipo2))
				{	
					existe = true;	
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
	
	public boolean existeGerente() {
		boolean existe = false;
		
		ArrayList<Empleado> arrayEmpleados = devolverListaDeEmpleados();
		
		for(Empleado e : arrayEmpleados) {
			if(e instanceof Gerente) {
				existe = true;
				break;
			}
		}
		
		return existe;
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
	
	
	/**
	 * Metodo para importar una lista de empleados desde un array de json
	 * @param jsonArray a importar
	 * @return la lista de empleados
	 * @throws JSONException
	 */
	public static ListaDeEmpleados fromJSONArray(JSONArray jsonArray) throws JSONException {
		
		ListaDeEmpleados listaDeEmpleados = new ListaDeEmpleados();
		
		for(int i = 0 ; i < jsonArray.length() ; i ++) {
			JSONObject jsonObjectEmpleado = jsonArray.getJSONObject(i);
			
			if(jsonObjectEmpleado.getString("Tipo de empleado").equals("Vendedor")) {
				Vendedor vendedor = (Vendedor) Vendedor.JSONObjectToVendedor(jsonObjectEmpleado);
				try {
				listaDeEmpleados.agregarEmpleado(vendedor.getLegajo(), vendedor);
				}
				catch(LimiteExedidoDeGerenteExcepcion e) {
					e.printStackTrace();
				}
			}
			if(jsonObjectEmpleado.getString("Tipo de empleado").equals("Gerente")) {
				Gerente gerente = (Gerente) Gerente.JSONObjectToGerente(jsonObjectEmpleado);
				try {
				listaDeEmpleados.agregarEmpleado(gerente.getLegajo(), gerente);
				}
				catch(LimiteExedidoDeGerenteExcepcion e) {
					e.printStackTrace();
				}
			}
		}
		
		return listaDeEmpleados;
	} 
	
}
