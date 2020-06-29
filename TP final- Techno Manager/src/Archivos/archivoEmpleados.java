package Archivos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import Listas.ListaDeEmpleados;

public class archivoEmpleados implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private static String archivoDeEmpleados = "empleados.dat";
	
	public static void grabarEmpleados(ListaDeEmpleados empleados) {	
			
			FileOutputStream fileOutputStream = null;
			ObjectOutputStream objectOutputStream = null;
			
			try {
				
				fileOutputStream = new FileOutputStream(archivoDeEmpleados);
				objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
				objectOutputStream.writeObject(empleados);
				
				objectOutputStream.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			} 
	} 
	
		
		public static ListaDeEmpleados leerEmpleados() {
			
			FileInputStream fileInputStream = null;
			ObjectInputStream objectInputStream = null;
			ListaDeEmpleados aux = new ListaDeEmpleados();
			
			
			try {
				fileInputStream = new FileInputStream(archivoDeEmpleados);
				objectInputStream = new ObjectInputStream(fileInputStream);
				
				aux = (ListaDeEmpleados) objectInputStream.readObject();
				
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
