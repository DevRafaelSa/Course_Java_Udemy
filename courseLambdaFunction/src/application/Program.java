package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.Product;
import util.UpperCaseName;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        //a funcao .map() aplica uma funcao a cada elemento de uma stream, por isso converto de lista pra
        // stream e depois converto novamente para lista
        List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
        //Opção 2:  List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());
        //Opção 3:  List<String> names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());


        names.forEach(System.out::println);
    }
}