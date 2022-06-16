package interpolacja;

public class Lagrunge {
    private final double[] xv;
    private double[] f;
    private final double x;
    private final int size;
    public double result;

    public Lagrunge(double[] xv, double[] f, double x, int size) {
            this.xv = xv;
            this.f = f;
            this.x = x;
            this.size = size;
    }

    public void interp() {
        int size = xv.length;
        double sum = 0;
        for (int i = 0; i < size; i++) {
            double ip = 1;
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    ip *= (x - xv[j]) / (xv[i] - xv[j]);
                }
            }
            sum += f[i] * ip;
        }
        result = sum;
    }
}
