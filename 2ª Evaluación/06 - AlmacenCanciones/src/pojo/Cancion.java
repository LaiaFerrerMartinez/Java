package pojo;

public class Cancion {
    private int id;
    private String titulo;
    public Cancion next = null;

    public Cancion(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Cancion getNext() {
        return next;
    }

    public void setNext(Cancion next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", next=" + next +
                '}';
    }
}
