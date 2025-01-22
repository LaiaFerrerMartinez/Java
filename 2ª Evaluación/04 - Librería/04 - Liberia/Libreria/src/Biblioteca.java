public class Biblioteca {
    private static final int CAPACIDAD = 3;
    private static Libro[] libros = new Libro[CAPACIDAD];
    private static int contadorLibros = 0;
    static void agregarLibro(Libro libro) {
        if (contadorLibros < CAPACIDAD) {
            libros[contadorLibros] = libro;
            contadorLibros++;
            System.out.println("CON ESPACIO");
        } else {
            System.out.println("SIN ESPACIO");
        }
    }

    static void listarLibros() {
        for (Libro libro: libros) {
            System.out.println(libro.toString());
        }
    }
    public static Libro buscarLibro(String titulo) {
        for (Libro libro: libros) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }
    static void prestarLibro(String titulo) {
        Libro libro = buscarLibro(titulo);
        if (libro.isDisponible() == true) {
            libro.setDisponible(false);
            System.out.println("LIBRO PRESTADO");
        } else {
            System.out.println("EL LIBRO NO ESTÁ DISPONIBLE, NO SE PUEDE PRESTAR");
        }

    }
    static void devolverLibro(String titulo) {
        Libro libro = buscarLibro(titulo);
        if (libro.isDisponible() == false) {
            libro.setDisponible(true);
            System.out.println("LIBRO DEVUELTO");
        } else {
            System.out.println("EL LIBRO YA ESTÁ DEVUELTO");
        }
    }
}
