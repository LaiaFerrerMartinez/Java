package armas;

import personajes.WarhammerPersonaje;

public class Escudo extends ArmaDefensa{
    private final int VIDA_DEFENDIDA = 2;
    public Escudo(String nombre) {
        super(nombre);
    }

    public int getVIDA_DEFENDIDA() {
        return VIDA_DEFENDIDA;
    }

    @Override
    public String toString() {
        return "Escudo{" +
                "VIDA_DEFENDIDA=" + VIDA_DEFENDIDA +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public void defender(WarhammerPersonaje defendido, ArmaAtaque armaAtacante) {
        super.defender(defendido, armaAtacante);
    }
}
