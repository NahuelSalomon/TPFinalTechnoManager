package Interfaces;

import javax.naming.LimitExceededException;

import ClasesPersona.Empleado;
import Excepciones.ErrorDeBusquedaExcepcion;
import Excepciones.LimiteExedidoDeGerenteExcepcion;

/**
 * Esta intefaz se utiliza para que la lista de los empleados utilice los
 * métodos básicos.
 * 
 * @author Nicolas
 *
 */
public interface IFuncionesBasicasListaEmpleados {

	/**
	 * Agrega un empleado a la lista
	 * 
	 * @param legajo   del empleado a agregar
	 * @param empleado agregado
	 * @return true si se agrega correctamente, false en caso contrario
	 * @throws LimitExceededException 
	 * @throws LimiteExedidoDeGerenteExcepcion 
	 */
	boolean agregarEmpleado(String legajo, Empleado empleado) throws LimiteExedidoDeGerenteExcepcion;

	/**
	 * Da de baja un empleado de la lista.
	 * 
	 * @param legajo del empleado a dar de baja.
	 * @return true si lo da de baja, false en caso contrario
	 */
	boolean bajaEmpleado(String legajo);

	/**
	 * Modifica un empleado de la lista
	 * 
	 * @param legajo             del empleado a modificar
	 * @param empleadoModificado empleado ya modificado
	 * @return true si se modifica correctamente el empleado, false en caso
	 *         contrario.
	 */
	boolean modificarEmpleado(String legajo, Empleado empleadoModificado);

	/**
	 * Lista todos los empleado de la lista
	 * 
	 * @return la lista de empleados en forma de String
	 */
	String listarEmpleados();

	/**
	 * Busca un empleado en la lista
	 * 
	 * @param legajo del empleado buscado
	 * @return el emepleado buscado
	 * @throws ErrorDeBusquedaExcepcion 
	 */
	Empleado buscarEmpleado(String legajo) throws ErrorDeBusquedaExcepcion;
}
