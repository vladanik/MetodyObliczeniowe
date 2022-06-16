package aproksymacja;

import calkowanie.Trapezow;

public class SrednioKw {
    private double a;
    private double b;
    private double x;
    private int n;
    private double[][] A;
    private double[] av;
    private double[] bv;
    private double px = 1;
    private CalkaTrapezow g;
    public double w;

    public SrednioKw(double a, double b, double x, int n) {
        this.a = a;
        this.b = b;
        this.x = x;
        this.n = n;

        A = new double[n + 1][n + 1];
        bv = new double[n + 1];
        g = new CalkaTrapezow(a, b, 16);

        System.out.println("Aproksymacja sredniokwadratowa ciagla:\n");

        System.out.println("A:");
        AMatrix(n);

        System.out.println("b:");
        bMatrix(n);

        av = new Gauss(A, bv).result;
        System.out.println("a:");
        aMatrix(av);
    }

    private void AMatrix(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                A[i][j] = g.oblicz(i, j, px);
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void bMatrix(int n) {
        for (int i = 0; i <= n; i++) {
            bv[i] = g.oblicz(i, px);
            System.out.println("b[" + i + "] = " + bv[i]);
        }
        System.out.println();
    }

    private void aMatrix(double[] a) {
        for (double r : a) {
            System.out.print(r + " \t");
        }
        System.out.println("\n");
    }

    public void oblicz() {
        for (int i = 0; i <= n; i++) {
            w += av[i] * Math.pow(x, i);
        }
    }
}