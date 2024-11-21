import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class CrearDosTableros {

    private static int MAX_FILA = 10;

    private static int MAX_COLUMNA = 10;

    private static char tablero1[][] = new char[MAX_FILA][MAX_COLUMNA];

    private static char tablero2[][] = new char[MAX_FILA][MAX_COLUMNA];

    private static char letras[] = {'W', 'A', 'S', 'D', 'Q', 'E', 'R', 'T'};

    private static int movimientos[][] = new int[8][2];

    private static int filaPers, colPers, vidas, filaYoda, colYoda, filaVader, colVader;

    private static int vidas1 = 3;

    private static int vidas2 = 3;

    //  Relleno el tablero correspondiente de casillas libres 'L'
    private static void rellenarTableroL (char[][] tablero) {
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                tablero[i][j] = 'L';
            }
        }
    }

    //  Imprimo el tablero correspondiente
    private static void imprimirTablero (char[][] tablero) {
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    //  Relleno el tablero correspondiente de los personajes correspondientes: 'Y', 'D', 'V', 'R' y 'M'
    private static void rellenarTableroPers (char[][] tablero, char pers, int num) {
        Random ale = new Random();
        int filaAl = -1;
        int colAl = -1;
        for (int i = 0; i < num; i++) {
            //  Genero una fila y una columna aleatoria hasta encontrar una casilla libre
            do {
                filaAl = ale.nextInt(MAX_FILA);
                colAl = ale.nextInt(MAX_COLUMNA);
            } while (tablero[filaAl][colAl] != 'L');
            //  Asigno esa fila y columna aleatoria al personaje correspondiente
            tablero[filaAl][colAl] = pers;
        }
        //  Si el personaje es 'Y' o 'V', guardo la fila y la columna porque la necesitaremos para el juego
        if (pers == 'Y') {
            filaYoda = filaAl;
            colYoda = colAl;
        } else if (pers == 'V') {
            filaVader = filaAl;
            colVader = colAl;
        }
    }

    //  Pongo la casilla final en el tablero correspondiente
    private static void rellenarTableroF (char[][] tablero) {
        tablero[MAX_FILA-1][MAX_COLUMNA-1] = 'F';
    }

    //  Un "malo" aleatorio se mueve de forma aleatoria a una casilla libre
    private static void movimientoAleatorio (char[][] tablero) {
        Random ale = new Random();
        char pers = 'L';
        //  Identifico cada "malo" según el tablero en el que estoy
        if (tablero == tablero1) {
            pers = 'D';
        } else if (tablero == tablero2) {
            pers = 'R';
        }
        int fila;
        int columna;
        //  Genero una fila y una columna aleatoria hasta encontrar un "malo"
        do {
            fila = ale.nextInt(MAX_FILA);
            columna = ale.nextInt(MAX_COLUMNA);
        } while (tablero[fila][columna] != pers);
        int filaNueva;
        int colNueva;
        //  Genero una fila y una columna aleatoria hasta encontrar una casilla libre
        do {
            filaNueva = ale.nextInt(MAX_FILA);
            colNueva = ale.nextInt(MAX_COLUMNA);
        } while (tablero[filaNueva][colNueva] != 'L');
        //  Asignas la fila nueva y la columna nueva al "malo"
        tablero[filaNueva][colNueva] = pers;
        //  La antigua fila y columna del "malo" se convierte en casilla libre
        tablero[fila][columna] = 'L';
    }

    //  Pido el movmiento y el número de casillas
    private static void desplazamiento (int filaPers, int colPers, char[][] tablero, char pers) {
        int filaCheck;
        int colCheck;
        int casillas;
        Scanner lector = new Scanner(System.in);

        //  Movimiento 'W': la fila se mueve hacia arriba
        movimientos [0][0] = -1;
        movimientos [0][1] = 0;

        // Movimiento 'A': la columna se mueve hacia la izquierda
        movimientos [1][0] = 0;
        movimientos [1][1] = -1;

        //  Movimiento 'S': la fila se mueve hacia abajo
        movimientos [2][0] = 1;
        movimientos [2][1] = 0;

        //  Movimiento 'D': la columna se mueve hacia la derecha
        movimientos [3][0] = 0;
        movimientos [3][1] = 1;

        //  Movimiento 'Q': la fila se mueve hacia arriba y la columna hacia la izquierda
        movimientos [4][0] = -1;
        movimientos [4][1] = -1;

        //  Movimiento 'E': la fila se mueve hacia arriba y la columna hacia la derecha
        movimientos [5][0] = -1;
        movimientos [5][1] = 1;

        //  Movimiento 'R': la fila se mueve hacia abajo y la columna hacia la izquierda
        movimientos [6][0] = 1;
        movimientos [6][1] = -1;

        //  Movimiento 'T': la fila se mueve hacia abajo y la columna hacia la derecha
        movimientos [7][0] = 1;
        movimientos [7][1] = 1;

        System.out.println("Dime el movimiento que quieres hacer.");
        System.out.println("Movimiento WASD y QERT: W = Arriba, A = Izquierda, S = Abajo, D = Derecha, Q = Diagonal izquierda arriba, " +
                "E = Diagonal derecha arriba, R = Diagonal izquierda abajo, T = Diagonal derecha abajo.");
        char direccion = lector.next().charAt(0);
        //  Pido el número de casillas mientras sea menor que 1 o mayor que 3
        do {
            System.out.println("Dime el número de casillas que te quieres mover.");
            casillas = lector.nextInt();
        } while (casillas < 1 || casillas > 3);

        int coordenada = -1;

        //  Recorro el vector letras para saber que movmiento tengo que hacer
        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == direccion) {
                coordenada = i;
            }
        }
        //  Asigno la fila a la que quiero ir a 'filaCheck'
        //  Asigno la columna a la que quiero ir a 'colCheck'
        filaCheck = filaPers + (movimientos[coordenada][0] * casillas);
        colCheck = colPers + (movimientos[coordenada][1] * casillas);
        //  Compruebo de qué tipo es la celda a la que quiero ir
        comprobarCelda(filaCheck, colCheck, tablero, pers);
    }

    //  Compruebo la celda a la que quiero ir
    private static void comprobarCelda (int filaCheck, int colCheck, char[][] tablero, char pers) {
        switch (tablero[filaCheck][colCheck]) {
            //  Si la celda es 'L', intercambio las celdas
            case 'L':
                tablero[filaCheck][colCheck] = pers;
                tablero[filaPers][colPers] = 'L';
                filaPers = filaCheck;
                colPers = colCheck;
                break;
            //  Si la celda es 'M', no me muevo
            case 'M':
                break;
            //  Si la celda es 'D' o 'R', intercambio las celdas y pierdo una vida
            case 'D', 'R':
                tablero[filaCheck][colCheck] = pers;
                tablero[filaPers][colPers] = 'L';
                filaPers = filaCheck;
                colPers = colCheck;
                vidas--;
                System.out.println("Te quedan " + vidas + " vidas.");
                break;
            //  Si la celda es 'F', he ganado y paro el programa
            case 'F':
                tablero[filaCheck][colCheck] = pers;
                tablero[filaPers][colPers] = 'L';
                filaPers = filaCheck;
                colPers = filaCheck;
                System.out.println("Has ganado!!!!");
                vidas = -1;
                break;
        }
    }

    private static void rellenar () {
        rellenarTableroL(tablero1);
        rellenarTableroL(tablero2);
        rellenarTableroPers(tablero1, 'Y', 1);
        rellenarTableroPers(tablero1, 'D', 5);
        rellenarTableroPers(tablero1, 'M', 5);
        rellenarTableroF(tablero1);
        rellenarTableroPers(tablero2, 'V', 1);
        rellenarTableroPers(tablero2, 'R', 5);
        rellenarTableroPers(tablero2, 'M', 5);
        rellenarTableroF(tablero2);
        System.out.println("Tablero 1:");
        imprimirTablero(tablero1);
        System.out.println();
        System.out.println("Tablero 2:");
        imprimirTablero(tablero2);
    }

    private static void juego () {
        int jugador = 1;
        do {
            switch (jugador) {
                case 1:
                    System.out.println("Jugador 1");
                    imprimirTablero(tablero1);
                    vidas = vidas1;
                    filaPers = filaYoda;
                    colPers = colYoda;
                    desplazamiento(filaPers, colPers, tablero1, 'Y');
                    vidas1 = vidas;
                    filaYoda = filaPers;
                    colYoda = colPers;
                    movimientoAleatorio(tablero1);
                    imprimirTablero(tablero1);
                    jugador = 2;
                    break;
                case 2:
                    System.out.println("Jugador 2");
                    imprimirTablero(tablero2);
                    vidas = vidas2;
                    filaPers = filaVader;
                    colPers = colVader;
                    desplazamiento(filaPers, colPers, tablero2, 'V');
                    vidas2 = vidas;
                    filaVader = filaPers;
                    colVader = colPers;
                    movimientoAleatorio(tablero2);
                    imprimirTablero(tablero2);
                    jugador = 1;
                    break;
            }
            System.out.println();
        } while (vidas > 0);
        if (vidas == 0) {
            System.out.println("Has perdido!!!");
        }
    }

    public static void main(String[] args) {
        rellenar();
        System.out.println();
        juego();
    }
}