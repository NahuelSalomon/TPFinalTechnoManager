package Listas;



import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import ClasesPersona.Empleado;
import ContenedorGenericas.ContenedorPrendasYEmpleados;
import Interfaces.IFuncionesBasicasListaEmpleados;

/**
 * Lista la cual contiene un contenedor de la logica del manejo de los empleados
 * 
 * @author Nahuel
 *
 */
public class ListaDeEmpleados implements IFuncionesBasicasListaEmpleados {

	ContenedorPrendasYEmpleados<String, Empleado> empleados;

	public ListaDeEmpleados() {
		empleados = new ContenedorPrendasYEmpleados<String, Empleado>();
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
	 * @param contraseña recibe la contraseña ingresada por el usuario
	 * @param tipoDeEmpleado recibe el tipo de emleado que ingreso el usuario
	 * @return true si los datos fueron ingresados bien, false en caso contrario
	 */
	public boolean verificarEmpleado(String legajo, String contraseña, String tipoDeEmpleado)
	{
		boolean existe = false;
		Empleado empleado = null;
		if(empleados.existeClave(legajo))
		{
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

}
