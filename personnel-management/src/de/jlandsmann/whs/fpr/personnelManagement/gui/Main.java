package de.jlandsmann.whs.fpr.personnelManagement.gui;

import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.EmployeeRepository;
import de.jlandsmann.whs.fpr.personnelManagement.domain.utils.RepositoryHolder;
import de.jlandsmann.whs.fpr.personnelManagement.storage.EmployeeStorage;

public class Main {

    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new EmployeeStorage();
        RepositoryHolder.employeeRepository = employeeRepository;

        final var frame = new EmployeeManagement();
        frame.pack();
        frame.setVisible(true);
    }
}
