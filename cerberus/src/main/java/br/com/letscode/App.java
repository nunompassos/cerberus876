package br.com.letscode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        final Pessoa p1 = new Pessoa("Nuno", "Passos", 36, "Castanho");
        p1.criarCartão(563802);
        //        System.out.println(p1);
        final Pessoa p2 = p1.criarClone();
        //        System.out.println(p2);

        final Pessoa p3 = new Pessoa("Alexandre", "Xavier", 47, "Preto");
        final Pessoa p4 = new Pessoa("Beatriz", "Matos", 24, "Louro");
        final Pessoa p5 = new Pessoa("Bruno", "Andrade", 19, "Vermelho");
        final Pessoa p6 = new Pessoa("Filipe", "Silva", 52, "Azul");

        Pessoa[] listaPessoas = {p1, p2, p3, p4, p5, p6};
        Arrays.sort(listaPessoas);
        /*for (Pessoa p : listaPessoas) {
            System.out.println(p);
        }*/

        // Mexivel m = (int x) -> System.out.println(x);
        // Arrays.stream(listaPessoas).mapToInt(pessoa -> pessoa.getIdade()).forEach(Mexivel::mexer);

        // Mexivel.mexer();
/*
        Mexivel m = new Mexivel() {
            @Override
            public void mexer() {
                System.out.println("A Inner Class está a andar!");
            }
        };

        class Carro implements Mexivel {

            @Override
            public void mexer() {
                System.out.println("Andei 1 Km!");
            }
        }
        Carro c = new Carro();*/

        List list = new ArrayList();
        List<Integer> intList = List.of(1, 2, 3, 4, 5);
        int i = intList.get(2);

        Integer[] intArray = {7, 65, 4, 3, 2, 63, 75};
        orderArray(intArray);
        for (Integer integer: intArray) {
            System.out.print(integer + " ");
        }
        System.out.println();

        String[] stringArray = {"Ana", "Mario", "Alexandre", "Beatriz"};
        orderArray(stringArray);
        Arrays.stream(stringArray).forEach(s -> System.out.print( s + " "));

        Integer j = null;
        Optional<Integer> integerOptional = Optional.empty();

    }

    public static <T extends Number> void orderArray(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].intValue() < array[j].intValue()) {
                    swap(array, i, j);
                }
            }
        }
    }

    public static <T> void orderArray(T[] array) {
        Arrays.sort(array);
    }

    public static void swap(Object[] array, int x, int y) {
        Object aux = array[x];
        array[x] = array[y];
        array[y] = aux;
    }

}
