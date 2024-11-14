import java.util.Scanner;

public class CociendoHuevos {
    public static void main(String[] args) {
        while (true) {
            Scanner lector = new Scanner(System.in);
            int huevos;
            int capacidad;
            int tiempo = 0;
            do{
                huevos = lector.nextInt();
            } while (huevos < 0 && huevos >= 10000);
            do{
                capacidad = lector.nextInt();
            } while (capacidad < 0 && capacidad >= 10000);
            if (huevos == 0 && capacidad == 0) break;
            do {
                huevos -= capacidad;
                tiempo += 10;
            } while (huevos > 0);
            System.out.println(tiempo);
        }
    }
}