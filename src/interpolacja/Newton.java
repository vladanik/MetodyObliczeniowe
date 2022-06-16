package interpolacja;

public class Newton {
    private final double[] xv;
    private double[][] f;
    private final double x;
    private final int size;
    private double w = 0;
    public double result;

    public Newton(double[] xv, double[][] f, double x, int size) {
        this.xv = xv;
        this.f = f;
        this.x = x;
        this.size = size;
    }

    private void iloraz() {
        int size = xv.length;
        for (int i = 1; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (i == 1) {
                    f[j][i] = (f[j][i-1] - f[j-1][i-1]) / (xv[j] - xv[j-1]);
                } else {
                    f[j][i] = (f[j][i-1] - f[j-1][i-1]) / (xv[j] - xv[j-i]);
                }
            }
        }
    }

    public void oblicz() {
        iloraz();
        interpNewt();
    }

    private void interpNewt() {
        w += f[0][0];
        for (int i = 1; i < size; i++) {
            double t = 1;
            for (int j = 0; j < i; j++) {
                t *= (x - xv[j]);
            }
            t *= f[i][i];
            w += t;
        }
        result = w;
    }
}
