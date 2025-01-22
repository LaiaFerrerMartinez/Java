public class Main {
    public static void main(String[] args) {
        // Crear el array dinámico con capacidad inicial de 2
        ArrayDinamicoPelicula arrayPeliculas = new ArrayDinamicoPelicula(2);

        // Agregar algunas películas
        arrayPeliculas.agregar(new Pelicula("El Padrino"));
        arrayPeliculas.agregar(new Pelicula("La Guerra de las Galaxias"));
        arrayPeliculas.agregar(new Pelicula("El Caballero Oscuro"));  // Esto redimensionará el array


        // Mostrar todas las películas almacenadas
        arrayPeliculas.mostrarPeliculas();
    }
}
