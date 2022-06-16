package aproksymacja;

public class WielomianyOrt {
    private double a;
    private double b;
    private double x;
    private int n;
    private int np;
    private double h;
    private double[] ws;
    private double px = 1;
    public double w = 0;

    public WielomianyOrt(double a, double b, double x, int n) {
        this.a = a;
        this.b = b;
        this.x = x;
        this.n = n;
        np = 100;
        h = ((b + 2.0 / np * (b - a)) - (b + 1.0 / np * (b - a))) / 2.0;
        ws = new double[n + 1];
    }

    private double f(double x) {
        return Math.sqrt(Math.pow(x, 3) + (3 * Math.pow(x, 2)) + 1);
    }

    private double wielomian2(int n, double x) {
        switch (n) {
            case 0 -> {
                return 1;
            }
            case 1 -> {
                return x;
            }
            case 2 -> {
                return (0.5 * (3 * x * x - 1));
            }
            case 3 -> {
                return ((0.5) * (5 * x * x * x - 3 * x));
            }
            case 4 -> {
                return (0.125) * (35 * Math.pow(x,4) - 30 * Math.pow(x,2) + 3);
            }
            case 5 -> {
                return (0.125) * (63 * Math.pow(x,5) - 70 * Math.pow(x,3) + 15 * x);
            }
            case 6 -> {
                return (0.0625) * (231 * Math.pow(x,6) - 315 * Math.pow(x,4) + 105 * Math.pow(x,2) - 5);
            }
            case 7 -> {
                return (0.0625) * (429 * Math.pow(x,7) - 693 * Math.pow(x,5) + 315 * Math.pow(x,3) - 35 * x);
            }
            case 8 -> {
                return  (0.0078125) * (6435 * Math.pow(x,8) - 12012 * Math.pow(x,6) + 6930 * Math.pow(x,4) - 
                        1260 * Math.pow(x,2) + 35);
            }
            case 9 -> {
                return  (0.0078125) * (12155 * Math.pow(x,9) - 25740 * Math.pow(x,7) + 18018 * Math.pow(x,5) - 
                        4620 * Math.pow(x,3) + 315 * x);
            }
            case 10 -> {
                return  (0.00390625) * (46189 * Math.pow(x,10) - 109395 * Math.pow(x,8) + 90090 * Math.pow(x,6) - 
                        30030 * Math.pow(x,4) + 3465 * Math.pow(x,2) - 63);
            }
            default -> {
                return 0;
            }
        }
    }

    private double wielomian(int n, double x) {
        switch (n) {
            case 0 -> {
                return f(x);
            }
            case 1 -> {
                return x * f(x);
            }
            case 2 -> {
                return (0.5 * (3 * x * x - 1)) * f(x);
            }
            case 3 -> {
                return ((0.5) * (5 * x * x * x - 3 * x)) * f(x);
            }
            case 4 -> {
                return (0.125) * (35 * Math.pow(x,4) - 30 * Math.pow(x,2) + 3) * f(x);
            }
            case 5 -> {
                return (0.125) * (63 * Math.pow(x,5) - 70 * Math.pow(x,3) + 15 * x) * f(x);
            }
            case 6 -> {
                return (0.0625) * (231 * Math.pow(x,6) - 315 * Math.pow(x,4) + 105 * Math.pow(x,2) - 5) * f(x);
            }
            case 7 -> {
                return (0.0625) * (429 * Math.pow(x,7) - 693 * Math.pow(x,5) + 315 * Math.pow(x,3) - 35 * x) * f(x);
            }
            case 8 -> {
                return  (0.0078125) * (6435 * Math.pow(x,8) - 12012 * Math.pow(x,6) + 6930 * Math.pow(x,4) - 
                        1260 * Math.pow(x,2) + 35) * f(x);
            }
            case 9 -> {
                return  (0.0078125) * (12155 * Math.pow(x,9) - 25740 * Math.pow(x,7) + 18018 * Math.pow(x,5) - 
                        4620 * Math.pow(x,3) + 315 * x) * f(x);
            }
            case 10 -> {
                return  (0.00390625) * (46189 * Math.pow(x,10) - 109395 * Math.pow(x,8) + 90090 * Math.pow(x,6) - 
                        30030 * Math.pow(x,4) + 3465 * Math.pow(x,2) - 63) * f(x);
            }
            default -> {
                return 0;
            }
        }
    }

    private double wielomianLambda(int n, double x) {
        switch (n) {
            case 0 -> {
                return 1;
            }
            case 1 -> {
                return Math.pow(x,2);
            }
            case 2 -> {
                return Math.pow(((0.5) * (3 * x * x - 1)),2);
            }
            case 3 -> {
                return Math.pow(((0.5) * (5 * x * x * x - 3 * x)),2);
            }
            case 4 -> {
                return Math.pow((0.125) * (35 * Math.pow(x,4) - 30 * Math.pow(x,2) + 3),2);
            }
            case 5 -> {
                return Math.pow((0.125) * (63 * Math.pow(x,5) - 70 * Math.pow(x,3) + 15 * x),2);
            }
            case 6 -> {
                return Math.pow((0.0625) * (231 * Math.pow(x,6) - 315 * Math.pow(x,4) + 105 * Math.pow(x,2) - 5) ,2);
            }
            case 7 -> {
                return Math.pow((0.0625) * (429 * Math.pow(x,7) - 693 * Math.pow(x,5) + 315 * Math.pow(x,3) - 35 * x),2);
            }
            case 8 -> {
                return Math.pow((0.0078125) * (6435 * Math.pow(x,8) - 12012 * Math.pow(x,6) + 6930 * Math.pow(x,4) - 
                        1260 * Math.pow(x,2) + 35),2);
            }
            case 9 -> {
                return Math.pow((0.0078125) * (12155 * Math.pow(x,9) - 25740 * Math.pow(x,7) + 18018 * Math.pow(x,5) - 
                        4620 * Math.pow(x,3) + 315 * x),2);
            }
            case 10 -> {
                return Math.pow((0.00390625) * (46189 * Math.pow(x,10) - 109395 * Math.pow(x,8) + 90090 * Math.pow(x,6) - 
                        30030 * Math.pow(x,4) + 3465 * Math.pow(x,2) - 63),2);
            }
            default -> {
                return 0;
            }
        }
    }

    private double calka(int num) {
        double xi = 0;
        double ti = 0;
        double xSum = 0;
        double tSum = 0;
        for (double i = 0; i < np; i += 1.0) {
            xi = a + (i / np) * (b - a);
            ti = ((a + ((i + 1.0) / np) * (b - a)) + (a + (i / np) * (b - a))) / 2;
            if (i == 0.0) 
                tSum += wielomian(num, ti);
            else {
                tSum += wielomian(num, ti);
                xSum += wielomian(num, xi);
            }
        }
        double res = wielomian(num, a) + 2 * xSum + 4 * tSum + wielomian(num, b);
        res *= h / 3;

        tSum = 0;
        xSum = 0;

        for (double i = 0; i < np; i += 1.0) {
            xi = a + (i / np) * (b - a);
            ti = ((a + ((i + 1.0) / np) * (b - a)) + (a + (i / np) * (b - a))) / 2;
            if (i == 0) 
                tSum += wielomianLambda(num, ti);
            else {
                tSum += wielomianLambda(num, ti);
                xSum += wielomianLambda(num, xi);
            }
        }
        double lambda = wielomianLambda(num, a) + 2 * xSum + 4 * tSum + wielomianLambda(num, b);
        lambda *= h / 3;

        res *= 1.0 / lambda;

        return res;
    }

    public void oblicz() {
        for (int i = 0; i <= n; i++) {
            ws[i] = calka(i);
            w += ws[i] * wielomian2(i, x);
        }
    }
}
