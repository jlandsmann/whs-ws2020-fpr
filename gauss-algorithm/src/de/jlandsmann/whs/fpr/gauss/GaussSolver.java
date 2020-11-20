package de.jlandsmann.whs.fpr.gauss;

/**
 * @author jlandsmann
 * @version 1.0
 */
public class GaussSolver {

    private final double[][] matrix;
    private final double[] result;
    private final int size;

    /**
     *
     * @param matrix the matrix of the equation system
     * @param result the result vector of the equation system
     */
    GaussSolver(double[][] matrix, double[] result) {
        if (matrix.length != result.length) {
            throw new IllegalArgumentException();
        }
        this.matrix = matrix;
        this.result = result;
        this.size = this.matrix.length;
    }

    /**
     * this function does the main work on the gauss algorithm and returns the solution
     * @return solution of system of equations
     */
    public double[] solve() {
        try {
            this.transformLowerHalf();
            this.transformUpperHalf();
            this.transformDiagonal();
        } catch (IllegalStateException e) {
            return new double[this.size];
        }
        return this.result;
    }

    /**
     * this functions transforms the lower half of the equation
     * system into the gauss format
     * @throws IllegalStateException if an equation is malformed
     */
    private void transformLowerHalf() throws IllegalStateException {
        for (int j = 0; j < this.size; j++) {
            for (int i = j + 1; i < this.size; i++) {
                double target = this.matrix[i][j];
                double ref = this.matrix[j][j];
                if (ref == 0) {
                    throw new IllegalStateException();
                }
                double transformFactor = target / ref;
                this.matrix[i] = this.transformRow(this.matrix[i], this.matrix[j], transformFactor);
                this.result[i] = this.transformCell(this.result[i], this.result[j], transformFactor);
            }
        }
    }

    /**
     * this function transforms the upper half of the equation
     * system into the gauss format
     * @throws IllegalStateException if an equation is malformed
     */
    private void transformUpperHalf() throws IllegalStateException {
        for (int j = this.size - 1; j >= 0; j--) {
            for (int i = j - 1; i >= 0; i--) {
                double target = this.matrix[i][j];
                double ref = this.matrix[j][j];
                if (ref == 0) {
                    throw new IllegalStateException();
                }
                double transformFactor = target / ref;
                this.matrix[i] = this.transformRow(this.matrix[i], this.matrix[j], transformFactor);
                this.result[i] = this.transformCell(this.result[i], this.result[j], transformFactor);
            }
        }
    }

    /**
     * this function transforms the diagonal of the
     * equation system to 1 each. That's results in a result
     * vector that is equal to the solution of the system
     */
    private void transformDiagonal() {
        for (int i = 0; i < this.size; i++) {
            this.result[i] = this.result[i] / this.matrix[i][i];
            this.matrix[i][i] = 1;
        }
    }

    /**
     * this function transforms a row of the equation matrix
     * relative to an other row inside the matrix. Therefore the factor
     * defines the factor to be target be multiplied by, for subtraction
     * @param row the row to subtract from
     * @param target the row to be subtracted
     * @param factor the factor to multiply the target row before subtraction
     * @return the resulting row
     */
    private double[] transformRow(double[] row, double[] target, double factor) {
        for (int i = 0; i < row.length; i++) {
            row[i] = this.transformCell(row[i], target[i], factor);
        }
        return row;
    }

    /**
     * this functions subtracts target from cell after multiplying former by factor.
     * @param cell the value to subtract from
     * @param target the value to be subtracted
     * @param factor the factor to multiply the target cell before subtraction
     * @return the resulting value
     */
    private double transformCell(double cell, double target, double factor) {
        return cell - (factor * target);
    }
}
