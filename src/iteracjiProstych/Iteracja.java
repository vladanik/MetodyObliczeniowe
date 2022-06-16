package iteracjiProstych;

public class Iteracja {
    private double[][] a;
    private double[] b;
    private double[][] x;
    private double[] g;
    private double[][] h;
    private double e;
    private boolean bool1;
    private boolean bool2;
    private int size;
    public int n = 0;
    public double[] result;

    public Iteracja(int size, double[][] a, double[] b, double e) {
        this.size = size;
        this.a = a;
        this.b = b;
        this.e = e;

        x = new double[1000][size];
        g = new double[size];
        h = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j)
                    h[i][j] = 0;
                else {
                    h[i][j] = -(a[i][j] / a[i][i]);
                }
            }
            g[i] = b[i] / a[i][i];
        }
    }

    private double xn(double gn, double[] hn, double[] x) {
        double xn = gn;
        for (int i = 0; i < size; i++) {
            xn +=  hn[i] * x[i];
        }
        return xn;
    }

    public void oblicz() {
        for (int i = 0; i < size; i++) {
            x[0][i] = 0;
        }
        for (int k = 1; k < 1000; k++) {
            n++;
            if (k != 1){
                for (int j = 0; j < size - 1; j++) {
                    bool1 = mniej(x[k - 1][j], x[k - 1][j + 1]);
                    if (!bool1) break;
                }
                if (bool1) {
                    result = x[k - 1]; 
                    return;
                }       
            }
            for (int i = 0; i < size; i++) {
                x[k][i] = xn(g[i], h[i], x[k - 1]);
            }
            for (int i = 0; i < size; i++) {
                bool1 = powtorzenie(x[k][i], x[k - 1][i]);
                if (!bool1) break;
            }
            if (bool1) {
                result = x[k];
                return;
            }
        }
        result = x[999];
    }

    private boolean mniej(double a, double b) {
        return Math.abs(a - b) < e;
    }

    private boolean powtorzenie(double a, double b) {
        return a == b;
    }
}
