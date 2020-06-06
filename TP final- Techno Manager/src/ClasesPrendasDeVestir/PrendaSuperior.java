package ClasesPrendasDeVestir;

/**
 * Clase para prendas superiores de ropa
 * Es abstracta con la finalidad de que una prenda superior tiene que ser bien definida que tipo de prenda es
 * @author Techno Manager
 *
 */
public abstract class PrendaSuperior extends PrendaDeVestir{
	
	private boolean esMangaCorta;

	public PrendaSuperior() {
		super();
		
	}

	public PrendaSuperior(String marca, String modelo, String color, boolean esMangaCorta, String tipoDeMaterial) {
		super(marca, modelo, color, tipoDeMaterial);
		this.esMangaCorta = esMangaCorta;
	}

	public boolean isEsMangaCorta() {
		return esMangaCorta;
	}

	public void setEsMangaCorta(boolean esMangaCorta) {
		this.esMangaCorta = esMangaCorta;
	}
	
	public String toString() {
		return super.toString()+"\nEs manga corta: "+isEsMangaCorta();
	}
}
