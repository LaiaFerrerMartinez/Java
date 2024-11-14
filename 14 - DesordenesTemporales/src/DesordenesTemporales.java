import java.util.Scanner;

public class DesordenesTemporales {
    public static void main(String[] args) {
        int numPersonas;
        while (true) {
            Scanner lector = new Scanner(System.in);
            numPersonas = lector.nextInt();
            if (numPersonas == 0) break;
            int[] arrayEdad = new int[numPersonas];
            for (int i = 0; i < numPersonas; i++) {
                int edad = lector.nextInt();
                arrayEdad[i] = edad;
            }
            int desordenTotal = 0;
            int cont = 0;
            int aux;
            do {
                for (int i = 0; i < numPersonas - 1; i++) {
                    if (arrayEdad[i] > arrayEdad [i + 1]) {
                        aux = arrayEdad[i];
                        arrayEdad[i] = arrayEdad[i + 1];
                        arrayEdad[i + 1] = aux;
                        desordenTotal++;
                    }
                }
                cont++;
            } while (cont < numPersonas);
            System.out.println(desordenTotal);
        }
    }
}