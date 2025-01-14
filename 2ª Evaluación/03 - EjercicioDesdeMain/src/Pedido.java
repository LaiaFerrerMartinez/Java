public class Pedido {
    private int numProductos;
    private Producto[] lstProductos;   // Lista estática
    private int contador = 0;

    public Pedido (int numProductos) {
        this.numProductos = numProductos;
        lstProductos = new Producto[numProductos];
    }

    // MÉTODOS GETTER/SETTER (Alt + Insert -> Getter and Setter)
    public int getNumProductos() {
        return numProductos;
    }

    public void setNumProductos(int numProductos) {
        this.numProductos = numProductos;
    }

    // MÉTODOS
    public void agregarProducto (Producto miProducto, int cant) {
        if (contador < 5) {
            this.lstProductos[contador] = miProducto;
            contador++;
        } else {
            contador = 0;
        }
    }

    // MÉTODOS TOSTRING() (Alt + Insert -> toString())
    @Override
    public String toString() {
        return "Pedido{" +
                "numProductos=" + numProductos +
                '}';
    }
}
