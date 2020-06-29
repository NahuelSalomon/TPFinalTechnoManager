package Listas;


import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import ClasesPrendasDeVestir.Buzo;
import ClasesPrendasDeVestir.Calzado;
import ClasesPrendasDeVestir.Maya;
import ClasesPrendasDeVestir.Pantalon;
import ClasesPrendasDeVestir.PrendaDeVestir;
import ClasesPrendasDeVestir.Remera;
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

	
	private static final long serialVersionUID = 1L;
	
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
		return prendas.listarElementos("CODIGO", "PRENDA");
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
		
		ArrayList<PrendaDeVestir> arrayDeprendas = prendas.devolverElementos();
		
		for(PrendaDeVestir prenda : arrayDeprendas) {
			jsonArray.put(prenda.toJSONObject());
		}
		
		return jsonArray;
	}

	public String devolverPrendasConSuCodigo() {
		StringBuilder builder = new StringBuilder();
		
		ArrayList<PrendaDeVestir> arrayDeprendas = prendas.devolverElementos();
		
		for(PrendaDeVestir p : arrayDeprendas) {
			builder.append(p.getCodigo()+" - "+p.getMarca()+"-"+p.getModelo()+"\n");
		}
		
		return builder.toString();
	}
	
	/**
	 * Metodo para importar una lista de prendas desde un array de json
	 * @param jsonArray a importar
	 * @return la lista de prendas
	 * @throws JSONException
	 */
	public static ListaDePrendas fromJSONArray(JSONArray jsonArray) throws JSONException {
		ListaDePrendas listaDePrendas = new ListaDePrendas();
		
		for(int i = 0 ; i < jsonArray.length() ; i++) {
			
			JSONObject jsonObjectPrenda = jsonArray.getJSONObject(i);
			
			if(jsonObjectPrenda.getString("Tipo de prenda").equals("Buzo")) {
				Buzo buzo = Buzo.fromJSONObject(jsonObjectPrenda);
				listaDePrendas.agregarPrenda(buzo.getCodigo(), buzo);
				
			}
			if(jsonObjectPrenda.getString("Tipo de prenda").equals("Remera")) {
				Remera remera = Remera.fromJSONObject(jsonObjectPrenda);
				listaDePrendas.agregarPrenda(remera.getCodigo(), remera);
				
			}
			if(jsonObjectPrenda.getString("Tipo de prenda").equals("Pantalon")) {
				Pantalon pantalon = Pantalon.fromJSONObject(jsonObjectPrenda);
				listaDePrendas.agregarPrenda(pantalon.getCodigo(), pantalon);
				
			}
			if(jsonObjectPrenda.getString("Tipo de prenda").equals("Calzado")) {
				Calzado calzado = Calzado.fromJSONObject(jsonObjectPrenda);
				listaDePrendas.agregarPrenda(calzado.getCodigo(), calzado);
				
			}
			if(jsonObjectPrenda.getString("Tipo de prenda").equals("Maya")) {
				Maya maya = Maya.fromJSONObject(jsonObjectPrenda);
				listaDePrendas.agregarPrenda(maya.getCodigo(), maya);
	
			}
		}
		
		return listaDePrendas;
	}
	
	
}
