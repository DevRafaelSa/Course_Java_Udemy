package application;

import entities.Product;
import util.ProductPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("TV", 350.50));
        list.add(new Product("TV", 80.90));

        /* OPÇÃO 1:

        list.removeIf(p -> p.getPrice() >= 100);

        for (Product p : list) { //leia-se: para cada item 'p' da minha lista 'lista', faça...
            System.out.println(p);
        }*/

        /* OPCAO 2: usar a classe Predicate (interface funcional) para criar um metodo teste.
        list.removeIf(new ProductPredicate());//dentro do removeIf coloco uma instancia da classe ProductPredicate

        for (Product p : list) { //leia-se: para cada item 'p' da minha lista 'lista', faça...
            System.out.println(p);
        }*/

        /* OPCAO 3: criar um metodo estatico retornando um boolean (pra fazer a funcao do Predicate)
        //na classe Product e depois fazer um Method References
        list.removeIf(Product::staticProductPredicate);//estrutura NOME_CLASSE::NOME_METODO

        for (Product p : list) { //leia-se: para cada item 'p' da minha lista 'lista', faça...
            System.out.println(p);
        }*/

        //* OPCAO 4: criar um metodo retornando um boolean (pra fazer a funcao do Predicate)
        //na classe Product e depois fazer um Method References
        list.removeIf(Product::nonStaticProductPredicate);//estrutura NOME_CLASSE::NOME_METODO

        for (Product p : list) { //leia-se: para cada item 'p' da minha lista 'lista', faça...
            System.out.println(p);
        }//*/

        /* OPCAO 4: criar um metodo retornando um boolean (pra fazer a funcao do Predicate)
        na classe Product e depois fazer um Method References
        list.removeIf(Product::nonStaticProductPredicate);//estrutura NOME_CLASSE::NOME_METODO

        for (Product p : list) { //leia-se: para cada item 'p' da minha lista 'lista', faça...
            System.out.println(p);
        }*/

        /*OPÇÃO 5: EXPRESSO LAMBDA DECLARADA
        double min = 100.0;

        Predicate<Product> pred = p -> p.getPrice() >= min; //expressao lambda declarada

        list.removeIf(pred);

        for (Product p : list) { //leia-se: para cada item 'p' da minha lista 'lista', faça...
            System.out.println(p);
        }*/

        //OPÇÃO 6: EXPRESSO LAMBDA INLINE (colocando diretamente como argumento no remofeIf)
        double min = 100.0;

        list.removeIf(p -> p.getPrice() >= min);

        for (Product p : list) { //leia-se: para cada item 'p' da minha lista 'lista', faça...
            System.out.println(p);
        }

    }
}
