package nieliniowe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fx fx = new Fx();
        System.out.print("a = ");
        double a = sc.nextDouble();
        System.out.print("b = ");
        double b = sc.nextDouble();
        System.out.print("e = ");
        double e = sc.nextDouble();
        System.out.println();

        Bisekcji bis = new Bisekcji(a, b, e);
        bis.oblicz();
        System.out.printf("Wynik Bisekcji: %f\nWartosc funkcji: %f\nLiczba iteracji: %d\n\n", bis.result, fx.f(bis.result), bis.n);

        Stycznych sty = new Stycznych(a, b, e);
        sty.oblicz();
        System.out.printf("Wynik Stycznych: %f\nWartosc funkcji: %f\nLiczba iteracji: %d\n\n", sty.result, fx.f(sty.result), sty.n);

        Siecznych sie = new Siecznych(a, b, e);
        sie.oblicz();
        System.out.printf("Wynik Siecznych: %f\nWartosc funkcji: %f\nLiczba iteracji: %d\n\n", sie.result, fx.f(sie.result), sie.n);
    }
}