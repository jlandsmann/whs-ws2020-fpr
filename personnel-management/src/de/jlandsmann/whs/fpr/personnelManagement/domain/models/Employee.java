package de.jlandsmann.whs.fpr.personnelManagement.domain.models;

import java.time.LocalDate;
import java.util.Objects;

public class Employee extends Person implements Properties.Size, Properties.Age {

    private final LocalDate employeeSince;
    private double salary;
    private String size;
    private int age;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.getSalary(), getSalary()) == 0 &&
                Objects.equals(getEmployeeSince(), employee.getEmployeeSince());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getEmployeeSince(), getSalary());
    }

    @Override
    public String toString() {
        return super.toString() + " | " + this.getEmployeeSince().toString() + " | " + this.getSalary();
    }

    @Override
    public String getSize() {
        return this.size;
    }

    @Override
    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public int getAge() {
        return this.age;
    }
}
