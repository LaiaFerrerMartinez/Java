import java.util.Random;
import java.util.Scanner;

public class LaiaFerrerMartinez {
    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;
    private static char tablero [][] = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];
    private static int filaBart = -1;
    private static int columnaBart = -1;
    private static int vidas = 10;



    // 1º Rellenar tablero con 'L'
    private static void rellenarTableroLibres (char caracter) {
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                tablero [i][j] = caracter;
            }
        }
    }


    private static void rellenarTableroPersonajes (char caracter, int num) {
        int filaPersonajes = -1;
        int columnaPersonajes = -1;
        for (int i = 0; i < num; i++) {
            Random aleatorio = new Random();

            do {
                filaPersonajes = aleatorio.nextInt(MAX_FILA_TABLERO);
                columnaPersonajes = aleatorio.nextInt(MAX_COLUMNA_TABLERO);
            } while (tablero[filaPersonajes][columnaPersonajes] != 'L');
            tablero [filaPersonajes][columnaPersonajes] = caracter;
        }
        if (caracter == 'B') {
            filaBart = filaPersonajes;
            columnaBart = columnaPersonajes;
        }
    }

    private static void imprimirTablero () {
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                System.out.printf(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void moverBart (int fila, int columna) {
        tablero [fila][columna] = 'B';
        tablero [filaBart][columnaBart] = 'L';
        filaBart = fila;
        columnaBart = columna;
    }

    private static void comprobarCeldaDestino (int filaDestino, int columnaDestino) {
        boolean destinoLibre = false;
        switch (tablero [filaDestino][columnaDestino]) {
            case 'L':
                destinoLibre = true;
                break;
            case 'H':
                destinoLibre = true;
                vidas = vidas - 1;
                System.out.println("Te quedan " + vidas + " vidas.");
                break;
            case 'M':
                destinoLibre = false;
                break;
            case 'F':
                destinoLibre = true;
                vidas = -1;
                break;
        }
        if (destinoLibre == true) {
            moverBart (filaDestino, columnaDestino);
        } else if (destinoLibre == false) {
            System.out.println("No puedes moverte porque hay un muro.");
        }
    }

    private static void movW () {
        if ((filaBart - 1) >= 0) {
            comprobarCeldaDestino((filaBart - 1), columnaBart);
        }
    }

    private static void movA () {
        if ((columnaBart - 1) >= 0) {
            comprobarCeldaDestino(filaBart, (columnaBart - 1));
        }
    }

    private static void movS () {
        if ((filaBart + 1) <= 9) {
            comprobarCeldaDestino((filaBart + 1), columnaBart);
        }
    }

    private static void movD () {
        if ((columnaBart + 1) <= 9) {
            comprobarCeldaDestino(filaBart, columnaBart + 1);
        }
    }

    private static void jugar () {
        System.out.println("Tienes que conseguir que Bart llegue a la casilla final (F).");
        System.out.println("Tienes 10 vidas");
        System.out.println("Utiliza el movimiento WASD:");
        System.out.println("W: arriba");
        System.out.println("A: izquierda");
        System.out.println("S: abajo");
        System.out.println("D: derecha");
        Scanner lector = new Scanner(System.in);
        do {
            System.out.println("Dime el desplazamiento que quieres realizar:");
            String desplazamiento = lector.nextLine();
            switch (desplazamiento) {
                case "W":
                    movW ();
                    break;
                case "A":
                    movA ();
                    break;
                case "S":
                    movS ();
                    break;
                case "D":
                    movD ();
                    break;
            }

            imprimirTablero();

        } while (vidas > 0);

        if (vidas == 0) {
            System.out.println("Has perdido, te has quedado sin vidas.");
        } else if (vidas == -1) {
            System.out.println("¡Has ganado!");
        }
    }

    public static void main(String[] args) {
        //  1º Rellenar tablero con libres
        rellenarTableroLibres('L');

        //  2º Poner la celda final
        tablero[MAX_FILA_TABLERO - 1][MAX_COLUMNA_TABLERO - 1] = 'F';

        //  3º Rellenar tablero con Bart
        rellenarTableroPersonajes('B', 1);

        //  4º Rellenar tablero con Homers
        rellenarTableroPersonajes('H', 10);

        //  5º Rellenar tablero con Muros
        rellenarTableroPersonajes('M', 5);

        //  5º Imprimir tablero
        imprimirTablero();

        // 6º Jugar
        jugar();
    }
}