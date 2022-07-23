package br.com.letscode;

import java.util.*;

public class App {
    public static void main(String... args) {


        ArrayList<Number> integerArrayList = new ArrayList<>();
        integerArrayList.add(1d);
        integerArrayList.add(2d);
        integerArrayList.add(3d);
        integerArrayList.add(4d);
        integerArrayList.add(5d);

        Double[] doubleArray = new Double[6]; integerArrayList.toArray(doubleArray);
        for(Double d : doubleArray) {
            System.out.println(d);
        }
        Integer[] intArray = new Integer[5];

        Set<Integer> intSet = new HashSet<>();
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(2);
        intSet.add(1);

        // intSet.forEach(System.out::println);

        Map<Integer, String> stringMap = new HashMap<>();
        stringMap.put(1, "Olá");
        stringMap.put(2, "Olá");
        stringMap.put(3, "Olá");
        stringMap.put(1, "Adeus");
        stringMap.put(4, "Olá");

        //stringMap.forEach( (k, v) -> System.out.println(k + " " + v));

    }

    Integer[] copyOf(Integer[] array, int newCapacity) {
        Integer[] result = new Integer[newCapacity];
        for(int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }
}
