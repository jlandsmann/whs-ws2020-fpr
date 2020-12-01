package de.jlandsmann.whs.fpr.gauss.models;

public class Equation {

    private final double[] variables;
    private double result;
    
    Equation(double[] variables, double result) {
        this.variables = variables;
        this.result = result;
    }

    public void divideBy(double x) {
        if (x == 0) {
            throw new IllegalStateException();
        }
        this.multiplyBy( 1 / x);
    }
    
    public void multiplyBy(double x) {
        for (int i = 0; i < this.variables.length; i++) {
            variables[i] *= x;
        }
        result *= x;
    }

    public void add(Equation toAdd) {
        double[] variablesToAdd = toAdd.getVariable();
        for (int i = 0; i < this.variables.length; i++) {
            variables[i] += variablesToAdd[i];
        }
        result += toAdd.getResult();
    }

    public void subtract(Equation toSubtract) {
        double[] variablesToAdd = toSubtract.getVariable();
        for (int i = 0; i < this.variables.length; i++) {
            variables[i] -= variablesToAdd[i];
        }
        result -= toSubtract.getResult();
    }

    public double getVariable(int n) {
        return variables[n];
    }

    public double[] getVariable() {
        return variables;
    }

    public double getResult() {
        return result;
    }

    public int getSize() {
        return this.variables.length;
    }

    @Override
    protected Equation clone() {
        return new Equation(this.variables.clone(), this.result);
    }
}
