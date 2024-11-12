//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 5;
        int c = 8;

        a = b++ + ++c;
        // a = 14 porque b se suma 1, y luego sumas c
    }
}