import personajes.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PielVerde goblin1 = new Goblin("Goblin1", "Pueblo1");
        goblin1.setNivel(20);
        PielVerde goblin2 = new Goblin("Goblin2", "Pueblo2");
        goblin2.setNivel(20);

        Enano martillador1 = new Martillador("Martillador1", 1000);
        Enano martillador2 = new Martillador("Martillador2", 1000);

        ArrayList<Goblin> listaGoblin = new ArrayList<>();
        listaGoblin.add((Goblin) goblin1);
        listaGoblin.add((Goblin) goblin2);

        ArrayList<Martillador> listaMartillador = new ArrayList<>();
        listaMartillador.add((Martillador) martillador1);
        listaMartillador.add((Martillador) martillador2);
    }
}