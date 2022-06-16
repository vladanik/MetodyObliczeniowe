package nieliniowe;

public class Stycznych {
    private double a;
    private double b;
    private double e;
    private Fx fx;
    private double xn;
    public double result;
    public int n = 0;
    
    public Stycznych(double a, double b, double e) {
        this.a = a;
        this.b = b;
        this.e = e;

        fx = new Fx();
        if (!fx.warunekKonieczny(a, b)) return;
    }

    public void oblicz() {
        double x0 = fx.fP2(a) * fx.f(a) > 0 ? a : b;

        for (; ; ) {
            n++;
            xn = x0 - (fx.f(x0) / fx.fP1(x0));
            if (Math.abs(fx.f(xn)) < e || Math.abs(xn - x0) < e)
                break;
            x0 = xn;
        }

        result = xn;
    }
}