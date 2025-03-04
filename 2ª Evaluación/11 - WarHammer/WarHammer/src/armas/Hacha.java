package armas;

public class Hacha extends ArmaAtaque{
    private final int VIDA_CONSUMIDA = 5;
    public Hacha(String nombre) {
        super(nombre);
    }

    public int getVIDA_CONSUMIDA() {
        return VIDA_CONSUMIDA;
    }

    @Override
    public String toString() {
        return "Hacha{" +
                "VIDA_CONSUMIDA=" + VIDA_CONSUMIDA +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
