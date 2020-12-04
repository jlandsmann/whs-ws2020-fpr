package de.jlandsmann.whs.fpr.personnelManagement.domain.models;

import java.time.LocalDate;

public class Employee extends Person {

    private final LocalDate employeeSince;
    private double salary;

    public Employee(String id, String name, LocalDate employeeSince, double salary) {
        super(id, name);
        this.employeeSince = employeeSince;
        this.salary = salary;
    }

    public void increaseSalary(double percent) {
        double increaseFactor = 1 + (percent / 100);
        this.salary *= increaseFactor;
    }

    public LocalDate getEmployeeSince() {
        return employeeSince;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + this.getEmployeeSince().toString() + " | " + this.getSalary();
    }
}
