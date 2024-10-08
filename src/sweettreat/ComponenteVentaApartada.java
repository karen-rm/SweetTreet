package sweettreat;

import java.util.Date;

public class ComponenteVentaApartada extends Venta
{
    private static int contador = 1;
    protected Date fechaEntrega = new Date();
    PagoVentaApartada pago;
    protected Estado estado;
    Cliente cliente = new Cliente();

 


    public ComponenteVentaApartada(Date fecha) {
        
        super();
        this.fechaEntrega = fecha;
        this.id_venta = contador; 
        contador++;
        estado = Estado.EnProceso;
        
    }
    
    @Override
    public void creaPago(){
        pago = new PagoVentaApartada(this.total, this.id_venta);
    }
    
    public void agregarCliente(){
        cliente.ingresaDatos();
    }
    
    public void muestraCliente(){
        cliente.muestraDatos();
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
    
    
    public void cambiarEstado(){
        if (estado == Estado.EnProceso){
            estado = Estado.Terminado;
        }
        else{
            estado = Estado.Entregado;
        }
    }
    
    public int getID(){
        return id_venta;
    }
    
    @Override
    public void mostrarVenta(){
        System.out.println("Mostrar Venta");
        
        System.out.println("ID: " + id_venta);
        System.out.println("Fecha: " + fecha);
        System.out.println("Fecha Entrega: " + fechaEntrega);
        System.out.println("Total: " + total);
        System.out.println("Estado: " + estado);
        
        for(Producto producto: lista){
            System.out.println(producto.getId() + " | " + producto.getNombre() + " | $" + producto.getPrecio() + " | Stock: " + producto.getStock() + " | " + producto.getCategoria());
        }
        
        System.out.println("Mostrar Datos Cliente");
        muestraCliente();
    }
    
     public enum Estado {
        EnProceso,
        Terminado,
        Entregado
    }
        
}
