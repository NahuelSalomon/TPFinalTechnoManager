package ClasesPrendasDeVestir;

/**
 * Clase para prendas inferiores de ropa
 * Es abstracta con la finalidad de que una prenda inferior tiene que ser bien definida que tipo de prenda es
 * @author Techno Manager
 *
 */
public abstract class PrendaInferior extends PrendaDeVestir{

	public PrendaInferior() {
		super();
	}

	public PrendaInferior(String marca, String modelo, String color, String tipoDeMaterial) {
		super(marca, modelo, color, tipoDeMaterial);
	}

	public String toString() {
		return super.toString();
	}	
}
