package Listas;


import ClasesPrendasDeVestir.PrendaDeVestir;

import ContenedorGenericas.ContenedorPrendasYEmpleados;

import Interfaces.IFuncionesListasPrendasYEmpleados;

/**
 * Esta clase se va a encargar de crear una coleccion con un tipo de dato "PrendaDeVestir"
 * @author Lucas Zelaya_
 *
 */
public class ListaDePrendas implements IFuncionesListasPrendasYEmpleados<String ,PrendaDeVestir>{
		
		ContenedorPrendasYEmpleados<String ,PrendaDeVestir> prendas;
		
		public ListaDePrendas() {
			prendas = new ContenedorPrendasYEmpleados<String, PrendaDeVestir>();
		}

		@Override
		public boolean agregarElemento(String clave, PrendaDeVestir valor) {
		
			return prendas.agragarElemento(clave, valor);
		}

		@Override
		public boolean bajaElemento(String clave) {
			
			return prendas.bajaElemento(clave);
		}


		@Override
		public String listarElementos(String nom_clave, PrendaDeVestir nom_valor) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public PrendaDeVestir buscarElemento(String clave) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean modificarElemento(String clave) {
			// TODO Auto-generated method stub
			return false;
		}

	

}
