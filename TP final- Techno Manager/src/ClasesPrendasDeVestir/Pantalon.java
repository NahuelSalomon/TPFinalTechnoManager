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

	public Pantalon() {
		super();
		this.esAlCuerpo = (Boolean) null;
	}

	public Pantalon(int marca, String modelo, String color, int tipoDeMaterial, boolean esAlCuerpo) {
		super(marca, modelo, color, tipoDeMaterial);
		this.esAlCuerpo = esAlCuerpo;
	}

	public boolean isEsAlCuerpo() {
		return esAlCuerpo;
	}
	
	public void setEsAlCuerpo(boolean esAlCuerpo) {
		this.esAlCuerpo = esAlCuerpo;
	}
	
	public String getEsAlCuerpo() {
		String rta = "";
		if(esAlCuerpo) rta = "Es al cuerpo";
		if(!esAlCuerpo) rta = "No es al cuerpo";
		else rta = "No definido";
		return rta;
	}

	@Override
	public String tipoDePrenda() {
		return "Pantalon";
	}

	public String toString() {
		return super.toString() + "\n" + getEsAlCuerpo();
	}
}
