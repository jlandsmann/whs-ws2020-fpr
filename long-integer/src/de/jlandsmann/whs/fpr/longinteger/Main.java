package de.jlandsmann.whs.fpr.longinteger;

public class Main {

    public static void main(String[] args) {
        long l = (long) Math.pow(3, 22);
        // l is too large for an integer
        int i = (int) l;
        System.out.printf("l=%d\ni=%d", l, i);
    }
}
