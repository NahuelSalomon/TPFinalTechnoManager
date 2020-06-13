package ClasesPrendasDeVestir;

/**
 * Clase para prendas superiores de ropa Es abstracta con la finalidad de que
 * una prenda superior tiene que ser bien definida que tipo de prenda es
 * 
 * @author Techno Manager
 *
 */
public abstract class PrendaSuperior extends PrendaDeVestir {

	private boolean esMangaCorta;

	public PrendaSuperior() {
		super();
		this.esMangaCorta = (Boolean) null;
	}

	public PrendaSuperior(int marca, String modelo, String color, int tipoDeMaterial, boolean esMangaCorta) {
		super(marca, modelo, color, tipoDeMaterial);
		this.esMangaCorta = esMangaCorta;
	}

	public String getEsMangaCorta() {
		String rta = "";
		if(esMangaCorta) rta = "Es manga corta";
		if(!esMangaCorta) rta = "No es manga corta";
		else rta = "No definido";
		return rta;
	}

	public void setEsMangaCorta(boolean esMangaCorta) {
		this.esMangaCorta = esMangaCorta;
	}

	public String toString() {
		return super.toString() + "\n" + getEsMangaCorta();
	}
}
