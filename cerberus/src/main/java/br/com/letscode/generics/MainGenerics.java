package br.com.letscode.generics;

import java.util.Arrays;
import java.util.List;

public class MainGenerics {

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        List<Long> longList = List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 0L);
        List<Double> doubleList = List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 0.1);
        MainGenerics m = new MainGenerics();
        System.out.println("intList: " + m.countOdds(intList));
        System.out.println("longList: " + m.countOdds(longList));
        System.out.println("doubleList: " + m.countOdds(doubleList));

        System.out.println(1 > 1.0D);

        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Arrays.stream(intArray).forEach(System.out::print);
        System.out.println();
        swapPlaces(intArray, 0, 9);
        Arrays.stream(intArray).forEach(System.out::print);

    }

    public static <T extends Number> T max(T num1, T num2) {
        return num1.doubleValue() > num2.doubleValue() ? num1 : num2;
    }

    public long countOdds(List<? extends Number> numberList) {
        return numberList.stream().filter(p -> p.intValue() % 2 == 1).count();
    }

    public static <T> void swapPlaces(T[] array, int x, int y) {
        T aux = array[x];
        array[x] = array[y];
        array[y] = aux;
    }
}
