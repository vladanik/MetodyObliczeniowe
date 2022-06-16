package aproksymacja;

public class MNK {
    private double a;
    private double b;
    private double x;
    private double[] xv = {-1, -0.5, 0, 0.5, 1};
    private double[] yv = new double[xv.length];
//    private double[] xv = {1, 2, 3, 4};
//    private double[] yv = {6, 19, 40, 69};
    private int n;
    private int m;
    private double[][] S;
    private double[] T;
    private double[] av;
    public double w = 0;

    public MNK(double a, double b, double x, int n, int m) {
        this.a = a;
        this.b = b;
        this.x = x;
        this.n = n;
        this.m = m;

        for (int i = 0; i < xv.length; i++) {
            yv[i] = Math.sqrt(Math.pow(xv[i], 3) + (3 * Math.pow(xv[i], 2)) + 1);
        }

        S = new double[m + 1][m + 1];
        T = new double[m + 1];

        System.out.println("Aproksymacja MNK:\n");

        System.out.println("S:");
        sMatrix(n, m);

        System.out.println("T:");
        tMatrix(n, m);

        av = new Gauss(S, T).result;
        System.out.println("a:");
        aMatrix(av);
    }

    private void sMatrix(int n, int m) {
        for (int k = 0; k <= m; k++) {
            for (int j = 0; j <= m; j++) {
                S[k][j] = 0;
                for (int i = 0; i < n; i++) {
                    S[k][j] += Math.pow(xv[i], k + j);
                }
                System.out.print(S[k][j] + " \t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void tMatrix(int n, int m) {
        for (int k = 0; k <= m; k++) {
            T[k] = 0;
            for (int i = 0; i < n; i++) {
                T[k] += Math.pow(xv[i], k) * yv[i];
            }
            System.out.print(T[k] + " \t");
        }
        System.out.println("\n");
    }

    private void aMatrix(double[] a) {
        for (double r : a) {
            System.out.print(r + " \t");
        }
        System.out.println("\n");
    }

    public void oblicz() {
        for (int i = 0; i <= m; i++) {
            w += av[i] * Math.pow(x, i);
        }
    }
}
