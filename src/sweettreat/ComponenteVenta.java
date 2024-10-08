package sweettreat;

public class ComponenteVenta extends Venta {
    
    PagoVenta pago;
    private static int contador = 1;

    public ComponenteVenta() {
        super();
        this.id_venta = contador; 
        contador++;
        
    }
 

    @Override
    public void pagaTarjeta() {
        System.out.println("Pago con tarjeta");
        pago.pagoTarjeta();
    }

    @Override
    public void pagaEfectivo() {
        System.out.println("Pago en efectivo");
        System.out.print("Ingresa el dinero entregado: ");
        double efectivo = scanner.nextDouble();
        pago.pagoEfectivo(efectivo);
    }
    
    @Override
    public void creaPago(){
        pago = new PagoVenta(total, id_venta);
    }
    
    @Override
    public void mostrarVenta(){
        System.out.println("Mostrar Venta");
        
        System.out.println("ID: " + id_venta);
        System.out.println("Fecha: " + fecha);
        System.out.println("Total: " + total);
        
        for(Producto producto: lista){
            System.out.println(producto.getId() + " | " + producto.getNombre() + " | $" + producto.getPrecio() + " | Stock: " + producto.getStock() + " | " + producto.getCategoria());
        }
    }
	
      
	
        

}
