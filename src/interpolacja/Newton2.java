package interpolacja;

public class Newton2 {
    private final double[] xv;
    private double[] f;
    private final double x;
    private final int size;
    private double h;
    public double result;

    public Newton2(double[] xv, double[] f, double x, int size) {
        this.xv = xv;
        this.f = f;
        this.x = x;
        this.size = size;

        h = Math.abs(xv[1] - xv[0]);
    }

    public boolean sprawdzH() {
        for (int i = 1; i < size - 1; i++) {
            if (Math.abs(xv[i] - xv[i + 1]) != h)
                return false;
        }
        return true;
    }

    private double iloraz(double[] f, int i) {
        return f[i + 1] - f[i];
    }

    private int factorial(int i) {
        if (i < 1)
            return 1;
        else
            return i * factorial(i - 1);
    }

    public void oblicz() {
        int temp = 1;
        double w0 = 1;
        double[] w1 = new double[size - 1];
        double[] w2 = new double[size - 1];
        double[] w3 = new double[size - 1];
        double wynik = 0;

        for (int i = 0; i < size - 1; i++) {
            w1[i] = iloraz(f, i);
            w3[0] = w1[0];
        }
        for (int i = 2; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                w2[j] = iloraz(w1, j);
                if (j == 0){
                    w3[temp] = w2[j];
                    temp++;
                }
            }
            for (int j = 0; j < w1.length; j++) {
                w1[j] = w2[j];
            }
        }

        for (int i = 0; i < size - 1; i++){
            if (i == 0){
                wynik += f[i] + (w3[i] * (x - xv[i])) / (factorial(i + 1) * Math.pow(h, i + 1));
            } else {
                for (int j = 0; j < i + 1; j++) {
                    w0 *= x - xv[j];
                    if (j == i) {
                        w0 *= w3[j] / (Math.pow(h, j + 1) * factorial(j + 1));
                        wynik += w0;
                        w0 = 1;
                    }
                }
            }
        }
        result = wynik;
    }
}
