package nieliniowe;

public class Fx {
    public double f(double x) {
        return 12.0 * Math.pow(x, 2) - 6.0 * x - 32.0;
    }

    public double fP1(double x) {
        return 24.0 * x - 6.0;
    }

    public double fP2(double x) {
        return 24.0;
    }

    public boolean warunekKonieczny(double a, double b) {
        if (f(a) * f(b) < 0) return true;
        else return false;
    }
}