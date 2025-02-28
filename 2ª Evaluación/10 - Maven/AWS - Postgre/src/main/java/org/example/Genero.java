package org.example;

public class Genero {
    private int id;
    private String titulo;

    // Constructor para inicializar id y titulo del género
    public Genero(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
