public class Main {
    public static void main(String[] args) {
        // Crear el array dinámico con capacidad inicial de 2
        ArrayDinamicoPelicula arrayPeliculas = new ArrayDinamicoPelicula(2);

        // Agregar algunas películas
        arrayPeliculas.agregar(new Pelicula("El Padrino"));
        arrayPeliculas.agregar(new Pelicula("La Guerra de las Galaxias"));
        arrayPeliculas.agregar(new Pelicula("El Caballero Oscuro"));  // Esto redimensionará el array
        arrayPeliculas.agregar(new Pelicula("El Rey León"));  // Esto redimensionará el array
        arrayPeliculas.agregar(new Pelicula("Harry Potter"));


        // Mostrar todas las películas almacenadas
        arrayPeliculas.mostrarPeliculas();
        System.out.println();
        arrayPeliculas.buscarPelicula("El Rey León");
    }
}
