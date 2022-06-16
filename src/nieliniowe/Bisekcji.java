package nieliniowe;

public class Bisekcji {
    private double a;
    private double b;
    private double e;
    private Fx fx;
    public double result;
    public int n = 0;

    public Bisekcji(double a, double b, double e) {
        this.a = a;
        this.b = b;
        this.e = e;

        fx = new Fx();

        if (!fx.warunekKonieczny(a, b)) return;
    }

    public void oblicz() {
        double xsr = (a + b) / 2;
        while (Math.abs(fx.f(xsr)) >= e) {
            n++;
            double f = fx.f(xsr);
            if (f == 0) {
                result = xsr;
                break;
            }
            if (f * fx.f(a) < 0) b = xsr;
            else a = xsr;

            xsr = (a + b) / 2;
        }
        result = xsr;
    }
}
