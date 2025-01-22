public class Pelicula {
    // ATRIBUTOS
    private String titulo;

    // CONSTRUCTOR
    public Pelicula(String titulo) {
        this.titulo = titulo;
    }

    // MÉTODOS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + this.titulo + '\'' +
                '}';
    }
}
