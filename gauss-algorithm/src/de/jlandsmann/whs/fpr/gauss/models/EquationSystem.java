package de.jlandsmann.whs.fpr.gauss.models;

public class EquationSystem {

    private final int size;
    private final Equation[] equations;

    public EquationSystem(double[][] matrix, double[] results) {
        this.size = matrix.length;
        this.equations = new Equation[this.size];
        this.fillEquationsSystem(matrix, results);
    }

    public EquationSystem(Equation[] equations) {
        this.size = equations.length;
        this.equations = equations;
    }

    private void fillEquationsSystem(double[][] matrix, double[] results) {
        for (int i = 0; i < size; i++) {
            equations[i] = new Equation(matrix[i], results[i]);
        }
    }

    public Equation getEquation(int n) {
        return this.equations[n];
    }

    public Equation[] getEquations() {
        return equations;
    }

    public int getSize() {
        return size;
    }

    @Override
    protected EquationSystem clone() {
        Equation[] copiedEquations = new Equation[this.size];
        for (int i = 0; i < equations.length; i++) {
            copiedEquations[i] = equations[i].clone();
        }
        return new EquationSystem(copiedEquations);
    }

    public double[] getResult() {
        double[] results = new double[this.size];
        for (int i = 0; i < equations.length; i++) {
            results[i] = equations[i].getResult();
        }
        return results;
    }
}
