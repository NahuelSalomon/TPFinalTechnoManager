package ClasesPrendasDeVestir;

/**
 * Clase para definir objetos del tipo remera Hija de clase abstracta
 * PrendaDeVestir
 * 
 * @author Techno Manager
 *
 */
public class Calzado extends PrendaDeVestir {

	private String tipoDeSuela;

	public Calzado() {
		super();
	}

	public Calzado(String marca, String modelo, String color, String tipoDeMaterial, String tipoDeSuela) {
		super(marca, modelo, color, tipoDeMaterial);
		this.tipoDeSuela = tipoDeSuela;
	}

	public String getTipoDeSuela() {
		return tipoDeSuela;
	}

	@Override
	public String tipoDePrenda() {
		return "Calzado";
	}

	public String toString() {
		return super.toString() + "\nTipo de suela: " + getTipoDeSuela();
	}

}
