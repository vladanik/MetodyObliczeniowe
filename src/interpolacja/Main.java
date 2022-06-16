package interpolacja;

import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Size: ");
        int n = scan.nextInt();

        double[] xv = new double[n];
        double[] f = new double[n];
        double[][] f1 = new double[n][n];
        double x;

        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "] = ");
            xv[i] = scan.nextDouble();

            System.out.print("f(" + xv[i] + ") = ");
            f[i] = scan.nextDouble();
            f1[i][0] = f[i];
        }

        System.out.print("x = ");
        x = scan.nextDouble();

//------------------------------------------PL FOR STUDIES-----------------------------------------------------------

        System.out.println("-----------------------------------------------------------------------------");

        Lagrunge lagrunge = new Lagrunge(xv, f, x, n);
        lagrunge.interp();
        System.out.println("Wynik za pomoca metody Lagrangea: " + lagrunge.result);

        Newton newton = new Newton(xv, f1, x, n);
        newton.oblicz();
        System.out.println("Wynik za pomoca metody Newtona z ilorazami roznicowymi: "
                + newton.result);

        Newton2 newton2 = new Newton2(xv, f, x, n);
        if (newton2.sprawdzH()) {
            newton2.oblicz();
            System.out.println("Wynik za pomoca metody Newtona z roznicami progresywnymi: "
                    + newton2.result);
        } else
            System.out.println("Za pomoca metody Newtona z roznicami progresywnymi niestety nie mozna " +
                    "bo zmienna h sie nie zgadza");

        System.out.println("-----------------------------------------------------------------------------");


//------------------------------------------EN FOR GITHUB-----------------------------------------------------------
//
//        System.out.println("-----------------------------------------------------------------------------");
//
//        Lagrunge lagrunge = new Lagrunge(xv, f, x, n);
//        lagrunge.interp();
//        System.out.println("Result with LaGrunge method: " + lagrunge.result);
//
//        Newton newton = new Newton(xv, f1, x, n);
//        newton.oblicz();
//        System.out.println("Result with Newton method with differential quotients: "
//                + newton.result);
//
//        Sklejane spline = new Sklejane(xv, f1, x, p, n);
//        spline.rozwiaz();
//        spline.oblicz();
//        System.out.println("Result with cubic spline method: "
//                + spline.result + " (incorrect a little bit)");
//
//        Newton2 newton2 = new Newton2(xv, f, x, n);
//        if (newton2.sprawdzH()) {
//            newton2.oblicz();
//            System.out.println("Result with Newton method with progressive differences: "
//                    + newton.result);
//        } else
//            System.out.println("You can't sovle this with Newton method with progressive differences" +
//                    "because a variable h changes sometimes");
//
//        System.out.println("-----------------------------------------------------------------------------");
    }
}
