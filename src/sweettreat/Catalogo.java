package sweettreat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalogo {

    private List<Producto> listaDeProductos;
    Scanner scanner = new Scanner(System.in);

    public Catalogo() {
        this.listaDeProductos = new ArrayList<>();
    }

    public void cargarCatalogoDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en palabras
                String[] palabrasEnLinea = linea.split("_");

                // Crear un nuevo objeto Dulce con las palabras como parámetros del constructor
                if (palabrasEnLinea.length >= 2) {
                    Producto nuevoProducto = new Producto(palabrasEnLinea[0], palabrasEnLinea[1], Double.parseDouble(palabrasEnLinea[2]), Integer.parseInt(palabrasEnLinea[3]), palabrasEnLinea[4]);
                    listaDeProductos.add(nuevoProducto);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el inventario :(");
            e.printStackTrace();
        }
    }

    public List<Producto> getListaDeProductos() {
        return listaDeProductos;
    }

    public void buscaProdID(){
        boolean encontrado = false;
        System.out.println("***** BUSCAR PRODUCTO *****");
        System.out.print("--- Ingresa el ID del producto: ");
        //Scanner scanner1 = new Scanner(System.in);
        String id = scanner.nextLine();
        for (Producto producto : listaDeProductos) {
            if (producto.getId().equals(id)) {
                producto.imprimeInfo();
                encontrado = true;
                System.out.println();
            }
        }
        if (encontrado == false) {
            System.out.println("Producto no encontrado :(");
        }

        System.out.println("***** FIN BUSCAR PRODUCTO *****");
        //scanner1.close();
    }

    public void agregarProducto(){
        boolean encontrado = false;
        //Scanner scanner2 = new Scanner(System.in);
        System.out.println("***** AGREGAR NUEVO PRODUCTO *****");
        System.out.println("---- A continuacion debes ingresar la informacion del nuevo producto");
        System.out.print("-- ID: ");
        String newId = scanner.nextLine();
        System.out.print("-- Nombre: ");
        String newName = scanner.nextLine();
        System.out.print("-- Precio: ");
        String newPrecio = scanner.nextLine();
        System.out.print("-- Disponible en tienda: ");
        String newStock = scanner.nextLine();
        System.out.print("-- Categoria: ");
        String newCategory = scanner.nextLine();

        Producto nuevoProducto = new Producto(newId, newName, Double.parseDouble(newPrecio), Integer.parseInt(newStock), newCategory);
        // iterar sobre la lista para verificar que no haya un id igual
        for (Producto prod : listaDeProductos) {
            if (nuevoProducto.getId() == prod.getId()) {
                encontrado = true;
            }
        }
        if (encontrado == false) { // si no hay id igual, se agrega el nuevo prod
            listaDeProductos.add(nuevoProducto);
            System.out.println("Producto agregado :)");    
        }
        else {
            System.out.println("Ya existe un producto con ese ID");
        }

        System.out.println("***** FIN AGREGAR NUEVO PRODUCTO *****");
        //scanner2.close();
    }

    public void modificarProducto() {
        System.out.println("Modificar Producto");
        System.out.println("Ingresa el id del producto que deseas modificar: ");
        String id = scanner.next();

        //Buscamos el producto 
        int indice = -1;
        for (Producto prod: listaDeProductos){
            if(prod.getId().equals(id)){
                indice = listaDeProductos.indexOf(prod);
                break;
            }
        }
        //Imprimimos la informacion actual del producto
        
        int opc = 0;
        
        while(indice != -1 && opc != 3){
            
            listaDeProductos.get(indice).imprimeInfo();
            //Menu
            System.out.println("(1)Modificar precio");
            System.out.println("(2)Modificar stock");
            System.out.println("(3)Salir");
            System.out.print("Ingresa la opcion que deseas ejecutar: ");
            opc = scanner.nextInt();

            switch(opc){
                case 1: 
                    System.out.println("Modificar precio");
                    System.out.println("Ingresar el nuevo precio: ");
                    double precio = scanner.nextDouble();
                    listaDeProductos.get(indice).setPrecio(precio);
                    break;
                case 2:
                    System.out.println("Modificar stock");
                    System.out.print("Ingresa la cantidad de productos nuevos que deseas agregar: ");
                    int masProductos = scanner.nextInt();
                    //Sumamos la cantidad que ya tenemos + los nuevos productos, para crear el total 
                    listaDeProductos.get(indice).setStock(listaDeProductos.get(indice).getStock() + masProductos);
                    break;
            }
        }
        
    }

    public void eliminarProducto() {
        System.out.println("***** ELIMINAR PRODUCTO *****");
        System.out.print("--- Ingresa el ID del producto: ");

        String id = scanner.next();

        for (Producto producto : listaDeProductos) {
            if (producto.getId().equals(id)) {
                producto.imprimeInfo();
                System.out.print("-- Deseas eliminar el producto? (Y/N): ");
                if (scanner.next().toLowerCase().equals("y")){
                    listaDeProductos.remove(producto);
                    System.out.println("Producto eliminado correctamente");
                    return;
                }
                else {
                    System.out.println("No se elimino el producto");
                    return;
                }
            }
        }
        System.out.println("Producto no encontrado :(");
    }

    public void guardarCambios(String nombrearchivo){  // imprime la lista de productos en el archivo de texto
        try {
            FileWriter fileWriter = new FileWriter(nombrearchivo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Producto producto : listaDeProductos) {
                String linea = String.join("_", producto.getId(), producto.getNombre(), Double.toString(producto.getPrecio()), Integer.toString(producto.getStock()), producto.getCategoria());
                bufferedWriter.write(linea);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Cambios realizados de manera correcta :)");
        } catch (IOException e) {
            System.out.println("Error al guardar el inventario: " + e.getMessage());
        }
    }


    public void mostrarCatalogo(){
        System.out.println("------- CATALOGO -------");
        for (Producto producto : listaDeProductos) {
            System.out.println(producto.getId() + " | " + producto.getNombre() + " | $" + producto.getPrecio() + " | Stock: " + producto.getStock() + " | " + producto.getCategoria());
        }
        System.out.println("---- FIN DE CATALOGO ----");
    }
    
    //Selecciona los productos que vamos a vender y actualizamos el stock
    public List<Producto> seleccionaProductos(){
        System.out.println("Seleccionar productos");
        List<Producto> seleccion = new ArrayList<>();
        Producto aux = null;
        int opc;
        
        do{
            System.out.print("Ingresa el ID del producto: ");
            String id = scanner.next();
            
            //Busca producto
            int indice = -1;
            for (Producto prod: listaDeProductos){
                if(prod.getId().equals(id)){
                    aux = new Producto(prod.getId(),prod.getNombre(), prod.getPrecio(), 0, prod.getCategoria());
                    indice = listaDeProductos.indexOf(prod);
                    break;
                }
            }
            //Producto encontrado
            if(indice != -1){
                //Que haya disponiblidad
               if(listaDeProductos.get(indice).getStock() != 0){
                   //Que el producto aun no este en la lista seleccionada 
                   
                   if(!seleccion.isEmpty()){
                       //Buscar en la lista 
                       int index = -1;
                       for (Producto selec: seleccion){
                           if (selec.getId().equals(id)){
                               index = seleccion.indexOf(selec);
                               break;
                           }
                       }
                       
                       if (index != -1){
                           seleccion.get(index).setStock(seleccion.get(index).getStock()+1);
                           listaDeProductos.get(indice).setStock(listaDeProductos.get(indice).getStock()-1);
                       }
                       else {
                           aux.setStock(1);
                           listaDeProductos.get(indice).setStock(listaDeProductos.get(indice).getStock()-1);
                           seleccion.add(aux);
                       }
                       
                       
                       
                   }
                   else {
                       aux.setStock(1);
                       listaDeProductos.get(indice).setStock(listaDeProductos.get(indice).getStock()-1);
                       seleccion.add(aux);
                   }
               }
                
            }
            else{
                System.out.println("Producto no encontrado");
            }
            System.out.println("¿Deseas agregar otro producto? (1)Si (2)No");
            opc = scanner.nextInt();
        }while(opc != 2);
        
        return seleccion;
    }
    
}