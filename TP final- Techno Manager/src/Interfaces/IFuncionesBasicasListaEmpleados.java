package Interfaces;

import ClasesPersona.Empleado;

public interface IFuncionesBasicasListaEmpleados {
	
	boolean agregarEmpleado(String clave, Empleado valor);
	boolean bajaEmpleado(String clave);
	boolean modificarEmpleado(String clave, Empleado NuevoValor);
	String listarEmpleados(String nom_clave, String nom_valor);
	Empleado buscarEmpleado(String clave);
}
