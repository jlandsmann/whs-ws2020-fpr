package de.jlandsmann.whs.fpr.personnelManagement.domain.models;

import java.time.LocalDate;

public class Manager extends Employee {

    private double bonus = 0;

    public Manager(String employeeId, String name, LocalDate employeeSince, double salary, double bonus) {
        super(employeeId, name, employeeSince, salary);
        this.bonus = bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }
}
