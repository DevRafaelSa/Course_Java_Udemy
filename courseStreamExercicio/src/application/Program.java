package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Product;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //peço pro usuario indicar o caminho do arquivo
        System.out.print("Enter full file path: ");
        //armazeno na variavel path
        String path = sc.nextLine();

        //bloco try with resources para abrir o arquivo
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            //instanciei uma lista de produtos
            List<Product> list = new ArrayList<>();

            //leio o arquivo. aqui leio uma linha
            String line = br.readLine();
            //enquanto a linha for diferente de nulo
            while (line != null) {
                //faço o split na linha para dividi-la em 2 com base na ", ", de modo que eu possa acessar o
                // nome e o preço e armazeno num vetor fields
                String[] fields = line.split(",");
                //agora eu instancio o produto pela posicao no vetor
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                //pulo uma linha e assim por diante ate acabar o arquivo
                line = br.readLine();
            }

            //neste ponto o arquivo ja foi lido e todos os produtos ja estao armazenados na Lista list (linha 31)

            // fiz um pipeline - converti pra stream
            double avg = list.stream()
                    //chamei o .map pq a lista eh de produtos e eu so preciso do preco q eh double
                    .map(p -> p.getPrice())
                    //permite fazer o nomatorio dos precos (inicio, (funcao -> condicao)
                    .reduce(0.0, (x,y) -> x + y) / list.size();

            System.out.println("Average price: " + String.format("%.2f", avg));

            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> names = list.stream()
                    .filter(p -> p.getPrice() < avg)
                    .map(p -> p.getName()).sorted(comp.reversed())
                    .collect(Collectors.toList());

            names.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}