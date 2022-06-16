package interpolacja.funkcjeSklejane;

public class Macierz {
    private int rozmiar;
    private int wierszy;
    private int kolumny;
    private double tablica[][];
    private double wynik[];

    public Macierz(int rozmiar) {
        if (rozmiar <= 1) 
            rozmiar = 2;
        this.rozmiar = rozmiar;
        this.wierszy = rozmiar;
        this.kolumny = rozmiar;
    }

    public void setTablicy(double[][] tablica, double[] wynik) {
        this.tablica = tablica;
        this.wynik = wynik;
    }

    @Override
    public String toString() {
        String macierz = "";
        for (int i = 0; i < wierszy; i++) {
            for (int j = 0; j < kolumny; j++) {
                macierz += " " + tablica[i][j];
            }
            macierz += "| " + wynik[i] + "\n";
        }
        return macierz;
    }

    public int getLiczbaWierszy() {
        return wierszy;
    }

    public int getLiczbaKolumn() {
        return kolumny;
    }

    public double[][] getMacierz() {
        return tablica;
    }

    public double[] getWektor() {
        return wynik;
    }

    public double[] metodaEluminacjiGausa() {
        double macWyn[][] = new double[tablica.length][tablica.length];
        double wCopy[] = new double[wynik.length];
        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica.length; j++) {
                macWyn[i][j] = tablica[i][j];
            }
        }
        for (int i = 0; i < wynik.length; i++) {
            wCopy[i] = wynik[i];
        }
        for (int i = 0; i < rozmiar - 1; i++) {
            for (int j = i + 1; j <= rozmiar - 1; j++) {
                for (int k = 0; k < rozmiar; k++) {
                    macWyn[j][k] = tablica[j][k] - (tablica[i][k] * (tablica[j][i] / tablica[i][i]));
                }
                wCopy[j] = wynik[j] - (wynik[i] * (tablica[j][i] / tablica[i][i]));
                for (int ii = 0; ii < macWyn.length; ii++) {
                    for (int jj = 0; jj < macWyn.length; jj++) {
                        tablica[ii][jj] = macWyn[ii][jj];
                    }
                    wynik[ii] = wCopy[ii];
                }
            }
        }
        double[] x = new double[rozmiar];
        for (int i = rozmiar - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < rozmiar; j++) {
                sum += tablica[i][j] * x[j];
            }
            x[i] = (wynik[i] - sum) / tablica[i][i];
        }
        return x;
    }
}
