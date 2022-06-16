package aproksymacja;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        int n = sc.nextInt();
        System.out.print("m = ");
        int m = sc.nextInt();
        System.out.print("a = ");
        double a = sc.nextDouble();
        System.out.print("b = ");
        double b = sc.nextDouble();
        System.out.print("x = ");
        double x = sc.nextDouble();
        System.out.println();

        double defaultResult = Math.sqrt(Math.pow(x, 3) + (3 * Math.pow(x, 2)) + 1);

        SrednioKw sKw = new SrednioKw(a, b, x, n);
        sKw.oblicz();

        WielomianyOrt wOrt = new WielomianyOrt(a, b, x, n);
        wOrt.oblicz();
        
        MNK mnk = new MNK(a, b, x, n, m);
        mnk.oblicz();

        System.out.println("Default result: " + defaultResult);
        System.out.println("Result with SrednioKw: " + sKw.w);
        System.out.println("Result with WielomianyOrt: " + wOrt.w);
        System.out.println("Result with MNK: " + mnk.w);
        System.out.println();
    }
}
