package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        //double colchete eh a forma de criar vetores, seguido do nome do vetor que recebe um vetor de double
        // de tamanho n (o que esta entre os segundos colchetes
        double[] vect = new double[n];

        for (int i = 0; i<n; i++) {
            //o vect na posicao 'i' vai receber o sc.nextDouble
            vect[i] = sc.nextDouble();
        }

        double sum = 0.0;
        for (int i =0; i<n; i++) {
            sum += vect[i];
        }
        double avg = sum/n;
        System.out.println("Average height: " + avg);

        sc.close();
    }
}
