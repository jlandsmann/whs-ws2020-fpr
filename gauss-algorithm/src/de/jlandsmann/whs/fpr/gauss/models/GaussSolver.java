package de.jlandsmann.whs.fpr.gauss.models;

public class GaussSolver {

    public static EquationSystem solve(EquationSystem original) {
        EquationSystem system = original.clone();
        transformLowerHalf(system);
        transformUpperHalf(system);
        transformDiagonal(system);
        return system;
    }

    private static void transformLowerHalf(EquationSystem system) throws IllegalStateException {
        for (int j = 0; j < system.getSize(); j++) {
            for (int i = j + 1; i < system.getSize(); i++) {
                Equation target = system.getEquation(i);
                Equation source = system.getEquation(j);

                double transformFactor = target.getVariable(j) / source.getVariable(j);
                transformRow(target, source, transformFactor);
            }
        }
    }


    private static void transformUpperHalf(EquationSystem system) throws IllegalStateException {
        for (int j = system.getSize() - 1; j >= 0; j--) {
            for (int i = j - 1; i >= 0; i--) {
                Equation target = system.getEquation(i);
                Equation source = system.getEquation(j);

                double transformFactor = target.getVariable(j) / source.getVariable(j);
                transformRow(target, source, transformFactor);
            }
        }
    }

    private static void transformDiagonal(EquationSystem system) {
        for (int i = 0; i < system.getSize(); i++) {
            Equation target = system.getEquation(i);
            double transformFactor = target.getVariable(i);
            target.divideBy(transformFactor);
        }
    }

    private static void transformRow(Equation target, Equation source, double factor) {
        Equation temp = source.clone();
        temp.multiplyBy(factor);
        target.subtract(temp);
    }
}
