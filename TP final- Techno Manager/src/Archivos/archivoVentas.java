package Archivos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



import Listas.ListaDeVentas;

public class archivoVentas implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private static String archivoDeVentas = "ventas.dat";
	
	public static void grabarVentas(ListaDeVentas ventas) {	
		
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		
		try {
			
			fileOutputStream = new FileOutputStream(archivoDeVentas);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
		
			
			objectOutputStream.writeObject(ventas);
			
			
			objectOutputStream.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		} 
} 

	
	public static ListaDeVentas leerVentas() {
		
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		ListaDeVentas aux = new ListaDeVentas();
		
		
		try {
			fileInputStream = new FileInputStream(archivoDeVentas);
			objectInputStream = new ObjectInputStream(fileInputStream);			
		
			aux = (ListaDeVentas) objectInputStream.readObject();
	
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try  {
				objectInputStream.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	return aux;
	}
}
