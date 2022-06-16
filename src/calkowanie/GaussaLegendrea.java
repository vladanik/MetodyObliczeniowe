package calkowanie;

import java.util.List;
import java.lang.Math;

public class GaussaLegendrea extends NGL implements Calki {
    private double a;
    private double b;
    private int n;
    public double result;


    protected List<Double> nWeight;
    protected List<Double> nAbsciss;

    public GaussaLegendrea(List<Double> n2weight, List<Double> n2absciss,
                           List<Double> n4weight, List<Double> n4absciss,
                           List<Double> n6weight, List<Double> n6absciss,
                           List<Double> n8weight, List<Double> n8absciss,
                           List<Double> n10weight, List<Double> n10absciss,
                           List<Double> n16weight, List<Double> n16absciss,
                           double a, double b, int n) {
        super(n2weight, n2absciss, n4weight, n4absciss,
                n6weight, n6absciss, n8weight, n8absciss,
                n10weight, n10absciss, n16weight, n16absciss);
        this.a = a;
        this.b = b;
        this.n = n;

        switch (n) {
            case 2 -> {
                nWeight = super.n2weight;
                nAbsciss = super.n2absciss;
            }
            case 4 -> {
                nWeight = super.n4weight;
                nAbsciss = super.n4absciss;
            }
            case 6 -> {
                nWeight = super.n6weight;
                nAbsciss = super.n6absciss;
            }
            case 8 -> {
                nWeight = super.n8weight;
                nAbsciss = super.n8absciss;
            }
            case 10 -> {
                nWeight = super.n10weight;
                nAbsciss = super.n10absciss;
            }
            case 16 -> {
                nWeight = super.n16weight;
                nAbsciss = super.n16absciss;
            }
            default -> throw new IllegalStateException("Unexpected value: " + n);
        }
    }

    @Override
    public void oblicz() {
        double ba2 = (b - a) / 2;
        double sum = 0;
        double[] w = new double[n];
        double[] x = new double[n];
        double[] f = new double[n];

        for (int i = 0; i < n; i++) {
            w[i] = nWeight.get(i);
            x[i] = (ba2 * nAbsciss.get(i)) + ((b + a) / 2);
            f[i] = Math.sqrt((1.4 * x[i]) + 0.2) / Math.cos((0.1 * Math.pow(x[i], 2)) + 2.1);

            sum += w[i] * f[i];
        }
        result = ba2 * sum;
    }
}
