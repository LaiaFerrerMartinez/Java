public class ArrayDinamicoPelicula {

    //ATRIBUTOS
    private Pelicula[] peliculas;
    private int tamano;

    // CONSTRUCTOR
    public ArrayDinamicoPelicula(int capacidadInicial) {
        this.peliculas = new Pelicula[capacidadInicial];
        this.tamano = 0;
    }

    // MÉTODOS
    // Agregamos una película al array
    public void agregar(Pelicula pelicula) {
        if (this.tamano == this.peliculas.length) {
            // Si el array está lleno, lo redimensionamos
            redimensionar();
        }
        this.peliculas[this.tamano] = pelicula;
        this.tamano++;
    }

    // Redimensonamos el array añadiendo un 1
    private void redimensionar() {
        Pelicula[] nuevoArray = new Pelicula[this.peliculas.length + 1];
        System.arraycopy(this.peliculas, 0, nuevoArray, 0, this.peliculas.length);
        this.peliculas = nuevoArray;
    }

    // Mostramos todas las películas
    public void mostrarPeliculas() {
        for (int i = 0; i < getTamano(); i++) {
            System.out.println(this.peliculas[i]);
        }
    }

    public void buscarPelicula(String titulo) {
        boolean encontrada = false;
        for (int i = 0; i < getTamano(); i++) {
            if (this.peliculas[i].getTitulo().equals(titulo)) {
                System.out.println(this.peliculas[i]);  // Llama a toString automáticamente
                encontrada = true;
                break;  // Si deseas detener la búsqueda después de encontrar la película
            }
        }
        if (!encontrada) {
            System.out.println("Película no encontrada.");
        }
    }


    public int getTamano() {
        return tamano;
    }
}
