import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Wybierz dzial:");
        System.out.println("1. Interpolacja");
        System.out.println("2. Calkowanie (calka z sqrt((1.4 * x) + 0.2) / cos((0.1 * pow(x, 2)) + 2.1))");
        System.out.println("3. Aproksymacja (sqrt(pow(x, 3) + (3 * pow(x, 2)) + 1))");
        System.out.println("4. Rownania nieliniowe (12.0 * pow(x, 2) - 6.0 * x - 32.0)");
        System.out.println("5. Metoda Iteracji Prostych");
        System.out.println("------------------------------------------------------------");

        System.out.print("Dzial: ");
        int d = new Scanner(System.in).nextInt();

        String[] a = new String[0];
        System.out.println("------------------------------------------------------------");

        switch (d) {
            case 1 -> new interpolacja.Main().main(a);
            case 2 -> new calkowanie.Main().main(a);
            case 3 -> new aproksymacja.Main().main(a);
            case 4 -> new nieliniowe.Main().main(a);
            case 5 -> new iteracjiProstych.Main().main(a);
            default -> System.out.println("Niepoprawna operacja :(");
        }
    }
}
