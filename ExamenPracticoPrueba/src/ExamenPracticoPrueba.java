import java.util.Random;
import java.util.Scanner;

public class ExamenPracticoPrueba {

    private static final int MAX_FILA_TABLERO = 10;

    private static final int MAX_COLUMNA_TABLERO = 10;

    private static char [][] tableroJugador1 = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];

    private static char [][] tableroJugador2 = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];

    private static int filaPers, columnaPers,filaYoda, columnaYoda, filaVader, columnaVader;

    private static int filaComprobacion, columnaComprobacion;

    private static int vidas1 = 3;

    private static int vidas2 = 3;

    private static int vidas;

    private static int jugador;

    private static boolean ganar = false;

    // Relleno tablero con casillas libres
    private static void rellenarTablerosL () {
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                tableroJugador1 [i][j] = 'L';
                tableroJugador2 [i][j] = 'L';
            }
        }
    }

    // Coloco los personajes dependiendo del número de veces que hay que ponerlos en el tablero 1
    private static void colocarPersonajesTablero1 (char pers, int num) {
        Random aleatorio = new Random();
        int filaTablero1;
        int columnaTablero1;
        for (int i = 0; i < num; i++) {
            do {
                filaTablero1 = aleatorio.nextInt(9);
                columnaTablero1 = aleatorio.nextInt(9);
            } while (tableroJugador1[filaTablero1][columnaTablero1] != 'L');
            tableroJugador1[filaTablero1][columnaTablero1] = pers;
            if (num==1) {
                filaYoda = filaTablero1;
                columnaYoda = columnaTablero1;
            }
        }
    }

    // Coloco los personajes dependiendo del número de veces que hay que ponerlos en el tablero 2
    private static void colocarPersonajesTablero2 (char pers, int num) {
        Random aleatorio = new Random();
        int filaTablero2;
        int columnaTablero2;
        for (int i = 0; i < num; i++) {
            do {
                filaTablero2 = aleatorio.nextInt(9);
                columnaTablero2 = aleatorio.nextInt(9);
            } while (tableroJugador2[filaTablero2][columnaTablero2] != 'L');
            tableroJugador2[filaTablero2][columnaTablero2] = pers;
            if (num==1) {
                filaVader = filaTablero2;
                columnaVader = columnaTablero2;
            }
        }
    }

    // Imprime el tablero que le pidas
    private static void imprimirTablero (char tablero[][]) {
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void desplazamiento (int fila, int columna) {
        char[][] tablero;
        if (jugador == 1) {
            tablero = tableroJugador1;
        } else {
            tablero = tableroJugador2;
        }
        switch (tablero[fila][columna]) {
            case 'L':
                filaPers = fila;
                columnaPers = columna;
                if (jugador == 1) {
                    tablero [filaYoda][columnaYoda] = 'L';
                } else {
                    tablero [filaVader][columnaVader] = 'L';
                }
                break;
            case 'D', 'R':
                filaPers = fila;
                columnaPers = columna;
                vidas --;
                System.out.println("Te quedan " + vidas1 + " vidas.");
                if (jugador == 1) {
                    tablero [filaYoda][columnaYoda] = 'L';
                } else {
                    tablero [filaVader][columnaVader] = 'L';
                }
                break;
            case 'M':
                System.out.println("El muro no te deja desplazarte.");
                break;
            case 'F':
                filaPers = fila;
                columnaPers = columna;
                System.out.println("El jugador " + jugador + "ha ganado.");
                ganar = true;
                break;
        }
    }

    private static void movD (int casillas) {
        if ((columnaPers + casillas) > MAX_COLUMNA_TABLERO) {
            columnaComprobacion = casillas - 1;
            desplazamiento (filaPers, columnaComprobacion);
        } else {
            columnaComprobacion = columnaPers + casillas;
            desplazamiento (filaPers, columnaComprobacion);
        }
    }

    private static void movA (int casillas) {
        if ((columnaPers - casillas) < 0) {
            columnaComprobacion = MAX_COLUMNA_TABLERO - casillas + 1;
            desplazamiento (filaPers, columnaComprobacion);
        } else {
            columnaComprobacion = columnaPers - casillas;
            desplazamiento(filaPers, columnaComprobacion);
        }
    }

    private static void movW (int casillas) {
        if ((filaPers - casillas) < 0) {
            filaComprobacion = MAX_FILA_TABLERO - casillas + 1;
            desplazamiento (filaComprobacion, columnaPers);
        } else {
            filaComprobacion = filaPers - casillas;
            desplazamiento(filaComprobacion, columnaPers);
        }
    }

    private static void movS (int casillas) {
        if ((filaPers + casillas) > MAX_FILA_TABLERO) {
            filaComprobacion = casillas - 1;
            desplazamiento (filaComprobacion, columnaPers);
        } else {
            filaComprobacion = filaPers + casillas;
            desplazamiento(filaComprobacion, columnaPers);
        }
    }

    private static void movQ (int casillas) {
        if ((filaPers - casillas) < 0 && (columnaPers - casillas) < 0) {
            filaComprobacion = MAX_FILA_TABLERO - casillas + 1;
            columnaComprobacion = MAX_COLUMNA_TABLERO - casillas + 1;
        }
        if ((filaPers - casillas) < 0) {
            filaComprobacion = MAX_FILA_TABLERO - casillas + 1;
            columnaComprobacion = columnaPers - casillas;
        }
        if ((columnaPers - casillas) < 0) {
            filaComprobacion = filaPers - casillas;
            columnaComprobacion = MAX_COLUMNA_TABLERO - casillas + 1;
        }
        if (((filaPers - casillas) >= 0) && ((columnaPers - casillas) >= 0)) {
            filaComprobacion = filaPers - casillas;
            columnaComprobacion = columnaPers - casillas;
        }
        desplazamiento(filaComprobacion, columnaComprobacion);
    }

    private static void movR (int casillas) {
        if ((filaPers - casillas) < 0 && (columnaPers + casillas) > MAX_COLUMNA_TABLERO) {
            filaComprobacion = MAX_FILA_TABLERO - casillas + 1;
            columnaComprobacion = casillas - 1;
        }
        if ((filaPers - casillas) < 0) {
            filaComprobacion = MAX_FILA_TABLERO - casillas + 1;
            columnaComprobacion = columnaPers + casillas;
        }
        if ((columnaPers + casillas) > MAX_COLUMNA_TABLERO) {
            filaComprobacion = filaPers - casillas;
            columnaComprobacion = casillas - 1;
        }
        if (((filaPers - casillas) >= 0) && ((columnaPers + casillas) >= 0)) {
            filaComprobacion = filaPers - casillas;
            columnaComprobacion = columnaPers + casillas;
        }
        desplazamiento(filaComprobacion, columnaComprobacion);
    }

    private static void movE (int casillas) {
        if ((filaPers + casillas) > MAX_FILA_TABLERO && (columnaPers - casillas) < 0) {
            filaComprobacion = casillas - 1;
            columnaComprobacion = MAX_COLUMNA_TABLERO - casillas + 1;
        }
        if ((filaPers + casillas) > MAX_FILA_TABLERO) {
            filaComprobacion = casillas - 1;
            columnaComprobacion = columnaPers - casillas;
        }
        if ((columnaYoda - casillas) < 0) {
            filaComprobacion = filaPers + casillas;
            columnaComprobacion = MAX_COLUMNA_TABLERO - casillas + 1;
        }
        if (((filaPers - casillas) >= 0) && ((columnaPers + casillas) >= 0)) {
            filaComprobacion = filaPers - casillas;
            columnaComprobacion = columnaPers + casillas;
        }
        desplazamiento(filaComprobacion, columnaComprobacion);
    }

    private static void movB (int casillas) {
        if ((filaPers + casillas) < MAX_FILA_TABLERO && (filaPers + casillas) < MAX_COLUMNA_TABLERO) {
            filaComprobacion = casillas - 1;
            columnaComprobacion = casillas - 1;
        }
        if ((filaPers + casillas) < MAX_FILA_TABLERO) {
            filaComprobacion = casillas - 1;
            columnaComprobacion = columnaPers + casillas;
        }
        if ((columnaPers + casillas) < MAX_COLUMNA_TABLERO) {
            filaComprobacion = filaPers + casillas;
            columnaComprobacion = casillas - 1;
        }
        if (((filaPers + casillas) >= 0) && ((columnaPers + casillas) >= 0)) {
            filaComprobacion = filaPers + casillas;
            columnaComprobacion = columnaPers + casillas;
        }
        desplazamiento(filaComprobacion, columnaComprobacion);
    }

    private static void movimientos () {
        Scanner lectorCas = new Scanner(System.in);

        // Pido el número de casillas
        int casillas;
        do {
            System.out.println("Dime el número de casillas que te quieres desplazar.");
            casillas = lectorCas.nextInt();
        } while (casillas > 3 && casillas <= 0);


        // Pido la direccion del desplazamiento
        Scanner lector = new Scanner(System.in);
        String direccion = lector.nextLine();
        switch (direccion) {
            case "D":
                movD(casillas);
                break;
            case "A":
                movA(casillas);
                break;
            case "W":
                movW(casillas);
                break;
            case "S":
                movS(casillas);
                break;
            case "Q":
                movQ(casillas);
                break;
            case "R":
                movR(casillas);
                break;
            case "E":
                movE(casillas);
                break;
            case "B":
                movB(casillas);
                break;
        }
    }

    private static void jugar () {
        System.out.println("Utiliza el teclado WASD y QREB.");
        System.out.println("D: derecha; A: izquierda; W: arriba; S: abajo; Q: diagonal izquierda y arriba; " +
                "R: diagonal derecha arriba; E: diagonal izquierda abajo; B: diagonal derecha abajo.");
        jugador = 1;
        do {
            switch (jugador) {
                case 1:
                    System.out.println("Jugador 1:");
                    imprimirTablero(tableroJugador1);
                    System.out.println();
                    vidas = vidas1;
                    filaPers = filaYoda;
                    columnaPers = columnaYoda;
                    movimientos();
                    tableroJugador1[filaPers][columnaPers] = 'Y';
                    imprimirTablero(tableroJugador1);
                    vidas1 = vidas;
                    filaYoda = filaPers;
                    columnaYoda = columnaPers;
                    break;
                case 2:
                    System.out.println("Jugador 2:");
                    imprimirTablero(tableroJugador2);
                    System.out.println();
                    vidas = vidas2;
                    filaPers = filaVader;
                    columnaPers = columnaVader;
                    movimientos();
                    tableroJugador2[filaPers][columnaPers] = 'V';
                    imprimirTablero(tableroJugador2);
                    filaVader = filaPers;
                    columnaVader = columnaPers;
                    vidas2 = vidas;
                    break;
            }
            if (jugador == 1) {
                jugador = 2;
            } else if (jugador == 2) {
                jugador = 1;
            }
            System.out.println();
        } while (vidas > 0 && ganar==false);
    }

    public static void main(String[] args) {
        rellenarTablerosL();
        colocarPersonajesTablero1('Y', 1);
        colocarPersonajesTablero1('D', 5);
        colocarPersonajesTablero1('M', 5);
        colocarPersonajesTablero2('V', 1);
        colocarPersonajesTablero2('R', 5);
        colocarPersonajesTablero2('M', 5);
        jugar();
    }
}