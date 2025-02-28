package org.example;

public class Pelicula {
    private int id;
    private String titulo;
    private String director;
    private int anio;
    private Genero genero;  // Campo para almacenar el género

    // Constructor actualizado para aceptar un objeto Genero
    public Pelicula(int id, String titulo, String director, int anio, Genero genero) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.anio = anio;
        this.genero = genero;  // Asignamos el género a la película
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public int getAnio() {
        return anio;
    }

    public Genero getGenero() {
        return genero;
    }

    // Método toString actualizado para incluir el género
    @Override
    public String toString() {
        return "🎬 ID: " + id + " | 🎥 " + titulo + " | 🎬 " + director + " | 📅 " + anio + " | " +
                "Género: " + genero.getTitulo();  // Mostramos el título del género
    }
}
