package de.jlandsmann.whs.fpr.bubbleSort;

public class BubbleSort {

    public <T extends Comparable<T>> T[] sort(T[] input) {
        T[] source = input.clone();
        for (int i = 0; i < source.length; i++) {
            for (int h = 1; h < source.length; h++) {
                final var a = source[h - 1];
                final var b = source[h];

                if (a.compareTo(b) > 0) {
                    source[h - 1] = b;
                    source[h] = a;
                };
            }
        }

        return source;
    }

}
