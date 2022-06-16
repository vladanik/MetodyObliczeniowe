package iteracjiProstych;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Size: ");
        int size = sc.nextInt();

        double[][] a = new double[size][size];
        double[] b = new double[size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("a[%d][%d] = ", i, j);
                a[i][j] = sc.nextDouble();
            }
            System.out.printf("b[%d] = ", i);
            b[i] = sc.nextDouble();
        }

        System.out.println();
        System.out.print("e = ");
        double e = sc.nextDouble();

        System.out.println();

        Iteracja iter = new Iteracja(size, a, b, e);
        iter.oblicz();
        double[] result = iter.result;
        for (int i = 0; i < size; i++) {
            System.out.printf("x[%d] = %f\n", i, result[i]);
        }
        System.out.println("Liczba iteracji: " + iter.n);
    }
}
