package nieliniowe;

public class Siecznych {
    private double a;
    private double b;
    private double e;
    private Fx fx;
    private double xn;
    public double result;
    public int n = 0;

    public Siecznych(double a, double b, double e) {
        this.a = a;
        this.b = b;
        this.e = e;

        fx = new Fx();
        if (!fx.warunekKonieczny(a, b)) return;
    }

    enum punkt {
        a, b, no
    }

    private punkt punktNieruchomy(double a, double b) {
        if (fx.f(a) * fx.fP2(a) > 0) 
            return punkt.a;
        else if (fx.f(b) * fx.fP2(b) > 0)
            return punkt.b;
        else
            return punkt.no;
    }

    public void oblicz() {
        punkt p = punktNieruchomy(a, b);
        switch (p) {
            case a -> {
                double x0 = this.b;

                for (; ; ) {
                    n++;
                    xn = x0 - ((fx.f(x0) / (fx.f(x0) - fx.f(this.a))) * (x0 - this.a));
                    if (Math.abs(fx.f(xn)) < e || Math.abs(xn - x0) < e)
                        break;
                    x0 = xn;
                }
            }
            case b -> {
                double x0 = this.a;

                for (; ; ) {
                    n++;
                    xn = x0 - ((fx.f(x0) / (fx.f(this.b) - fx.f(x0))) * (this.b - x0));
                    if (Math.abs(fx.f(xn)) < e || Math.abs(xn - x0) < e)
                        break;
                    x0 = xn;
                }
            }
            case no -> {
                System.out.println("Brak rozwiazania, nie znaleziono punktu nieruchomego");
                return;
            }
        }
        
        result = xn;
    }
}

