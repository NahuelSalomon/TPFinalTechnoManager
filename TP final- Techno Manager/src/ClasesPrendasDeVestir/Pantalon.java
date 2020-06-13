package ClasesPrendasDeVestir;

/**
 * Clase para definir objetos del tipo remera Hija de clase abstracta
 * PrendaDeVestir y de PrendaInferior
 * 
 * @author Techno Manager
 *
 */
public class Pantalon extends PrendaDeVestir {

	private boolean esAlCuerpo;

	public boolean isEsAlCuerpo() {
		return esAlCuerpo;
	}

	public Pantalon() {
		super();
	}

	public Pantalon(String marca, String modelo, String color, String tipoDeMaterial, boolean esAlCuerpo) {
		super(marca, modelo, color, tipoDeMaterial);
		this.esAlCuerpo = esAlCuerpo;
	}

	@Override
	public String tipoDePrenda() {
		return "Pantalon";
	}

	public String toString() {
		return super.toString() + "\nEs al cuerpo: " + isEsAlCuerpo();
	}
}
