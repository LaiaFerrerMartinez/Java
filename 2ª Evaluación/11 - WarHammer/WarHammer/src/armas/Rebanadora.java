package armas;

public class Rebanadora extends ArmaAtaque{
    private final int VIDA_CONSUMIDA = 5;
    public Rebanadora(String nombre) {
        super(nombre);
    }

    public int getVIDA_CONSUMIDA() {
        return VIDA_CONSUMIDA;
    }

    @Override
    public String toString() {
        return "Rebanadora{" +
                "VIDA_CONSUMIDA=" + VIDA_CONSUMIDA +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
