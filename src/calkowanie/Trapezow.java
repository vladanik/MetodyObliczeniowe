package calkowanie;

public class Trapezow implements Calki {
    private double a;
    private double b;
    private int n;
    private double h;
    private double[] x;
    public double result;

    public Trapezow(double a, double b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;

        h = (b - a) / n;

        x = new double[n];
        x[0] = a;
        x[n - 1] = b;

        for (int i = 1; i < n - 1; i++) {
            x[i] = a + (((double) i / n) * (b - a));
            x[i] = Double.parseDouble(String.format("%.4f", x[i])
                    .replace(',', '.'));
            System.out.println("x[" + i + "] = " + x[i]);
        }
        System.out.println();
    }

    private double f(double x) {
        return Math.sqrt((1.4 * x) + 0.2) / Math.cos((0.1 * Math.pow(x, 2)) + 2.1);
    }

    @Override
    public void oblicz() {
        double sum = 0;
        for (int i = 1; i < n; i++) {
            System.out.println("f(" + x[i] + ") = " + f(x[i]));
            sum += f(x[i]);
        }
        sum += (f(a) + f(b)) / 2;
        System.out.println();
        result = h * sum;
    }
}
