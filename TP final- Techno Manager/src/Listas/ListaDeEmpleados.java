package Listas;

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
		return empleados.agragarElemento(clave, valor);
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
