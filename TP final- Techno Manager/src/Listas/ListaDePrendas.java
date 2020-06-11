package Listas;


import ClasesPrendasDeVestir.PrendaDeVestir;

import ContenedorGenericas.ContenedorPrendasYEmpleados;
import Interfaces.IFuncionesBasicasListaPrendas;


/**
 * Esta clase se va a encargar de crear una coleccion con un tipo de dato "PrendaDeVestir"
 * @author Lucas Zelaya_
 *
 */
public class ListaDePrendas implements IFuncionesBasicasListaPrendas{
		
		ContenedorPrendasYEmpleados<String ,PrendaDeVestir> prendas;
		
		public ListaDePrendas() {
			prendas = new ContenedorPrendasYEmpleados<String, PrendaDeVestir>();
		}

		
		@Override
		public boolean agregarPrenda(String clave, PrendaDeVestir valor) {
			return prendas.agragarElemento(clave, valor);
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

}
