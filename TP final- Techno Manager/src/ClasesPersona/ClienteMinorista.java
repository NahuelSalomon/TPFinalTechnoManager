package ClasesPersona;

import java.util.Date;

/**
 * Clase que extiende de cliente, este es un cliente mayorista.
 * @author Nahuel
 *
 */
public class ClienteMinorista extends Cliente{

	
	
	public ClienteMinorista() {
		super();
	}

	public ClienteMinorista(String nombre, String apellido, String dni, String genero, Date fechaNac, String domicilio,
			String email) {
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

	
}
