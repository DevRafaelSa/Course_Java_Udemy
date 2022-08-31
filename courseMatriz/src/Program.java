import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        //os dois [][] indica que o vetor eh bidimensional (matriz)
        int[][] mat = new int[n][n];

        //os dois for servem para percorrer a matriz inteira. mat[i].length é a quantidade de colunas
        for(int i=0; i< mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                mat[i][j] = sc.nextInt();
            }
        }


        //Achar diagonal principal
        System.out.println("Main diagonal");
        for (int i =0;i< mat.length;i++) {
            System.out.println(mat[i][i] + " ");
        }

        System.out.println();

        //Achar numeros negativos na matriz
        int count = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j=0; j < mat[i].length; j++) {
                if (mat[i][j] < 0) {
                    count++;
                }
            }
        }
        System.out.println("Negative numbers: " + count);


        sc.close();

    }
}
