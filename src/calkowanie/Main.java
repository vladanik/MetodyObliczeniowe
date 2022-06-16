package calkowanie;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Double> n2weight = new ArrayList<>(2);
        List<Double> n2absciss = new ArrayList<>(2);
        List<Double> n4weight = new ArrayList<>(4);
        List<Double> n4absciss = new ArrayList<>(4);
        List<Double> n6weight = new ArrayList<>(6);
        List<Double> n6absciss = new ArrayList<>(6);
        List<Double> n8weight = new ArrayList<>(8);
        List<Double> n8absciss = new ArrayList<>(8);
        List<Double> n10weight = new ArrayList<>(10);
        List<Double> n10absciss = new ArrayList<>(10);
        List<Double> n16weight = new ArrayList<>(16);
        List<Double> n16absciss = new ArrayList<>(16);
        double a;
        double b;
        int n;

        Scanner scanner = new Scanner(System.in);
        System.out.print("a = ");
        a = scanner.nextDouble();
        System.out.print("b = ");
        b = scanner.nextDouble();
        System.out.print("n = ");
        n = scanner.nextInt();

        System.out.println();

        Trapezow t = new Trapezow(a, b, n);
        t.oblicz();
        System.out.println("Wynik za pomoca metody trapezow: " + t.result);

        Simpsona s = new Simpsona(a, b, n);
        s.oblicz();
        System.out.println("Wynik za pomoca metody Simpsona: " + s.result);

        GaussaLegendrea g = new GaussaLegendrea(n2weight, n2absciss, n4weight, n4absciss,
                n6weight, n6absciss, n8weight, n8absciss,
                n10weight, n10absciss, n16weight, n16absciss,
                a, b, n);
        g.oblicz();
        System.out.println("Wynik za pomoca metody Gaussa-Legendrea: " + g.result);
    }
}
