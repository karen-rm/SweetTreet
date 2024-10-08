package sweettreat;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Historial {
    private List<ComponenteVenta> historialVentas = new ArrayList<>();
    private List<ComponenteVentaApartada> historialApartado = new ArrayList<>();
    private static Historial _instance = null;

    private Historial() {
        
       
    }

    public static Historial Instance() {
        if (_instance == null)
            _instance = new Historial();
        return _instance;
    }

    public void agregaVenta(ComponenteVenta venta) {
        historialVentas.add(venta);
    }
    
    public void agregaApartado(ComponenteVentaApartada apartado){
        historialApartado.add(apartado);
    }

    public void muestraReporte() {
        System.out.println("----- Reporte de Ventas -----");
        for (ComponenteVenta venta : historialVentas) {
            System.out.println("ID: " + venta.id_venta + "\nFecha: " + venta.fecha + "\nTotal: " + venta.total);
        }
        System.out.println("----- Reporte de Apartados -----");
        for (ComponenteVentaApartada apartado : historialApartado) {
            System.out.println("ID: " + apartado.id_venta + "\nFecha: " + apartado.fecha + "\nTotal: " + apartado.total + "\n");
        }
        System.out.println("-------------------------------");
    }

    public void crearArchivoReporteVentas(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("----- Reporte de Ventas -----\n");
            for (ComponenteVenta venta : historialVentas) {
                writer.write("ID: " + venta.id_venta + "\nFecha: " + venta.fecha + "\nTotal: " + venta.total + "\n");
            }
            
            writer.write("Reporte Apartado\n");
            
            for (ComponenteVentaApartada apartado : historialApartado) {
                writer.write("ID: " + apartado.id_venta + "\nFecha: " + apartado.fecha + "\nTotal: " + apartado.total + "\n");
            }
            writer.write("-------------------------------\n");
            System.out.println("Archivo de reporte creado exitosamente: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al crear el archivo de reporte: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
