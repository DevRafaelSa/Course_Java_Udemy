package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {

        /*lista nao pode ser de tipos primitivos (int, por exemplo), obrigando-nos a usar a Wrapper Class
         o que colocamos entre os simbolos de <> é o generics, que quando vc pode parametrizar a definição
        de um tipo informando um outro tipo especifico que vc quer.
        Já o ArrayList é uma classe (a mais comum para isso) que implementa a interface List (List é uma interface
         e, por isso, nao pode ser instanciada). Usando o ArrayList a implementacao eh mto otimizada, pegando
         as melhores caracteristicas do vetor e da Lista*/
        List<String> list = new ArrayList<>();

        list.add("Maria");
        list.add("Alex");
        list.add("Bob");
        list.add("Ana");
        list.add(2, "Marcos");

        System.out.println(list.size());

        for (String x : list) {
            System.out.println(x);
        }
        System.out.println("--------------------------------");
        //funcao lambida tambem é chamada de predicado, porque ela retorna um verdadeiro ou falso
        list.removeIf(x -> x.charAt(0) == 'M');
        System.out.println(list);

        System.out.println("--------------------------------");
        System.out.println("IndexOf Bob: " + list.indexOf("Bob"));
        //Obs.: quando o indexOf nao encontra o elemento ele retorna -1;

        System.out.println("--------------------------------");
        /*Filtrando a lista para aparecer so quem comeca com 'A'. O tipo .stream() é um tipo que aceita
        operações com expressoes lambda. Na Sequencia: converto a lista em um stream, depois chamo a funcao filter
        que recebe um predicado onde coloco o predicado (expressao lambda), depois preciso converter novamente
        numa lista
         */
        List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').toList();

        for (String x : result) {
            System.out.println(x);
        }

        System.out.println("--------------------------------");
        /*Encontrando o primeiro elemento a partir de um predicado
        *o findFirst pega o primeiro elemento do stream e retorna um tipo optional
        * a orElse é para o caso da condicao do predicado nao existir ele retornar o 'null' do orElse
        * */
        String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);
        System.out.println(name);
        String name2 = list.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);
        System.out.println(name2);



    }
}
