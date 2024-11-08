// Tablero 10x10
// Máx. 5 palabras de máx. 5 letras
// Se colocan las palabras aleatoriamente
import java.util.Random;

public class Main {

    private static final int MAX_FILA = 10;

    private static final int MAX_COLUMNA = 10;

    private static char tablero[][] = new char[MAX_FILA][MAX_COLUMNA];

    private static void rellenarTablero () {
        Random aleatorio = new Random();
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                char letraAleatoria = (char) ('A' + aleatorio.nextInt(26)); // Recorre el abecedario
                tablero [i][j] = letraAleatoria;
            }
        }
    }

    private static void imprimirTablero () {
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                System.out.print((tablero [i][j]) + " ");
            }
            System.out.println();
        }
    }

    private static final String [] palabras = {"CASA", "SAL", "RATON", "SILLA", "MESA"};

    private static void colocarPalabras() {
        Random random = new Random();
        for (int i = 0; i < palabras.length; i++) { //Recorre las palabras
            String palabra = palabras[i]; //Coge cada palabra y la almacena en palabra
            System.out.println(palabra); //Las escribe al inicio

            int fila = random.nextInt(MAX_FILA);
            int columna = random.nextInt(MAX_COLUMNA);
            boolean horizontal = random.nextBoolean(); // True si es horizontal, False vertical

            // Colocar la palabra en dirección aleatoria
            for (int n = 0; n < palabra.length(); n++) { //Recorre cada carácter y lo coloca según la dirección
                if (horizontal && columna + n < MAX_COLUMNA) {
                    // Horizontalmente
                    tablero[fila][columna + n] = palabra.charAt(n); //Se mantiene la fila pero la columna aumenta
                } else if (!horizontal && fila + n < MAX_FILA) {
                    // Verticalmente
                    tablero[fila + n][columna] = palabra.charAt(n); //Se mantiene la columna pero fila aumenta
                }
            }
        }
    }

    public static void main(String[] args) {
        rellenarTablero();
        imprimirTablero();
        colocarPalabras();
    }
}