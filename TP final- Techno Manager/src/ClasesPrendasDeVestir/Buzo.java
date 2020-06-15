package ClasesPrendasDeVestir;

/**
 * Clase para definir objetos del tipo remera Hija de clase abstracta
 * PrendaDeVestir y de PrendaSuperior
 * 
 * @author Techno Manager
 *
 */
public class Buzo extends PrendaSuperior {

	private boolean esTipoCanguro;

	public Buzo() {
		super();
		this.esTipoCanguro = (Boolean) null;
	}

	public Buzo(int marca, String modelo, String color, int tipoDeMaterial, boolean esMangaCorta, boolean esTipoCanguro) {
		super(marca, modelo, color, tipoDeMaterial, esMangaCorta);
		this.esTipoCanguro = esTipoCanguro;
	}

	public boolean esTipoCanguro() {
		return esTipoCanguro;
	}

	public String getEsTipoCanguro() {
		String rta = "";
		if(esTipoCanguro) rta = "Tiene Canguro";
		if(!esTipoCanguro) rta = "No tiene Canguro";
		else rta = "No definido";
		return rta;
	}

	public void setEsTipoCanguro(boolean esTipoCanguro) {
		this.esTipoCanguro = esTipoCanguro;
	}

	@Override
	public String tipoDePrenda() {
		return "Buzo";
	}

	public String toString() {
		return super.toString() + "\nEs tipo canguro: " + esTipoCanguro();
	}
}
