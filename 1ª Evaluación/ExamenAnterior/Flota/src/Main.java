import java.util.Random;

public class Main {

    private static int tablero [][] = new int[10][10];

    private static final String[] direcciones = {"Arriba", "Izquierda", "Abajo", "Derecha"};

    private static final int[][] flota = {
            {0, 1, 2, 3},
            {55555, 4444, 333, 22}
    };

    private static int direccion = -1;

    private static void rellenarTablero0 () {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = 0;
            }
        }
    }

    private static void direccionAle () {
        Random ale = new Random();
        direccion = ale.nextInt(4);
    }

    private static void ponerFlota () {
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    
            }
        }
    }

    public static void main(String[] args) {

    }
}