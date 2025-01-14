public class Almacen {

    private int numProductosAlmacen;
    private Producto[] lstAlmacen;
    private int contador = 0;
    public Almacen (int numProductosAlmacen) {
        this.numProductosAlmacen = numProductosAlmacen;
        lstAlmacen = new Producto[numProductosAlmacen];
    }

    // MÉTODOS GETTER/SETTER
    public int getNumProductosAlmacen() {
        return numProductosAlmacen;
    }

    public void setNumProductosAlmacen(int numProductosAlmacen) {
        this.numProductosAlmacen = numProductosAlmacen;
    }

    // MÉTODOS
    public void agregarProductoAlInventario (Producto producto) {
        if (contador < 10) {
            this.lstAlmacen[contador] = producto;
            contador++;
        } else {
            contador = 0;
        }
    }

    public void mostrarInventario () {
        System.out.println("Inventario:");
        System.out.println("Fecha -> " + "14/01/2025");
        for (int i = 0; i < lstAlmacen.length; i++) {
            Producto producto = lstAlmacen[i];
            if (producto != null) {
                System.out.println(lstAlmacen[i].toString());
            } else {
                System.out.println("Has llegado al final del inventario.");
                break;
            }
        }
    }

    public Producto buscarProductoPorNombre(String nombreProducto) {
        for (int i = 0; i < lstAlmacen.length; i++) {
            Producto producto = lstAlmacen[i];
            if (producto != null) {
                if (nombreProducto.equals(lstAlmacen[i].getNombre())) {
                    System.out.println(lstAlmacen[i].toString());
                }
            }
        }
        return null;
    }

    // MÉTODO TOSTRING()
    @Override
    public String toString() {
        return "Almacen{" +
                "numProductosAlmacen=" + numProductosAlmacen +
                '}';
    }
}
