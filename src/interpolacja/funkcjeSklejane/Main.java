package interpolacja.funkcjeSklejane;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        double x; 
        double y;
        Dane p;
        List<Dane> punkty = new ArrayList<>();
        List<Dane> pochodne = new ArrayList<>();

        System.out.print("Size: ");
        n = sc.nextInt();

        for(int i = 0; i < n; i++){
            System.out.printf("x[%d] = ", i);
            x = sc.nextDouble();

            System.out.printf("f(%f) = ", x);
            y = sc.nextDouble();

            p = new Dane(x, y);
            punkty.add(p);
        }
        System.out.println();

        System.out.print("x'1 = ");
        x = sc.nextDouble();
        System.out.printf("f'(%.2f) = ", x);
        y = sc.nextDouble();
        p = new Dane(x,y);
        pochodne.add(p);
        
        System.out.print("x'2 = ");
        x = sc.nextDouble();
        System.out.printf("f'(%.2f) = ", x);
        y = sc.nextDouble();
        p = new Dane(x,y);
        pochodne.add(p);
    
        System.out.println();

        System.out.print("x = ");
        x=sc.nextDouble();

        System.out.println("\n-----------------------------------------------\n");
        Sklejane ms = new Sklejane(n, x, punkty, pochodne);
        ms.metodS();
    }
}
