package Archivos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


import Listas.ListaDePrendas;

public class archivoPrendas implements Serializable{
	
	private static String archivoDePrendas = "prendasDeVestir.dat";
	
	public static void grabarPrendas(ListaDePrendas prendas) {	
			
			FileOutputStream fileOutputStream = null;
			ObjectOutputStream objectOutputStream = null;
			
			try {
				
				fileOutputStream = new FileOutputStream(archivoDePrendas);
				objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
				objectOutputStream.writeObject(prendas);
				
				objectOutputStream.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			} 
	} 
	
		
		public static ListaDePrendas leerPrendas() {
			
			FileInputStream fileInputStream = null;
			ObjectInputStream objectInputStream = null;
			ListaDePrendas aux = new ListaDePrendas();
			
			
			try {
				fileInputStream = new FileInputStream(archivoDePrendas);
				objectInputStream = new ObjectInputStream(fileInputStream);
				
				aux = (ListaDePrendas) objectInputStream.readObject();
				
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
