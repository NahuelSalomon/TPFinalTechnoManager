package ClasesPersona;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que extiende de cliente, este es un cliente minorista.
 * 
 * @author Nahuel
 *
 */
public class ClienteMayorista extends Cliente implements Serializable {

	private String cuil;
	private int condicionFrenteIVA;

	public ClienteMayorista() {
		super();
		this.cuil = null;
		this.condicionFrenteIVA = (Integer)null; 
	}
	
	public ClienteMayorista(String nombre, String apellido, String cuil, int condicionFrenteIVA) {
		super(nombre, apellido);
		this.cuil = cuil;
		this.condicionFrenteIVA = condicionFrenteIVA;
	}

	public ClienteMayorista(String nombre, String apellido, String dni, int genero, Date fechaNac,
			String domicilio, String email, String cuil, int condicionFrenteIVA) {
		super(nombre, apellido, dni, genero, fechaNac, domicilio, email);
		this.cuil = cuil;
		this.condicionFrenteIVA = condicionFrenteIVA;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getCondicionFrenteIVA() {
		String rta = "";
		switch(this.condicionFrenteIVA) {
		case(1):
			rta = "Responsable Inscripto";
			break;
		case(2):
			rta = "Monotributista";
			break;
		case(3):
			rta = "Exento";
			break;
		case(4):
			rta = "No Responsable";
			break;
		case(5):
			rta = "Consumidor Final";
			break;
		default:
			rta = "No definido";
			break;
		}
		return rta;
	}

	public void setCondicionFrenteIVA(int condicionFrenteIVA) {
		this.condicionFrenteIVA = condicionFrenteIVA;
	}

//	/**
//	 * Este metodo comprueba si se inserta una condicion frente al IVA correcta
//	 * 
//	 * @param condicion a comprobar
//	 * @return condicion comprobadaa
//	 */
//	public String comprobarCondicionIVA(String condicion) {
//		String condicionComprobada = "Consumidor final";
//
//		if (condicion.equalsIgnoreCase("Responsable inscripto") || condicion.equalsIgnoreCase("Exento de IVA")
//				|| condicion.equalsIgnoreCase("Consumidor final") || condicion.equalsIgnoreCase("IVA al 10 1/2")
//				|| condicion.equalsIgnoreCase("Monotributista") || condicion.equalsIgnoreCase("No respónsable")
//				|| condicion.equalsIgnoreCase("Responsable Monotributo")) {
//			condicionComprobada = condicion;
//		}
//
//		return condicionComprobada;
//	}

	@Override
	public String toString() {
		return super.toString() + "\nCUIL: " + getCuil() + "\nCondicion frente al IVA: " + getCondicionFrenteIVA();
	}

	@Override
	public String tipoDeCliente() {
		return "Minorista";
	}

}
