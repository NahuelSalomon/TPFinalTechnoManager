package ClasesPersona;

import java.io.Serializable;
import java.util.Date;

public class ClienteMayorista extends Cliente implements Serializable{

	
	
	public ClienteMayorista() {
		super();
	}

	public ClienteMayorista(String nombre, String apellido, String dni, String genero, Date fechaNac, String domicilio,
			String email) {
		super(nombre, apellido, dni, genero, fechaNac, domicilio, email);
	}

	@Override
	public String tipoDeCliente() {
		return "Mayorista";
	}

	
}
