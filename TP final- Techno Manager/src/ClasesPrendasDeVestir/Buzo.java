package ClasesPrendasDeVestir;

/**
 * Clase para definir objetos del tipo remera
 * Hija de clase abstracta PrendaDeVestir y de PrendaSuperior
 * @author Techno Manager
 *
 */
public class Buzo extends PrendaSuperior{

	private boolean esTipoCanguro;

	public Buzo() {
		super();
	}


	public Buzo(String marca, String modelo, String color, boolean esMangaCorta, String tipoDeMaterial) {
		super(marca, modelo, color, esMangaCorta, tipoDeMaterial);
	}
	
	public boolean esTipoCanguro() {
		return esTipoCanguro;
	}
	
	@Override
	public String tipoDePrenda() {
		return "Buzo";
	}
	
	public String toString() {
		return super.toString()+"\nEs tipo canguro: "+esTipoCanguro();
	}
}
