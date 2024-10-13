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
    private static void asignarPersonajesACasillaLibre(char caracter, int numRepeticiones) {
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
        Scanner lector = new Scanner(System.in);
        int vidas = 10;
        do {
            System.out.println("Dime el desplazamiento que quieres realizar");
            System.out.println("WASD");
            String desplazamiento = lector.nextLine();
            switch (desplazamiento) {
                case "A":
                    if ((columnaBart - 1) >= 0) {
                        columnaBart = columnaBart - 1;
                        switch (tablero[filaBart][columnaBart]) {
                            case 'H':
                                vidas = vidas - 1;
                                System.out.println("Has perdido una vida. Te quedan " + vidas + " vidas.");
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart][columnaBart + 1] = 'L';
                                break;
                            case 'L':
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart][columnaBart + 1] = 'L';
                                break;
                            case 'M':
                                System.out.println("El muro no te deja desplazarte a esta casilla.");
                                columnaBart = columnaBart + 1;
                                break;
                            case 'F':
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart][columnaBart + 1] = 'L';
                                vidas = -1;
                                break;
                        }
                    } else {
                        System.out.println("Desplazamiento prohibido. Límite de tablero");
                    }
                    break;
                case "S":
                    if ((filaBart + 1) <= 9) {
                        filaBart = filaBart + 1;
                        switch (tablero[filaBart][columnaBart]) {
                            case 'H':
                                vidas = vidas - 1;
                                System.out.println("Has perdido una vida. Te quedan " + vidas + " vidas.");
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart - 1][columnaBart] = 'L';
                                break;
                            case 'L':
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart - 1][columnaBart] = 'L';
                                break;
                            case 'M':
                                System.out.println("El muro no te deja desplazarte a esta casilla.");
                                filaBart = filaBart - 1;
                                break;
                            case 'F':
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart - 1][columnaBart] = 'L';
                                vidas = -1;
                                break;
                        }
                    } else {
                        System.out.println("Desplazamiento prohibido. Límite de tablero");
                    }
                    break;
                case "D":
                    if ((columnaBart + 1) <= 9) {
                        columnaBart = columnaBart + 1;
                        switch (tablero[filaBart][columnaBart]) {
                            case 'H':
                                vidas = vidas - 1;
                                System.out.println("Has perdido una vida. Te quedan " + vidas + " vidas.");
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart][columnaBart - 1] = 'L';
                                break;
                            case 'L':
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart][columnaBart - 1] = 'L';
                                break;
                            case 'M':
                                System.out.println("El muro no te deja desplazarte a esta casilla.");
                                columnaBart = columnaBart - 1;
                                break;
                            case 'F':
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart][columnaBart - 1] = 'L';
                                vidas = -1;
                                break;
                        }
                    } else {
                        System.out.println("Desplazamiento prohibido. Límite de tablero");
                    }
                    break;
                case "W":
                    if ((filaBart - 1) >= 0) {
                        filaBart = filaBart - 1;
                        switch (tablero[filaBart][columnaBart]) {
                            case 'H':
                                vidas = vidas - 1;
                                System.out.println("Has perdido una vida. Te quedan " + vidas + " vidas.");
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart + 1][columnaBart] = 'L';
                                break;
                            case 'L':
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart + 1][columnaBart] = 'L';
                                break;
                            case 'M':
                                System.out.println("El muro no te deja desplazarte a esta casilla.");
                                filaBart = filaBart + 1;
                                break;
                            case 'F':
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart + 1][columnaBart] = 'L';
                                vidas = -1;
                                break;
                        }
                    } else {
                        System.out.println("Desplazamiento prohibido. Límite de tablero");
                    }
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
}
