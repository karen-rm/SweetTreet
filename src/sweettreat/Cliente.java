package sweettreat;

import java.math.BigInteger;
import java.util.Scanner;

public class Cliente {
	private BigInteger  numero;
	private String nombre, apellido, correo; 
	 
	public Cliente() {
		
	}
        
        public void ingresaDatos(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingresa los datos del cliente: ");
            System.out.print("Nombre: ");
            nombre = scanner.next();
            System.out.print("Apellido: ");
            apellido = scanner.next();
            System.out.print("Correo: ");
            correo = scanner.next();
            System.out.print("Numero: ");
            numero = scanner.nextBigInteger();
            
        }
	
	public void muestraDatos(){
        System.out.println("**** Datos del cliente *****");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Numero: " + numero);
        System.out.println("Correo: " + correo);
    }
	
	
}
