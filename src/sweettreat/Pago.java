package sweettreat;

import java.util.Date;

public abstract class Pago {
    protected int id;
    protected double monto;  
    protected Date fecha = new Date();

    public Pago(double total, int id) 
    { 
        monto = total;
        this.id = id;
    } 
	
    public abstract void pagoTarjeta();
    public abstract void pagoEfectivo(double efectivo); 

}
