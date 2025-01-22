public class ArrayDinamicoPelicula {
    private Pelicula[] peliculas;
    private int tamano;

    // Constructor que inicializa el array con capacidad inicial
    public ArrayDinamicoPelicula(int capacidadInicial) {
        peliculas = new Pelicula[capacidadInicial];
        tamano = 0;
    }

    // Método para agregar una película al array
    public void agregar(Pelicula pelicula) {
        if (tamano == peliculas.length) {
            // Si el array está lleno, lo redimensionamos
            redimensionar();
        }
        peliculas[tamano] = pelicula;
        tamano++;
    }

    // Método para redimensionar el array duplicando su tamaño
    private void redimensionar() {
        Pelicula[] nuevoArray = new Pelicula[peliculas.length * 2];
        System.arraycopy(peliculas, 0, nuevoArray, 0, peliculas.length);
        peliculas = nuevoArray;  // Ahora 'peliculas' apunta al nuevo array
    }

    // Método para obtener el tamaño del array (cantidad de películas almacenadas)
    public int tamano() {
        return tamano;
    }

    // Método para obtener una película en una posición específica
    public Pelicula obtener(int indice) {
        if (indice >= 0 && indice < tamano) {
            return peliculas[indice];
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
    }

    // Método para mostrar todas las películas
    public void mostrarPeliculas() {
        for (int i = 0; i < tamano; i++) {
            System.out.println(peliculas[i]);
        }
    }
}
