package de.jlandsmann.whs.fpr.personnelManagement.management;

import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.EmployeeRepository;
import de.jlandsmann.whs.fpr.personnelManagement.management.commands.BaseCommand;
import de.jlandsmann.whs.fpr.personnelManagement.management.utils.CommandReader;
import de.jlandsmann.whs.fpr.personnelManagement.management.utils.RepositoryHolder;
import de.jlandsmann.whs.fpr.personnelManagement.storage.EmployeeStorage;

public class Main {

    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new EmployeeStorage();
        RepositoryHolder.employeeRepository = employeeRepository;

        CommandReader commandReader = new CommandReader();
        BaseCommand command = commandReader.readCommand();
        while (!command.getName().equals("exit")) {
            command.execute();
            command = commandReader.readCommand();
        }
    }
}
