package ClasesPersona;

import java.util.Date;

/**
 * Clase que extiende de cliente, este es un cliente mayorista.
 * 
 * @author Nahuel
 *
 */
public class ClienteMinorista extends Cliente {

	public ClienteMinorista() {
		super();
	}
	
	public ClienteMinorista(String nombre, String apellido) {
		super(nombre, apellido);
	}

	public ClienteMinorista(String nombre, String apellido, String dni, int genero, Date fechaNac, 
			String domicilio, String email) {
		super(nombre, apellido, dni, genero, fechaNac, domicilio, email);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public String tipoDeCliente() {
		return "Mayorista";
	}

//	public String getCuil() {
//		return cuil;
//	}
//
//	public void setCuil(String cuil) {
//		this.cuil = cuil;
//	}
//
//	public String getCondicionFrenteIVA() {
//		return condicionFrenteIVA;
//	}
//
//	public void setCondicionFrenteIVA(String condicionFrenteIVA) {
//		this.condicionFrenteIVA = condicionFrenteIVA;
//	}
//
//	/**
//	 * Este metodo comprueba si se inserta una condicion frente al IVA correcta
//	 * @param condicion a comprobar
//	 * @return condicion comprobadaa
//	 */
//	public String comprobarCondicionIVA(String condicion) {
//		String condicionComprobada = "Consumidor final";
//		
//		if(condicion.equalsIgnoreCase("Responsable inscripto") || condicion.equalsIgnoreCase("Exento de IVA") 
//				|| condicion.equalsIgnoreCase("Consumidor final") || condicion.equalsIgnoreCase("IVA al 10 1/2") ||
//				condicion.equalsIgnoreCase("Monotributista") || condicion.equalsIgnoreCase("No respónsable") || 
//				condicion.equalsIgnoreCase("Responsable Monotributo")) {
//			condicionComprobada = condicion;
//		}
//		return condicionComprobada;
//	}

}
