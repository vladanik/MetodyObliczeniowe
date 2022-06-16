package aproksymacja;

public class CalkaTrapezow {
    private double a;
    private double b;
    private int n;
    private double h;
    private double[] x;
    public double result;

    public CalkaTrapezow(double a, double b, int n) {
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
        }
    }

    private double f(double i, double px, double x) {
        //return Math.pow(x, i) * Math.sqrt(Math.pow(x, 3) + 3 * Math.pow(x, 2) + 1) * px;
        return Math.pow(x, i) * Math.sqrt(6 * x * x * x + 9) * px;
    }

    private double f(double i, double j, double px, double x) {
        return Math.pow(x, i) * Math.pow(x, j) * px;
    }

    public double oblicz(double ii, double px) {
        double sum = 0;
        for (int i = 1; i < n; i++) 
            sum += f(ii, px, x[i]);
        sum += (f(ii, px, a) + f(ii, px, b)) / 2;
        return h * sum;
    }

    public double oblicz(double ii, double jj, double px) {
        double sum = 0;
        for (int i = 1; i < n; i++)
            sum += f(ii, jj, px, x[i]);
        sum += (f(ii, jj, px, a) + f(ii, jj, px, b)) / 2;
        return h * sum;
    }
}
