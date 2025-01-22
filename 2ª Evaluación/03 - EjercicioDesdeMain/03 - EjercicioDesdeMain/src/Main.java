import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Producto magdalena = new Producto("Magdalena de chocolate", 1.50, 10);
        Producto croissant = new Producto("Croissant", 1.20, 5);
        Producto galleta = new Producto("Galleta de avena", 0.80, 20);

        System.out.println(magdalena.getNombre());
        magdalena.setStock(25);
            System.out.println(magdalena.toString());
            System.out.println(croissant.toString());
            System.out.println(galleta.toString());
            System.out.println();


        // Crear un pedido con capacidad para 5 productos
        Pedido pedido = new Pedido(5);
            pedido.agregarProducto(magdalena, 3);
            pedido.agregarProducto(croissant, 5);
            pedido.agregarProducto(galleta, 6);
            pedido.agregarProducto(magdalena, 12);
            pedido.agregarProducto(croissant, 5);
            pedido.imprimirTicket();
            System.out.println();

        // Crear un almacén con capacidad para 10 productos
        Almacen almacen = new Almacen(10);
            almacen.agregarProductoAlInventario(new Producto("Magdalena", 1.50, 10));
            almacen.agregarProductoAlInventario(new Producto("Napolitana", 1.70, 7));
            almacen.agregarProductoAlInventario(new Producto("Magdalena de fresa", 1.60, 8));
            almacen.agregarProductoAlInventario(new Producto("Galleta de chocolate", 0.80, 5));
            almacen.agregarProductoAlInventario(new Producto("Galleta", 0.70, 15));
            almacen.agregarProductoAlInventario(new Producto("Napolitana de crema", 1.80, 9));
            almacen.agregarProductoAlInventario(new Producto("Palmera de chocolate", 1.50, 13));
            almacen.mostrarInventario();
            Scanner lector = new Scanner(System.in);
            System.out.println();
            System.out.println("Dime el producto que quieras buscar en el almacen.");
            String nombreProducto = lector.nextLine();
            almacen.buscarProductoPorNombre(nombreProducto);
    }
}