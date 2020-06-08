package ListasGenericas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class ContenedorPrendasYEmpleados <K,V>{
	
	private HashMap<K,V> contenedor;
	
	public ContenedorPrendasYEmpleados() {
		super();
		contenedor = new HashMap<K,V>();
	}
	
	public boolean agragarElemento(K clave, V valor){
		boolean agregado = false;
		if(!existeClave(clave)){
			contenedor.put(clave, valor);
			agregado = true;
		}
		return agregado;
	}
	
	public boolean bajaElemento(K clave) {
		boolean eliminado = false;
		if(existeClave(clave)){
			contenedor.remove(clave);
			eliminado = true;
		}
		return eliminado;
	}
	
	public boolean modificarElemento(K clave, V valor) {
		boolean modificado = false;
		if(existeClave(clave)){
			contenedor.put(clave, valor);
			modificado = true;
		}
		return modificado;
	}
	
	public String listarElementos(String nom_claves, String nom_valores) {
		StringBuilder builder = new StringBuilder();
		
		Set<Entry<K, V>> set = contenedor.entrySet();
		Iterator<Entry<K, V>> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Entry<K, V> entry = iterator.next();
			builder.append(nom_claves+": "+entry.getKey()+" "+nom_valores+": "+entry.getValue());
		}
		
		return builder.toString();
	}
	
	public boolean existeClave(K clave) {
		return contenedor.containsKey(clave);
	}
}
