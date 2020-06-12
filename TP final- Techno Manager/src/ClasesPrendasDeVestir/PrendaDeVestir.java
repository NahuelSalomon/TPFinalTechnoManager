package ClasesPrendasDeVestir;

/**
 * Clase padre de cualquier prenda de vestir, es abstracta con la finalidad de que se tiene que definir bien de que tipo es la prenda
 * @author Techno Manager
 *
 */
public abstract class PrendaDeVestir {

	private String codigo;

	private String marca;
	private String modelo;
	private String color;
	private String tipoDeMaterial;
	private TallesYStock stockPrenda;
	
	public PrendaDeVestir() {
		stockPrenda = new TallesYStock();
	}

	public PrendaDeVestir(String marca, String modelo, String color, String tipoDeMaterial) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.tipoDeMaterial = tipoDeMaterial;
		this.stockPrenda = new TallesYStock();
	}
	
	
	public String getTipoDeMaterial() {
		return tipoDeMaterial;
	}

	public void setTipoDeMaterial(String tipoDeMaterial) {
		this.tipoDeMaterial = tipoDeMaterial;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Lista el stock disponible
	 * @return el stock en forma de String
	 */
	public String listarStock() {
		return stockPrenda.listarTallesYStock();
	}
	
	/**
	 * Agrega un talle al stock con una cantidad
	 * @param talle a agregar 
	 * @param cantidad agregada
	 * @return true si se agrega, false en caso contrario
	 */
	public boolean agregarCantidadATalle (String talle, Integer cantidad) { 
		return stockPrenda.agregarCantidadATalle(talle, cantidad);
	}
	
	/**
	 * Agrega un nuevo talle al stock con su respectiva cantidad
	 * @param talle a agregar
	 * @param cantidad del talle agregado
	 * @return true si se agrega, false en caso contrario.
	 */
	public boolean agregarNuevoTalleConCantidad(String talle, Integer cantidad) {
		return stockPrenda.agregarNuevoTalleConCantidad(talle, cantidad);
	}
	
	/**
	 * Quita un talle del stock
	 * @param talle a quitar
	 * @return true si se quita, false en caso contrario
	 */
	public boolean quitarUnTalle(String talle) { 
		return stockPrenda.quitarUnTalle(talle);
	}

	/**
	 * Quita una determinada cantidad a un talle del stock
	 * @param talle a quitar cantidad 
	 * @param cantidad quitada
	 * @return true si se quita, false en caso contrario
	 */
	public boolean quitarCantidadATalle(String talle, Integer cantidad) { 
		return stockPrenda.quitarCantidadATalle(talle, cantidad);
	}
	
	public String toString() {
		return "Marca: "+getMarca()+"\nModelos: "+getModelo()+"\nColor: "+getColor()+"\nTipo de material: "+getTipoDeMaterial();
	}
	
	/**
	 * Retorna el tipo de prenda
	 * @return tipo prenda en forma de string
	 */
	public abstract String tipoDePrenda();
}
