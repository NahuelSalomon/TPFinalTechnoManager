package Interfaces;

import ClasesPrendasDeVestir.PrendaDeVestir;

/**
 * Esta intefaz se utiliza para que la lista de las prendas de vestir utilice los métodos básicos.
 * @author Nicolas
 *
 */
public interface IFuncionesBasicasListaPrendas {
	
	/**
	 * Agrega una prenda de vestri a la lista de prendas.
	 * @param codigo de la prenda 
	 * @param prendaDeVestir a agregar
	 * @return true si se agrega correctamente, false en caso contrario.
	 */
	boolean agregarPrenda(String codigo, PrendaDeVestir prendaDeVestir);
	
	/**
	 * Da de baja una prenda de vestir
	 * @param codigo de la prenda a dar de baja
	 * @return true si se da de baja correctamente, false en caso contrario.
	 */
	boolean bajaPrenda(String codigo);
	
	/**
	 * MOdifica una prenda de vestir
	 * @param codigo de la prenda a modificar 
	 * @param prendaModificada prenda ya modificada
	 * @return true si se modifico correctamente, false en caso contrario
	 */
	boolean modificarPrenda(String codigo, PrendaDeVestir prendaModificada);
	
	/**
	 * Lista las prendas de vestir 
	 * @return la lista de prendas en forma de String
	 */
	String listarPrendas();
	
	/**
	 * Busca una prenda de vestir en la lsita
	 * @param codigo de la prenda a buscar
	 * @return la PrendaDeVestir
	 */
	PrendaDeVestir buscarPrenda(String codigo);
}
