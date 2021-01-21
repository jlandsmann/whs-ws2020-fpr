package de.jlandsmann.whs.fpr.personnelManagement.cli;

import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.EmployeeRepository;
import de.jlandsmann.whs.fpr.personnelManagement.cli.commands.BaseCommand;
import de.jlandsmann.whs.fpr.personnelManagement.cli.utils.CommandReader;
import de.jlandsmann.whs.fpr.personnelManagement.domain.utils.RepositoryHolder;
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
