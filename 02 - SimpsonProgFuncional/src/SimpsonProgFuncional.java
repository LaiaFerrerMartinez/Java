import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class SimpsonProgFuncional {

    private static void imprimirTablero() {
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                // [0,0],[0,1],[0,2],ETC.
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;

    // 1º) Inicializar mi matriz tablero
    private static char[][] tablero = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];

    public static void main(String[] args) {

        // 2º) Rellenar el tablero "L"
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                // [0,0],[0,1],[0,2],ETC.
                tablero[i][j] = 'L';
            }

        }

        // 3º) Imprimir tablero
        imprimirTablero();

        System.out.println(); // Espacio entre los dos tableros
        System.out.println();
        System.out.println();

        //4º) Asignar a Bart
        Random aleatorio = new Random();
        int filaAleatorio = aleatorio.nextInt(MAX_FILA_TABLERO); // Crea números aleatorios de 0 a 9
        int columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_TABLERO); // Crea números aleatorios de 0 a 9

        tablero[filaAleatorio][columnaAleatorio] = 'B';

        // 5º) Imprimir tablero
        imprimirTablero();

        System.out.println(); // Espacio entre los dos tableros
        System.out.println();
        System.out.println();

        // 6º Repartir 10 Homers dentro del tablero
        int filaAleatorioHomer;
        int columnaAleatorioHomer;
        for (int i = 0; i < 10; i++) {
            do {
                filaAleatorioHomer = aleatorio.nextInt(MAX_FILA_TABLERO); // Crea números aleatorios de 0 a 9
                columnaAleatorioHomer = aleatorio.nextInt(MAX_COLUMNA_TABLERO); // Crea números aleatorios de 0 a 9
            } while (tablero[filaAleatorioHomer][columnaAleatorioHomer] != 'L');
            tablero[filaAleatorioHomer][columnaAleatorioHomer] = 'H';

        }

        // 7º) Imprimir tablero
        imprimirTablero();

        System.out.println(); // Espacio entre los dos tableros
        System.out.println();
        System.out.println();

        // 8º Repartir 10 Muros dentro del tablero
        int filaAleatorioMuro;
        int columnaAleatorioMuro;
        for (int i = 0; i < 10; i++) {
            do {
                filaAleatorioMuro = aleatorio.nextInt(MAX_FILA_TABLERO); // Crea números aleatorios de 0 a 9
                columnaAleatorioMuro = aleatorio.nextInt(MAX_COLUMNA_TABLERO); // Crea números aleatorios de 0 a 9
            } while (tablero[filaAleatorioMuro][columnaAleatorioMuro] != 'L');
            tablero[filaAleatorioMuro][columnaAleatorioMuro] = 'M';

        }

        // 9º) Imprimir tablero
        imprimirTablero();

        // 10º) Poner la celda final
        tablero[MAX_FILA_TABLERO-1][MAX_COLUMNA_TABLERO-1] = 'F';

        // 11º) Imprimir tablero
        imprimirTablero();
    }
}