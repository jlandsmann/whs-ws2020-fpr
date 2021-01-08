package de.jlandsmann.whs.fpr.personnelManagement.management;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Employee;
import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Manager;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.BaseRepository;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.EmployeeRepository;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.ManagerRepository;
import de.jlandsmann.whs.fpr.personnelManagement.management.commands.BaseCommand;
import de.jlandsmann.whs.fpr.personnelManagement.management.commands.GetAllCommand;
import de.jlandsmann.whs.fpr.personnelManagement.management.utils.CommandHolder;
import de.jlandsmann.whs.fpr.personnelManagement.management.utils.CommandReader;
import de.jlandsmann.whs.fpr.personnelManagement.management.utils.RepositoryHolder;
import de.jlandsmann.whs.fpr.personnelManagement.storage.BaseInMemoryStorage;
import de.jlandsmann.whs.fpr.personnelManagement.storage.EmployeeStorage;
import de.jlandsmann.whs.fpr.personnelManagement.storage.ManagerStorage;

import java.time.LocalDate;

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
