package ClasesPrendasDeVestir;

/**
 * Clase para definir objetos del tipo remera
 * Hija de clase abstracta PrendaDeVestir y de PrendaSuperior
 * @author Techno Manager
 *
 */
public class Remera extends PrendaSuperior{

	private String tipoEstampado;
	
	public Remera() {
		super();
	}
	
	public Remera(String marca, String modelo, String color, boolean esMangaCorta, String tipoDeMaterial, String tipoEstampado) {
		super(marca, modelo, color, esMangaCorta, tipoDeMaterial);
		this.tipoEstampado = tipoEstampado;
	}

	public String getTipoEstampado() {
		return tipoEstampado;
	}

	@Override
	public String tipoDePrenda() {
		return "Remera";
	}
	
	public String toString() {
		return super.toString()+"\nTipo de estampado: "+getTipoEstampado();
	}
}
