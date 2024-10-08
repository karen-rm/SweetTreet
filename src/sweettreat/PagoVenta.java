package sweettreat;

public class PagoVenta extends Pago {
    
	
    public PagoVenta(double total, int id) 
    {
        super(total, id); 
    }

    @Override
    public void pagoTarjeta() {
            System.out.println( "El pago de la venta " + id + " se ha realizado exitosamente con Tarjeta.");
            System.out.println("Importe: " + monto);
    };

    @Override
    public void pagoEfectivo(double efectivo) {
        
        double cambio = efectivo - monto;
        if (cambio >= 0) {
            System.out.println("Cambio a devolver: " + cambio);
            System.out.println( "El pago de la venta " + id + " se ha realizado exitosamente.");
        } else {
            System.out.println("El monto pagado no es suficiente.");
        }

    }; 
}
