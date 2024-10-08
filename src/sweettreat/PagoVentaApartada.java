package sweettreat;

public class PagoVentaApartada extends Pago {
     
    protected double restante;
	
    public PagoVentaApartada(double monto, int id) 
      {
        super(monto, id); 
        restante = monto;
      }

    @Override
    public void pagoTarjeta() {
        double minimo = calculaMinimo();
        if (restante == monto){
            restante = restante - minimo;
            System.out.println("Pago minimo requerido: " + minimo);
            System.out.println( "El pago de la venta apartada " + id + " se ha realizado exitosamente con Tarjeta.");
            System.out.println("Importe: " + minimo);
        }
        else{
            System.out.println( "El pago de la venta apartada " + id + " se ha realizado exitosamente con Tarjeta.");
            System.out.println("Importe: " +restante);
            restante = 0;
        }
        
        
        
    };

    @Override
    public void pagoEfectivo(double efectivo) {
        double minimo = calculaMinimo();
        if (restante == monto){
            
            System.out.println("Pago minimo requerido: " + minimo);
            double cambio = efectivo - minimo;
            
            if (cambio >= 0) {
                System.out.println("Cambio a devolver: " + cambio);
                System.out.println( "El pago de la venta apartada" + id + " se ha realizado exitosamente.");
                System.out.println("Importe: " +restante);
                
            } else {
                System.out.println("El monto pagado no es suficiente.");
            }
            
        }
        else {
            
            double cambio = efectivo - minimo;
            
            if (cambio >= 0) {
                System.out.println("Cambio a devolver: " + cambio);
                System.out.println( "El pago de la venta apartada" + id + " se ha realizado exitosamente.");
                System.out.println("Importe: " +restante);
                restante = 0;
                
            } else {
                System.out.println("El monto pagado no es suficiente.");
            }
        }
        
        
    }
    public double calculaMinimo(){
        double minimo = monto  * 0.5;
        return minimo;
    }
    
   
	
}
