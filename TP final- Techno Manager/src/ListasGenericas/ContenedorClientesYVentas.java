package ListasGenericas;

import java.util.ArrayList;

public class ContenedorClientesYVentas <E>{
	
	private ArrayList<E> contenedor;
	
	public ContenedorClientesYVentas() {
		super();
		contenedor = new ArrayList<E>();
	}
	
	public boolean agragarElemento(E elemento){
		return contenedor.add(elemento);
	}
	
	public boolean bajaElemento(E elemento) {
		return contenedor.remove(elemento);
	}
	
	public E bajaElemento(int index) {
		return contenedor.remove(index);
	}
	
	public boolean modificarElemento(int index, E modificacion) {
		boolean modificado = false;
		if(index < 0 && index < cantidadElementos()){
			contenedor.add(index, modificacion);;
			modificado = true;
		}
		return modificado;
	}
	
	private int cantidadElementos() {
		return contenedor.size();
	}

	public String listarElementos() {
		StringBuilder builder = new StringBuilder();
		
		for(E elemento : contenedor) {
			builder.append(elemento.toString());
		}
				
		return builder.toString();
	}


}
