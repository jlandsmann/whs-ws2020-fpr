package de.jlandsmann.whs.fpr.personnelManagement.gui;

import javax.swing.*;

public class EmployeeTable extends JTable {

    EmployeeTable() {
        super(new EmployeeTableModel());
    }
}
