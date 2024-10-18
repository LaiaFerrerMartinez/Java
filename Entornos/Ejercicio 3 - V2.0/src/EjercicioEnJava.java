<import java.util.Random;
import java.util.Scanner;

public class EjercicioEnJava {

    public static void main(String[] args) {
        int [] vector = new int [100];
        boolean encontrado;
        Random r = new Random();
        do {
            vector [i] = r.nextInt(100);
            i++;
        } while (i < 100);
        System.out.println("Dime un número.");
        Scanner lector = new Scanner (System.in);
        int num = Integer.parseInt(lector.nextLine());
        encontrado = false;
        for (int i = 0; i < 100; i++) {
            if (vector[i] == num){
                encontrado = true;
                System.out.println("El número está en la posición " + i + ".");
            }
        }
        if (!encontrado) {
            System.out.println("El número no está en el vector.");
        }
    }
}
