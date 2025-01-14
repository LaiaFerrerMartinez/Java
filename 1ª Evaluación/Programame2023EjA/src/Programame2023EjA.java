import java.util.Scanner;
public class Programame2023EjA {
    private static int MAX_FILA = 0;
    private static int vector [];
    private static void rellenarVector () {
        Scanner lector = new Scanner(System.in);
        System.out.println("Dame el número de casos de prueba.");
        MAX_FILA = lector.nextInt();
        int vector [] = new int[MAX_FILA];
        for (int i = 0; i < MAX_FILA; i++) {
            System.out.println("Dime el primer año.");
            int num = lector.nextInt();
            vector [i] = num;

        }
        for (int i = 0; i < MAX_FILA; i++) {
            int vector [MAX_FILA];
            System.out.println(vector[i]);
        }
    }

   private static void imprimirVector () {
        for (int i = 0; i < MAX_FILA; i++) {
            System.out.println(vector[i]);
        }
    }

    private static void ordenarVector () {
        int cont = 0;
        do {
            for (int i = 0; i < MAX_FILA - 1; i++) {
                if (vector [i] > vector [i + 1]) {
                    int aux;
                    aux = vector [i];
                    vector [i] = vector [i + 1];
                    vector [i + 1] = aux;
                }
            }
            cont++;
        } while (cont < MAX_FILA);
    }

    public static void main(String[] args) {
        rellenarVector ();
        imprimirVector();
        ordenarVector();
        imprimirVector();
    }
}
