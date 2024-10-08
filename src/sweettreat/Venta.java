package sweettreat;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


public abstract class Venta {
    
    //Atributos 
    protected int id_venta; 
    protected double total;
    protected Date fecha;
    protected List<Producto> lista;
    Scanner scanner = new Scanner(System.in);
    
    //Metodos 
    public Venta(){
        fecha = new Date();
        total = 0;
    }
    public void creaVenta(List<Producto> seleccion){
        lista = seleccion;
        mostrarVenta();
        calculaTotal();

    }
    public void calculaTotal(){
        for (Producto producto : lista) {
            total = total + producto.getPrecio();
        }
        
        System.out.println("El precio total de la venta es: " + total);
    }
    public abstract void mostrarVenta();
    
    public abstract void creaPago();
    public abstract void pagaTarjeta(); 
    public abstract void pagaEfectivo(); 
    
}
