package br.com.letscode;

import java.util.Random;

public interface Utils {

    public static int[] populateArray(int arraySize) {
        int[] result = new int[arraySize];
        for (int j = 0; j < result.length; j++) {
            result[j] = new Random().nextInt() % 500;
        }
        return result;
    }

    public static int[][] populateMatrix(int xSize, int ySize) {
        int[][] t = new int[xSize][ySize];
        for (int index1 = 0; index1 < t.length; index1++) {
            for (int j = 0; j < t[index1].length; j++) {
                t[index1][j] = new Random().nextInt() % 500;
            }
        }
        return t;
    }

    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
                if (j < matrix[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
    public static void orderMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                for (int k = j + 1; k < matrix[i].length; k++ ) {
                    if (matrix[i][j] > matrix[i][k]) {
                        swap(matrix[i][j], matrix[i][k]);
                    }
                }
            }
            for(int j = 0; j < matrix[i].length; j++) {
                for (int k = i + 1; k < matrix.length; k++) {
                    for (int n = 0; n < matrix[k].length; n++) {
                        if (matrix[i][j] > matrix[k][n]) {
                            swap(matrix[i][j], matrix[k][n]);
                        }
                    }
                }
            }
        }
    }

    private static void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }

    private static void swap(long x, long y) {
        long temp = x;
        x = y;
        y = temp;
    }

    public static void orderArray(int[] array) {
        for (int i = 0; i < array.length - 1 ; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array[i], array[j]);
                }
            }
        }
    }
}
