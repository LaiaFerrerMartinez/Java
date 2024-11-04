import java.util.Scanner;

public class CodigoDeBarras {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in); // Usar Scanner para la entrada
        while (true) {
            String codigo = lector.nextLine(); // Leer entrada con Scanner
            if (codigo.equals("0")) break;

            // Rellenar con ceros a la izquierda si es necesario
            if (codigo.length() < 8) {
                codigo = String.format("%08d", Integer.parseInt(codigo));
            } else if (codigo.length() > 8 && codigo.length() < 13) {
                codigo = String.format("%013d", Integer.parseInt(codigo));
            }

            if (codigo.length() == 8) {
                if (EAN8(codigo)) {
                    System.out.println("SI");
                } else {
                    System.out.println("NO");
                }
            } else if (codigo.length() == 13) {
                if (EAN13(codigo)) {
                    String countryPrefix = getCountryPrefix(codigo);
                    String country = getCountry(countryPrefix);
                    System.out.println("SI " + country);
                } else {
                    System.out.println("NO");
                }
            }
        }
        lector.close(); // Cerrar el Scanner al finalizar
    }

    private static boolean EAN8 (String code) {
        int suma = 0;
        for (int i = 0; i < 7; i++) {
            int num = Character.getNumericValue(code.charAt(i));
            if (i % 2 == 0) {
                suma += num * 3; // Si el índice es par, multiplicamos el dígito por 3
            } else {
                suma += num; // Si el índice es impar, simplemente sumamos el dígito
            }
        }
        int num = (10 - (suma % 10)) % 10;
        return num == Character.getNumericValue(code.charAt(7));
    }

    private static boolean EAN13 (String code) {
        int suma = 0;
        for (int i = 0; i < 12; i++) {
            int num = Character.getNumericValue(code.charAt(i));
            suma += (i % 2 == 0) ? num : num * 3;
        }
        int num = (10 - (suma % 10)) % 10;
        return num == Character.getNumericValue(code.charAt(12));
    }

    private static String getCountryPrefix(String code) {
        if (code.startsWith("0")) return "0";
        for (String prefix : new String[]{"380", "50", "539", "560", "70", "759", "850", "890"}) {
            if (code.startsWith(prefix)) {
                return prefix;
            }
        }
        return "";
    }

    private static String getCountry(String prefix) {
        switch (prefix) {
            case "0":
                return "EEUU";
            case "380":
                return "Bulgaria";
            case "50":
                return "Inglaterra";
            case "539":
                return "Irlanda";
            case "560":
                return "Portugal";
            case "70":
                return "Noruega";
            case "759":
                return "Venezuela";
            case "850":
                return "Cuba";
            case "890":
                return "India";
            default:
                return "Desconocido";
        }
    }
}
