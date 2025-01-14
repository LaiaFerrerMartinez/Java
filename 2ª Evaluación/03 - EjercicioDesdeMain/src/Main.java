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
    }
}