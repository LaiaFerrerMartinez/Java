import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class SimpsonProgFuncionalMovimientos {

    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;
    private static char [][] tablero;
    private static int filaBart;
    private static int columnaBart;
    private static int filaDestino;
    private static int columnaDestino;
    private static int vidas;

    private static void imprimirTablero() {
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                // [0,0],[0,1],[0,2],ETC.
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(); // Espacio entre los dos tableros
        System.out.println();
        System.out.println();
    }
    private static void asignarLibreACasilla(char caracter){
        // Rellenar el tablero "L"
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                // [0,0],[0,1],[0,2],ETC.
                tablero[i][j] = caracter;
            }
        }
    }
    private static void asignarPersonajesACasillaLibre (char caracter, int numRepeticiones) {
        // Asignar Personajes
        Random aleatorio = new Random();
        int filaAleatorio = -1;
        int columnaAleatorio = -1;
        for (int i = 0; i < numRepeticiones; i++) {
            do {
                filaAleatorio = aleatorio.nextInt(MAX_FILA_TABLERO); // Crea números aleatorios de 0 a 9
                columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_TABLERO); // Crea números aleatorios de 0 a 9
            } while (tablero[filaAleatorio][columnaAleatorio] != 'L');
            tablero[filaAleatorio][columnaAleatorio] = caracter;
        }
        if (caracter=='B') {
            filaBart = filaAleatorio;
            columnaBart = columnaAleatorio;
        }
    }

    private static void moverBart (int fila, int columna) {
        tablero[fila][columna] = 'B';
        tablero[filaBart][columnaBart] = 'L';
        filaBart = fila;
        columnaBart = columna;
    }

    private static void segunCelda () {
        switch (tablero[filaDestino][columnaDestino]) {
            case 'H':
                vidas = vidas - 1;
                System.out.println("Has perdido una vida. Te quedan " + vidas + " vidas.");
                moverBart (filaDestino, columnaDestino);
                break;
            case 'L':
                moverBart (filaDestino, columnaDestino);
                break;
            case 'M':
                System.out.println("El muro no te deja desplazarte a esta casilla.");
                break;
            case 'F':
                moverBart (filaDestino, columnaDestino);
                vidas = -1;
                break;
        }
    }

    private static void movA () {
        columnaDestino = columnaBart - 1;
        if (columnaDestino >= 0) {
            segunCelda();
        } else {
            System.out.println("Desplazamiento prohibido. Límite de tablero");
        }
    }

    private static void movS () {
        filaDestino = filaBart + 1;
        if ((filaDestino) <= 9) {
            segunCelda();
        } else {
            System.out.println("Desplazamiento prohibido. Límite de tablero");
        }
    }

    private static void movD () {
        columnaDestino = columnaBart + 1;
        if ((columnaDestino) <= 9) {
            segunCelda();
        } else {
            System.out.println("Desplazamiento prohibido. Límite de tablero");
        }
    }

    private static void movW () {
        filaDestino = filaBart - 1;
        if ((filaDestino) >= 0) {
            segunCelda();
        } else {
            System.out.println("Desplazamiento prohibido. Límite de tablero");
        }
    }

    private static void jugarSimpson () {
        Scanner lector = new Scanner(System.in);
        vidas = 10;
        filaDestino = filaBart;
        columnaDestino = columnaBart;
        do {
            System.out.println("Dime el desplazamiento que quieres realizar");
            System.out.println("WASD");
            String desplazamiento = lector.nextLine();
            switch (desplazamiento) {
                case "A":
                    movA ();
                    break;
                case "S":
                    movS ();
                    break;
                case "D":
                    movD ();
                    break;
                case "W":
                    movW ();
                    break;
                default:
                    break;
            }
            imprimirTablero();
        } while (vidas > 0);
        if (vidas == 0) {
            System.out.println("Te has quedado sin vidas. Has perdido.");
        } else if (vidas == -1) {
            System.out.println("¡Has ganado!");
        }
    }

    public static void main(String[] args) {

        // 1º) Inicializar mi matriz tablero
        tablero = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];

        // 2ª) Rellenar el tablero "L"
        asignarLibreACasilla('L');

        // 3º) Imprimir tablero
        imprimirTablero();

        // 4º) Asignar a Bart
        asignarPersonajesACasillaLibre('B', 1);

        imprimirTablero();

        // 5º) Repartir 10 Homers dentro del tablero
        asignarPersonajesACasillaLibre('H', 10);

        imprimirTablero();

        // 6º) Repartir 10 Muros dentro del tablero
        asignarPersonajesACasillaLibre('M', 10);

        imprimirTablero();

        // 7º) Poner la celda final
        tablero[MAX_FILA_TABLERO-1][MAX_COLUMNA_TABLERO-1] = 'F';

        imprimirTablero();

        // 8º) Desplazamiento de Bart
            // W --> Arriba
            // A --> Izquierda
            // S --> Abajo
            // D --> Derecha
        jugarSimpson ();
    }
}
