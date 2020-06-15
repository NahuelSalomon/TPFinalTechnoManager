package OtrasListas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import ClasesPrendasDeVestir.PrendaDeVestir;

public class OtraListaPrendas extends PrendaDeVestir implements Serializable{
	
	private HashMap<String, PrendaDeVestir> contenedor;

	/**
	 * Constructor del contenedor de Personas y Empleados
	 */
	public OtraListaPrendas() {
		super();
		contenedor = new HashMap<String, PrendaDeVestir>();
	}

	/**
	 * Agregar Elementos al HashMap
	 * 
	 * @param clave elemento que reprecenta la clave
	 * @param valor elemento que reprecenta el contenido del elemento
	 * @return boolean Retorna True si se agrego el elemento, False en caso
	 *         contrario
	 */
	public boolean agregarElemento(String clave, PrendaDeVestir valor) {
		boolean agregado = false;
		if (!existeClave(clave)) {
			contenedor.put(clave, valor);
			agregado = true;
		}
		return agregado;
	}

	/**
	 * Elimina un elemento del HashMap
	 * 
	 * @param clave elemento que distingue un elemento de otro
	 * @return boolean Retorna True si se eleimina el elemento, False en caso
	 *         contrario
	 */
	public boolean bajaElemento(String clave) {
		boolean eliminado = false;
		if (existeClave(clave)) {
			contenedor.remove(clave);
			eliminado = true;
		}
		return eliminado;
	}

	/**
	 * Modifica un elemento por el indicador "clave"
	 * 
	 * @param clave valor que distingue el elemento en el HashMap
	 * @param valor del elemento que sobre escribirá
	 * @return boolean Retorna True si se modifico el elemento, False en caso
	 *         contrario
	 */
	public boolean modificarElemento(String clave, PrendaDeVestir valor) {
		boolean modificado = false;
		if (existeClave(clave)) {
			contenedor.put(clave, valor);
			modificado = true;
		}
		return modificado;
	}

	/**
	 * Lista los elementos del HashMap
	 * 
	 * @param nom_claves  nombre que tomaran las claves
	 * @param nom_valores nombre que tomaran los valores
	 * @return String cuerpo de texto del HashMap
	 */
	public String listarElementos(String nom_claves, String nom_valores) {
		StringBuilder builder = new StringBuilder();

		Set<Entry<String, PrendaDeVestir>> set = contenedor.entrySet();
		Iterator<Entry<String, PrendaDeVestir>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Entry<String, PrendaDeVestir> entry = iterator.next();
			builder.append(nom_claves + ": " + entry.getKey() + " " + nom_valores + ": " + entry.getValue());
		}

		return builder.toString();
	}

	/**
	 * Determina si existe la clave parametrada
	 * 
	 * @param clave valor a verificar
	 * @return boolean Retorna True si existe el elemento, False en caso contrario
	 */
	public boolean existeClave(String clave) {
		return contenedor.containsKey(clave);
	}

	/**
	 * Este metodo busca un elemento por la clave y lo retorna S
	 * 
	 * @param clave
	 * @return el elemento si existe y sino retorna null.
	 */
	public PrendaDeVestir buscarElemento(String clave) {

		if (existeClave(clave)) {
			return contenedor.get(clave);
		} else {
			return null;
		}

	}

	@Override
	public String tipoDePrenda() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void guardar() throws FileNotFoundException, IOException {
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("filePrendas"));
		output.writeObject(this.contenedor);
		output.close();
	}

	public void abrir() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("filePrendas"));
		contenedor = (HashMap<String, PrendaDeVestir>) input.readObject();
		input.close();
	}

}
