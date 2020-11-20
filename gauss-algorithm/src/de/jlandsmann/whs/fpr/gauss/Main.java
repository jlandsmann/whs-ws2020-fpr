package de.jlandsmann.whs.fpr.gauss;

/**
 * @author jlandsmann
 */
public class Main {

    public static void main(String[] args) {
        int n = 12;
        double[][] matrix = new double[n][n];
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            for (int h = 0; h < n; h++) {
                matrix[i][h] = Math.random() * n;
            }
            result[i] = Math.random() * n;
        }
        Main.print(matrix, result);
        GaussSolver solver = new GaussSolver(matrix, result);
        double[] variables = solver.solve();
        Main.print(variables);
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
