package interpolacja.funkcjeSklejane;

public class Dane {
    private double x;
    private double y;

    Dane(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String toString() {
        return "Punkt: f(" + x + ") = " + y;
    }
}
