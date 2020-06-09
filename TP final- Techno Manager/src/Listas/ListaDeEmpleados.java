package Listas;

import ClasesPersona.Empleado;
import ContenedorGenericas.ContenedorPrendasYEmpleados;
import Interfaces.IFuncionesListasPrendasYEmpleados;

public class ListaDeEmpleados implements IFuncionesListasPrendasYEmpleados<String, Empleado> {

	ContenedorPrendasYEmpleados<String, Empleado> empleados;
	
	
	public ListaDeEmpleados(){
		empleados = new ContenedorPrendasYEmpleados<String, Empleado>();
	}
	
	
	@Override
	public boolean agregarElemento(String clave, Empleado valor) {
		return empleados.agragarElemento(clave, valor);
	}

	@Override
	public boolean bajaElemento(String clave) {
		return empleados.bajaElemento(clave);
	}

	@Override
	public boolean modificarElemento(String clave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String listarElementos(String nom_clave, Empleado nom_valor) {
		return "";
	}

	@Override
	public Empleado buscarElemento(String clave) {
		return null;
	}
	
	
}
