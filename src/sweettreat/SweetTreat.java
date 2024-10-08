
package sweettreat;

import java.util.Scanner;

public class SweetTreat {

  
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String userAdmin = "admin1";
        String passwordAdmin = "1234";

        String userCajero = "cajero1";
        String passwordCajero = "1234";
        boolean continuar = true;
        
        do{
            System.out.println("Bienvenido a SweetTreet");
            System.out.print("Ingresa tu usuario: ");
            String usuario = scanner.next();
            System.out.print("Ingresa tu contraseña: ");
            String contraseña = scanner.next();

            Caja caja = new Caja();
            int opcion;

            if (usuario.equals(userAdmin) && contraseña.equals(passwordAdmin)) {
                // Acceder como administrador

                do{
                    System.out.println("----- Menú del Administrador -----");
                    System.out.println("(1) Modificar Inventario");
                    System.out.println("(2) Generar Reporte ");
                    System.out.println("(3) Salir");
                    System.out.print("Ingresa la opción que deseas realizar: ");
                    opcion = scanner.nextInt();

                    switch(opcion){
                        case 1:
                            caja.modificarCatalogo();
                            break;
                        case 2:
                            caja.generaReporte();
                            break;
                    }
                    }while(opcion != 3);

            } else if (usuario.equals(userCajero) && contraseña.equals(passwordCajero)) {
                // Acceder como cajero

                do {
                    System.out.println("----- Menú del Cajero -----");
                    System.out.println("(1) Crear Venta");
                    System.out.println("(2) Crear Apartado");
                    System.out.println("(3) Ver Catálogo");
                    System.out.println("(4) Mostrar Lista de Apartados");
                    System.out.println("(5) Seguir pedidos");
                    System.out.println("(6) Salir");
                    System.out.print("Ingresa la opción que deseas realizar: ");
                    opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1:
                            caja.creaVenta();
                            break;
                        case 2:
                            caja.creaApartado();
                            break;
                        case 3:
                            caja.muestraCatalogo();
                            break;
                        case 4:
                            caja.muestraApartados();
                            break;
                        case 5:
                            caja.muestraApartados();
                            caja.seguimientoApartado();
                            break;
                    }
                } while (opcion != 6);
            } else {
                System.out.println("Usuario o contraseña incorrectos. ");
            }
            
            System.out.print("¿Quieres ingresar con otro usuario? (Sí/No): ");
            String respuesta = scanner.next().toLowerCase();
            continuar = respuesta.equals("sí") || respuesta.equals("si");
            
        }while(continuar);

        

        // Cerrar el Scanner
        scanner.close();
    }
        
        
       
        
        
        
    }
    

