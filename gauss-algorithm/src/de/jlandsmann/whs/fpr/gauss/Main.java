package de.jlandsmann.whs.fpr.gauss;

import de.jlandsmann.whs.fpr.gauss.models.EquationSystem;
import de.jlandsmann.whs.fpr.gauss.models.GaussSolver;

/**
 * @author jlandsmann
 */
public class Main {

    public static void main(String[] args) {
        int n = 12;
        double[][] matrix = new double[n][n];
        double[] results = new double[n];
        for (int i = 0; i < n; i++) {
            for (int h = 0; h < n; h++) {
                matrix[i][h] = Math.random() * n;
            }
            results[i] = Math.random() * n;
        }
        Main.print(matrix, results);
        EquationSystem system = new EquationSystem(matrix, results);
        EquationSystem result = GaussSolver.solve(system);
        print(result.getResult());
    }

    /**
     *
     * @param matrix a matrix to print
     * @param result the result vector of matrix
     */
    private static void print(double[][] matrix, double[] result) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.printf("%6.2f ", matrix[i][j]);
            }
            System.out.printf("   %6.2f\n", result[i]);
        }
        System.out.println("-----------------------------------");
    }

    private static void print(double[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%6.2f ", result[i]);
        }
        System.out.println("\n-----------------------------------");
    }
}
