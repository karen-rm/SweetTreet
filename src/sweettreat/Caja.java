
package sweettreat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Caja {
   private Catalogo catalogo;
   private ComponenteVenta ventaIns;
   private List<ComponenteVentaApartada> apartado;
   private Historial historial;
   
   Scanner scanner = new Scanner(System.in);
   
   public Caja(){
       catalogo = new Catalogo();
       catalogo.cargarCatalogoDesdeArchivo("archivo.txt");
       apartado = new ArrayList<>();
       historial = Historial.Instance();
       
   }
   
   //Prueba 
   public void muestraCatalogo(){
       catalogo.mostrarCatalogo();
   }
   //Empezaremos con las acciones que puede hacer el admin 
   public void modificarCatalogo(){
       int opc;
       do{
            System.out.println("--- Modificar Catalogo ---");
            System.out.println("(1)Agregar producto");
            System.out.println("(2)Modificar producto");
            System.out.println("(3)Eliminar producto");
            System.out.println("(4)Salir");
            System.out.println("Ingresa la opcion que deseas realizar: ");
            opc = scanner.nextInt();



            switch(opc){
                case 1:
                    catalogo.agregarProducto();
                    break;
                case 2:
                    catalogo.modificarProducto();
                    break;

                case 3:
                    catalogo.eliminarProducto();
                    break;

            }
            }while(opc !=4);
       
           catalogo.guardarCambios("archivo.txt");
       
   }
   
   //Vamos a por la venta
   public void creaVenta(){
       catalogo.mostrarCatalogo();
       
       System.out.println("Crear venta instantanea");
       List<Producto> seleccion = catalogo.seleccionaProductos();
       catalogo.guardarCambios("archivo.txt");
       
       ventaIns = new ComponenteVenta();
       ventaIns.creaVenta(seleccion);
       ventaIns.creaPago();
       
       
       System.out.print("Selecciona el metodo de pago (1)tarjeta (2)efectivo: ");
       int opc = scanner.nextInt();
       
       if (opc == 1){
           ventaIns.pagaTarjeta();
       }
       else{
           ventaIns.pagaEfectivo();
       }
       
       historial.agregaVenta(ventaIns);
       
   }
   public void creaApartado(){
       
       catalogo.mostrarCatalogo();
       
       System.out.println("Crear apartado");
       List<Producto> seleccion = catalogo.seleccionaProductos();
       catalogo.guardarCambios("archivo.txt");
       
       
       
       System.out.print("Ingresa la fecha de entrega (formato dd/MM/yyyy): ");
       String entrega = scanner.next();
       
       SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
       Date fecha = null;
       try {
            fecha = formatoFecha.parse(entrega);
            System.out.println("Fecha ingresada: " + formatoFecha.format(fecha));
            
            
            
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto. Asegúrate de usar el formato dd/MM/yyyy.");
        }
       
       
        ComponenteVentaApartada apartadoAux = new ComponenteVentaApartada(fecha);
        apartadoAux.agregarCliente();
        apartadoAux.creaVenta(seleccion);
        apartadoAux.creaPago();
            
        System.out.print("Selecciona el metodo de pago (1)tarjeta (2)efectivo: ");
        int opc = scanner.nextInt();

        if (opc == 1){
            apartadoAux.pagaTarjeta();
        }
        else{
            apartadoAux.pagaEfectivo();

        }
        apartado.add(apartadoAux);
       
   }
   
   public void muestraApartados(){
       for (ComponenteVentaApartada apart: apartado){
           apart.mostrarVenta();
       }
   }
   
   public void seguimientoApartado(){
       //Buscar venta 
       System.out.print("Buscar apartado: ");
       int id = scanner.nextInt();
       int indice = -1;
       
       if (!apartado.isEmpty()){
            for(ComponenteVentaApartada apart: apartado){
                if (apart.getID() == id){
                    indice = apartado.indexOf(apart);
                    break;
                } 
            }
           
            System.out.println("Estado del apartado: " + apartado.get(indice).estado);
            
            int opc = 0;
            if(apartado.get(indice).estado == ComponenteVentaApartada.Estado.EnProceso){
                System.out.print("¿Desear cambiar el estado? (1)Si (2)No: ");
                opc = scanner.nextInt();
                
                if (opc == 1){
                    apartado.get(indice).cambiarEstado();
                }
                else{
                    System.out.println("Estado no modificado");
                }
            }
            else if(apartado.get(indice).estado == ComponenteVentaApartada.Estado.Terminado){
                System.out.print("¿Desear entregar el apartado? (1)Si (2)No: ");
                opc = scanner.nextInt();
                if (opc == 1){
                    apartado.get(indice).cambiarEstado();
                    System.out.print("Selecciona el metodo de pago (1)tarjeta (2)efectivo: ");
                    opc = scanner.nextInt();

                    if (opc == 1){
                        apartado.get(indice).pagaTarjeta();
                    }
                    else{
                        apartado.get(indice).pagaEfectivo();

                    }
                    historial.agregaApartado(apartado.get(indice));
                    apartado.remove(indice);
                }
                else{
                    System.out.println("Estado no modificado");
                }
            }
       }
   }
   
   public void generaReporte(){
       System.out.println("Generar Reporte");

       historial.crearArchivoReporteVentas("reporte.txt");
       historial.muestraReporte();
   }
   
   
   
}
