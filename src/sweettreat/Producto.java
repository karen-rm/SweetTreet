
package sweettreat;


public class Producto {
    
    private String id_producto;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    public Producto(String id, String nom, double pre, int disp, String cate){
        id_producto = id;
        nombre = nom;
        precio = pre;
        stock = disp;
        categoria = cate;
    }


    public String getId() {
        return id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getCategoria() {
        return categoria;
    
    }
    public void setPrecio(double nuevoPrecio){
        precio = nuevoPrecio;
    }
    public void setStock(int cant){
        stock = cant;
    }

    public void imprimeInfo(){
        System.out.println("**** INFORMACION DEL PRODUCTO *****");
        System.out.println("ID: " + id_producto);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio Unitario: " + precio);
        System.out.println("Disponible en tienda: " + stock);
        System.out.println("Categoria: " + categoria);
        System.out.println();
    }
    
    
    
}
