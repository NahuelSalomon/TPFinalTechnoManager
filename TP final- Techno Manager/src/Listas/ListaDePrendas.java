package Listas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import ClasesPersona.Empleado;
import ClasesPrendasDeVestir.PrendaDeVestir;

import ContenedorGenericas.ContenedorPrendasYEmpleados;
import Interfaces.IFuncionesBasicasListaPrendas;

/**
 * Esta clase se va a encargar de crear una coleccion con un tipo de dato
 * "PrendaDeVestir"
 * 
 * @author Lucas Zelaya_
 *
 */
public class ListaDePrendas implements IFuncionesBasicasListaPrendas, Serializable {

	private ContenedorPrendasYEmpleados<String, PrendaDeVestir> prendas;

	public ListaDePrendas() {
		prendas = new ContenedorPrendasYEmpleados<String, PrendaDeVestir>();
	}

	public ListaDePrendas(ListaDePrendas listaDePrendas) {
		prendas = new ContenedorPrendasYEmpleados<String, PrendaDeVestir>();
		this.agragarListaDePrendas(listaDePrendas.devolverListaDePrendas());
	}
	
	
	@Override
	public boolean agregarPrenda(String clave, PrendaDeVestir valor) {
		return prendas.agregarElemento(clave, valor);
	}

	@Override
	public boolean bajaPrenda(String clave) {
		return prendas.bajaElemento(clave);
	}

	@Override
	public boolean modificarPrenda(String clave, PrendaDeVestir NuevoValor) {
		return prendas.modificarElemento(clave, NuevoValor);
	}

	@Override
	public String listarPrendas() {
		return prendas.listarElementos("Codigo", "Prenda");
	}

	@Override
	public PrendaDeVestir buscarPrenda(String clave) {
		return prendas.buscarElemento(clave);
	}

	/**
	 * Metodo para comprobar si existe un prenda de vestir
	 * @param prendaDeVestir a verificar
	 * @return true si existe, false en caso contrario
	 */
	public boolean existePrendaDeVestir(PrendaDeVestir prendaDeVestir) {
		return prendas.existeClave(prendaDeVestir.getCodigo());
	}
	
	
	/**
	 * Devulve todas las prendas en forma de ArrayList
	 * @return las prendas en forma de ArrayList
	 */
	public ArrayList<PrendaDeVestir> devolverListaDePrendas() {
		return prendas.devolverElementos();
	
	}
	
	
	/**
	 * Agrega un arreglo de prendas a la lista de prendas
	 * @param listaDePrendas a agregar
	 */
	public void agragarListaDePrendas(ArrayList<PrendaDeVestir> listaDePrendas) {
		
		for(PrendaDeVestir prendaDeVestir : listaDePrendas) {
			this.prendas.agregarElemento(prendaDeVestir.getCodigo(),prendaDeVestir);
		}
	} 
	
	
	/**
	 * Verifica si existe una prenda de vestir
	 * @param codigo de la prenda a verificar
	 * @return true si la prenda existe, false en caso contrario.
	 */
	public boolean existePrendaDeVesitr(String codigo) {
		return prendas.existeClave(codigo);
	}

	/**
	 * Devuelve la lista de prendas en un arreglo de json
	 * @return las prendas en un JSONArray
	 * @throws JSONException 
	 */
	public JSONArray toJsonArray() throws JSONException {
		JSONArray jsonArray = new JSONArray();
		
		return jsonArray;
	}

}
