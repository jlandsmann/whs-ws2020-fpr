package de.jlandsmann.whs.fpr.personnelManagement.domain.models;

import java.time.LocalDate;

public class Manager extends Employee {

    private double bonus = 0;

    Manager(String employeeId, String name, LocalDate employeeSince, double salary) {
        super(employeeId, name, employeeSince, salary);
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }
}
