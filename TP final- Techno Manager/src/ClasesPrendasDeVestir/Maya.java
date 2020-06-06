package ClasesPrendasDeVestir;


/**
 * Clase para definir objetos del tipo remera
 * Hija de clase abstracta PrendaDeVestir y de PrendaInferior
 * @author Techno Manager
 *
 */
public class Maya extends PrendaInferior{

	private boolean esSecadoRapido;
	private boolean esPorArribaRodillas;

	public Maya() {
		super();
		
	}

	public Maya(String marca, String modelo, String color, String tipoDeMaterial, boolean esSecadoRapido, boolean esPorArribaRodillas) {
		super(marca, modelo, color, tipoDeMaterial);
		this.esSecadoRapido = esSecadoRapido;
		this.esPorArribaRodillas = esPorArribaRodillas;
	}


	public boolean isEsSecadoRapido() {
		return esSecadoRapido;
	}

	public boolean isEsPorArribaRodillas() {
		return esPorArribaRodillas;
	}

	@Override
	public String tipoDePrenda() {
		return "Maya";
	}
	
	public String toString() {
		return super.toString()+"\nEs de secado rapido: "+isEsSecadoRapido()+"\nEs por ensima de rodillas: "+isEsPorArribaRodillas();
	}
}
