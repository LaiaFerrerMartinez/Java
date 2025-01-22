public class ArrayDinamicoPelicula {
    private Pelicula[] peliculas;
    private int tamano;

    // Constructor que inicializa el array con capacidad inicial
    public ArrayDinamicoPelicula(int capacidadInicial) {
        this.peliculas = new Pelicula[capacidadInicial];
        this.tamano = 0;
    }

    // Método para agregar una película al array
    public void agregar(Pelicula pelicula) {
        if (this.tamano == this.peliculas.length) {
            // Si el array está lleno, lo redimensionamos
            redimensionar();
        }
        this.peliculas[this.tamano] = pelicula;
        this.tamano++;
    }

    // Método para redimensionar el array duplicando su tamaño
    private void redimensionar() {
        Pelicula[] nuevoArray = new Pelicula[this.peliculas.length + 1];
        System.arraycopy(this.peliculas, 0, nuevoArray, 0, this.peliculas.length);
        this.peliculas = nuevoArray;
    }

    // Método para obtener el tamaño del array (cantidad de películas almacenadas)
    public int tamano() {
        return this.tamano;
    }

    // Método para obtener una película en una posición específica
    public Pelicula obtener(int indice) {
        if (indice >= 0 && indice < this.tamano) {
            return this.peliculas[indice];
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
    }

    // Método para mostrar todas las películas
    public void mostrarPeliculas() {
        for (int i = 0; i < this.tamano; i++) {
            System.out.println(this.peliculas[i]);
        }
    }

    public Pelicula[] getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Pelicula[] peliculas) {
        this.peliculas = peliculas;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
}
