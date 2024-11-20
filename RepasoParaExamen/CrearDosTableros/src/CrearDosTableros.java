// Dos tableros con Yoda, Vader, DarthMaul, R2D2
import java.util.Random;
import java.util.Scanner;

public class CrearDosTableros {

    private static int MAX_FILA = 10;

    private static int MAX_COLUMNA = 10;

    private static char tablero1[][] = new char[MAX_FILA][MAX_COLUMNA];

    private static char tablero2[][] = new char[MAX_FILA][MAX_COLUMNA];

    private static char letras[] = {'W', 'A', 'S', 'D'};

    private static int movimientos[][] = new int[4][2];

    private static int filaPers, colPers, vidas;

    private static void rellenarTableroL (char[][] tablero) {
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                tablero[i][j] = 'L';
            }
        }
    }

    private static void imprimirTablero (char[][] tablero) {
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rellenarTableroPers (char[][] tablero, char pers, int num) {
        Random ale = new Random();
        int filaAl = -1;
        int colAl = -1;
        for (int i = 0; i < num; i++) {
            do {
                filaAl = ale.nextInt(MAX_FILA);
                colAl = ale.nextInt(MAX_COLUMNA);
            } while (tablero[filaAl][colAl] != 'L');
            tablero[filaAl][colAl] = pers;
        }
        if (pers == 'Y') {
            int filaYoda = filaAl;
            int colYoda = colAl;
        } else if (pers == 'V') {
            int filaVader = filaAl;
            int colVader = colAl;
        }
    }

    private static void movimientoAleatorio (char[][] tablero) {
        Scanner lector = new Scanner(System.in);
        int numTablero = 0;
        char pers = 'L';
        if (tablero == tablero1) {
            numTablero = 1;
            pers = 'D';
        } else if (tablero == tablero2) {
            numTablero = 2;
            pers = 'R';
        }
        int fila;
        int columna;
        do {
            System.out.println("Estás en el tablero " + numTablero);
            System.out.println("Dime la fila (0 - 9) del personaje que quieres que se mueva.");
            fila = lector.nextInt();
            System.out.println("Dime la columna (0 - 9) del personaje que quieres que se mueva.");
            columna = lector.nextInt();
        } while (tablero[fila][columna] != pers);
        int filaNueva;
        int colNueva;
        Random ale = new Random();
        do {
            filaNueva = ale.nextInt(MAX_FILA);
            colNueva = ale.nextInt(MAX_COLUMNA);
        } while (tablero[filaNueva][colNueva] != 'L');
        tablero[filaNueva][colNueva] = pers;
        tablero[fila][columna] = 'L';
    }

    private static void desplazamiento (int filaPers, int colPers, char[][] tablero, char pers) {
        int filaCheck;
        int colCheck;
        int casillas;
        Scanner lector = new Scanner(System.in);

        movimientos [0][0] = -1;
        movimientos [0][1] = 0;

        movimientos [1][0] = 0;
        movimientos [1][1] = -1;

        movimientos [2][0] = 1;
        movimientos [2][1] = 0;

        movimientos [3][0] = 0;
        movimientos [3][1] = 1;

        System.out.println("Dime el movimiento que quieres hacer.");
        char direccion = lector.next().charAt(0);
        do {
            System.out.println("Dime el número de casillas que te quieres mover.");
            casillas = lector.nextInt();
        } while (casillas < 1 || casillas > 3);

        int coordenada = -1;

        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == direccion) {
                coordenada = i;
            }
        }
        filaCheck = filaPers + (movimientos[coordenada][0] * casillas);
        colCheck = colPers + (movimientos[coordenada][1] * casillas);
        comprobarCelda(filaCheck, colCheck, tablero, pers);
    }

    private static void comprobarCelda (int filaCheck, int colCheck, char[][] tablero, char pers) {
        switch (tablero[filaCheck][colCheck]) {
            case 'L':
                tablero[filaCheck][colCheck] = pers;
                tablero[filaPers][colPers] = 'L';
                filaPers = filaCheck;
                colPers = filaCheck;
                break;
            case 'M':
                break;
            case 'D', 'R':
                tablero[filaCheck][colCheck] = pers;
                tablero[filaPers][colPers] = 'L';
                filaPers = filaCheck;
                colPers = colCheck;
                vidas--;
        }
    }

    private static void rellenar () {
        rellenarTableroL(tablero1);
        rellenarTableroL(tablero2);
        rellenarTableroPers(tablero1, 'Y', 1);
        rellenarTableroPers(tablero1, 'D', 5);
        rellenarTableroPers(tablero1, 'M', 5);
        rellenarTableroPers(tablero2, 'V', 1);
        rellenarTableroPers(tablero2, 'R', 5);
        rellenarTableroPers(tablero2, 'M', 5);
        System.out.println("Tablero 1:");
        imprimirTablero(tablero1);
        System.out.println();
        System.out.println("Tablero 2:");
        imprimirTablero(tablero2);
    }

    public static void main(String[] args) {
        rellenar();
        System.out.println();
        movimientoAleatorio(tablero1);
        imprimirTablero(tablero1);
    }
}