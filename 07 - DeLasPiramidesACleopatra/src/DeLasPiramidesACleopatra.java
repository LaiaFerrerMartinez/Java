import java.util.Scanner;
import java.lang.Math;

public class DeLasPiramidesACleopatra {
    private static final int MAX_NUM = 3;

    private static final int MIN_FECHA = -10000; // Como no hay 0, todos los números negativos se suman 1

    private static final int MAX_FECHA = 10000;

    private static int vector[] = new int [MAX_NUM];

    private static void leerNum () {
        Scanner lector = new Scanner(System.in);
        System.out.println("Dime tres años.");
        int num;
        for (int i = 0; i < MAX_NUM; i++) {
            num = lector.nextInt();
            if ((num < MIN_FECHA) || (num > MAX_FECHA)) {
                System.out.println("El año debe ser mayor que -10000 y menor que 10000.");
                num = lector.nextInt();
            }
            vector[i] = num;
        }
    }

    private static void ordenarNum () {
        boolean intercambiados;
        int aux;
        do {
            intercambiados = false;
            for (int i = 0; i < MAX_NUM-1; i++) {
                if (vector [i] > vector [i + 1]) {
                    aux = vector [i];
                    vector [i] = vector [i + 1];
                    vector [i + 1] = aux;
                    intercambiados = true;
                }
            }
        } while (intercambiados);
    }

    // Como no existe el año 0, a todos los números negativos les sumo 1
    private static void comprobarNegativos () {
        for (int i = 0; i < MAX_NUM; i++) {
            if (vector[i] < 0) {
                vector[i]++;
            }
        }
    }

    private static void compararNum () {
        int difNumMenor = Math.abs(vector[1] - vector[0]);
        int difNumMayor = Math.abs(vector[2] - vector[1]);
        if (difNumMayor < difNumMenor) {
            System.out.println(vector[2]);
        } else if (difNumMenor < difNumMayor) {
            System.out.println(vector [0] - 1);
        } else {
            System.out.println("EMPATE");
        }
    }

    private static void proceso () {
        leerNum();
        ordenarNum();
        comprobarNegativos();
        compararNum();
    }

    private static void jugar () {
        System.out.println("Dime el número de casos que quieras procesar.");
        Scanner lector = new Scanner(System.in);
        int casos = lector.nextInt();
        for (int i = 0; i < casos; i++) {
            System.out.println("Caso " + (i + 1));
            proceso();
        }
    }

    public static void main(String[] args) {
        jugar();
    }
}