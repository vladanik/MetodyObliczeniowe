package interpolacja.funkcjeSklejane;

import java.util.ArrayList;
import java.util.List;

public class Sklejane {
    private int n;
    private double x;
    private double wielomian;
    private double wynik;

    private List<Dane> punkty;
    private List<Dane> pochodne;
    private double as_n[][];
    private double ap_n[];
    private List<Double> a = new ArrayList<>();
    private double macierzRownan[][];
    private double macierzWynikow[];

    public Sklejane(int n, double x, List<Dane> punkty, List<Dane> pochodne) {
        this.n = n;
        this.x = x;
        this.punkty = punkty;
        this.pochodne = pochodne;
    }

    public void metodS() {
        int wierszy = n + 2;
        int kolumny = n + 2;
        macierzRownan = new double[wierszy][kolumny];
        macierzWynikow = new double[wierszy];
        wielomian = 0;
        for (int i = 0; i < n; i++) {
            macierzWynikow[i] = punkty.get(i).getY();
        }
        int j = 0;
        for (int i = n; i < macierzWynikow.length; i++) {
            macierzWynikow[i] = pochodne.get(j).getY();
            j++;
        }
        for (int i = 0; i < n; i++) {
            a.add(1.0);
            a.add(punkty.get(i).getX());
            a.add(Math.pow(punkty.get(i).getX(), 2));
            a.add(Math.pow(punkty.get(i).getX(), 3));
            for (int k = 0; k < 4; k++) {
                macierzRownan[i][k] = a.get(k);
            }
            a.clear();
        }
        as_n = mSuma();
        for (int i = 2; i < n; i++) {
            int k = 4;
            for (int s = 1; s < as_n[i].length; s++) {
                macierzRownan[i][k] = as_n[i][s];
                k++;
            }
        }
        j = 0;
        for (int i = n; i < wierszy; i++) {
            a.add(1.0);
            a.add(2 * pochodne.get(j).getX());
            a.add(3 * Math.pow(pochodne.get(j).getX(), 2));
            for (int k = 1; k < 4; k++) {
                macierzRownan[i][k] = a.get(k - 1);
            }
            j++;
            a.clear();
        }
        ap_n = pSuma();
        int s = 0;
        for (int k = 4; k < kolumny; k++) {
            macierzRownan[wierszy - 1][k] = ap_n[s];
            s++;
        }
        Macierz m_Sklej = new Macierz(wierszy);
        m_Sklej.setTablicy(macierzRownan, macierzWynikow);
        System.out.println(m_Sklej);
        double niewiadome[] = m_Sklej.metodaEluminacjiGausa();
        for (int i = 0; i < niewiadome.length; i++) {
            System.out.printf("a[%d] = %.3f\n", i,  niewiadome[i]);
        }
        System.out.println();
        System.out.println("Result: " + wynikM(x, niewiadome));

    }

    public double[] pSuma() {
        double ap[];
        ap = new double[n - 1];
        for (int s = 0; s < ap.length; s++) {
            wielomian = 3 * Math.pow((pochodne.get(1).getX() - punkty.get(s + 1).getX()), 2);
            ap[s] = wielomian;
        }
        return ap;
    }

    public double[][] mSuma() {
        double as[][] = new double[n][];
        for (int i = 0; i < n; i++) {
            as[i] = new double[i];
        }
        for (int j = 1; j < n; j++) {
            for (int s = 1; s < j; s++) {
                wielomian = Math.pow((punkty.get(j).getX() - punkty.get(s).getX()), 3);
                as[j][s] = wielomian;
            }
        }
        return as;
    }

    public double wynikM(double x, double[] f) {
        int przedzial_s = 0;
        int przedzial_e = 0;
        for (int i = 0; i < punkty.size(); i++) {
            if (x >= punkty.get(i).getX() && x <= punkty.get(i + 1).getX()) {
                przedzial_s = i;
                przedzial_e = i + 1;
                double przedS = 0;
                wynik = f[0] + f[1] * x + f[2] * Math.pow(x, 2) + f[3] * Math.pow(x, 3);
                if (przedzial_s == 0 && przedzial_e == 1) {
                    return wynik;
                } else {
                    int j = 4;
                    for (int s = 1; s < przedzial_e; s++) {
                        przedS += f[j] * Math.pow((x - punkty.get(s).getX()), 3);
                        j++;
                    }
                    wynik += przedS;
                }
            }
        }
        return wynik;
    }
}
