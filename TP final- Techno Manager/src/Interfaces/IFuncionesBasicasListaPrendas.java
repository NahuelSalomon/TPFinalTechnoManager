package Interfaces;

import ClasesPrendasDeVestir.PrendaDeVestir;

public interface IFuncionesBasicasListaPrendas {
	
	boolean agregarPrenda(String clave, PrendaDeVestir valor);
	boolean bajaPrenda(String clave);
	boolean modificarPrenda(String clave, PrendaDeVestir nuevoValor);
	String listarPrenda(String nom_clave, String nom_valor);
	PrendaDeVestir buscarPrenda(String clave);
}
