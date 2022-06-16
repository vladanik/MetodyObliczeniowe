package calkowanie;

public class Simpsona {
    private double n;
    private double a;
    private double b;
    private double h;
    public double result;

    public Simpsona(double a, double b, double n){
        this.a = a;
        this.b = b;
        this.n = n;
        h = ((b + 2 / n * (b - a)) - (b + 1 / n * (b - a))) / 2;
    }

    private double f(double x){
        return Math.sqrt((1.4 * x) + 0.2) / Math.cos((0.1 * Math.pow(x, 2)) + 2.1);
    }

    public void oblicz() {
        double calka = 0;
        double xi = 0;
        double ti = 0;
        double tSum = 0;
        double xSum = 0;

        for (int i = 0; i < n; i++) {
            xi = a + (i / n) * (b - a);
            ti = ((a + ((i + 1) / n) * (b - a)) + (a + (i / n) * (b - a))) / 2;
            if (i == 0) {
                tSum += f(ti);
            }
            else {
                tSum += f(ti);
                xSum += f(xi);
            }
        }

        calka += 4 * tSum;
        calka += 2 * xSum;
        calka += f(a) + f(b);
        calka *= h / 3;

        result = calka;
    }
}
