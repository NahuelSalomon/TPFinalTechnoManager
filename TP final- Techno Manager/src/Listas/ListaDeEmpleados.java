package Listas;

import ClasesPersona.Empleado;
import ContenedorGenericas.ContenedorPrendasYEmpleados;
import Interfaces.IFuncionesBasicasListaEmpleados;


public class ListaDeEmpleados implements IFuncionesBasicasListaEmpleados {

	ContenedorPrendasYEmpleados<String, Empleado> empleados;
	
	
	public ListaDeEmpleados(){
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
	public Empleado buscarEmpleado(String clave) {
		return empleados.buscarElemento(clave);
	}
	
	
}
