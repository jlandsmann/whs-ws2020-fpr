package de.jlandsmann.whs.fpr.bubbleSort;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final var input = generateRandomIntegers(20);
	    print(input);
	    BubbleSort sorter = new BubbleSort();
	    final var sorted = sorter.sort(input);
	    print(sorted);
    }

    private static Integer[] generateRandomIntegers(int n) {
        Random random = new Random();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(n * 2);
        }
        return arr;
    }

    private static <T> void print(T[] source) {
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i]);
            if (i + 1 < source.length) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");
    }
}
