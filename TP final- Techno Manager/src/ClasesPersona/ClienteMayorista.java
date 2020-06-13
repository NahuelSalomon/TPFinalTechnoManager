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
	private String condicionFrenteIVA;

	public ClienteMayorista() {
		super();
	}

	public ClienteMayorista(String nombre, String apellido, String dni, String genero, Date fechaNac, String domicilio,
			String email) {
		super(nombre, apellido, dni, genero, fechaNac, domicilio, email);
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getCondicionFrenteIVA() {
		return condicionFrenteIVA;
	}

	public void setCondicionFrenteIVA(String condicionFrenteIVA) {
		this.condicionFrenteIVA = condicionFrenteIVA;
	}

	/**
	 * Este metodo comprueba si se inserta una condicion frente al IVA correcta
	 * 
	 * @param condicion a comprobar
	 * @return condicion comprobadaa
	 */
	public String comprobarCondicionIVA(String condicion) {
		String condicionComprobada = "Consumidor final";

		if (condicion.equalsIgnoreCase("Responsable inscripto") || condicion.equalsIgnoreCase("Exento de IVA")
				|| condicion.equalsIgnoreCase("Consumidor final") || condicion.equalsIgnoreCase("IVA al 10 1/2")
				|| condicion.equalsIgnoreCase("Monotributista") || condicion.equalsIgnoreCase("No respónsable")
				|| condicion.equalsIgnoreCase("Responsable Monotributo")) {
			condicionComprobada = condicion;
		}

		return condicionComprobada;
	}

	@Override
	public String toString() {
		return super.toString() + "\nCUIL: " + getCuil() + "\nCondicion frente al IVA: " + getCondicionFrenteIVA();
	}

	@Override
	public String tipoDeCliente() {
		return "Minorista";
	}

}
