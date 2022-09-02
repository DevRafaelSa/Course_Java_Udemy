package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {

    public static void main(String[] args) {

        String path = "c:\\temp\\in.txt";

        /*para melhor instanciar nossas streams devemos instancia direto no bloco try. Para tanto,
        * declaro o BufferedReader e faz ele receber um new BufferedReader onde, no seu construtor,
        * já colocamos o new FileReader que recebe o path para abrir o arquivo*/
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}