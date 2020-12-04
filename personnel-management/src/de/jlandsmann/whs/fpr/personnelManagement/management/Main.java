package de.jlandsmann.whs.fpr.personnelManagement.management;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Employee;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.BaseRepository;
import de.jlandsmann.whs.fpr.personnelManagement.management.commands.BaseCommand;
import de.jlandsmann.whs.fpr.personnelManagement.management.commands.GetAllCommand;
import de.jlandsmann.whs.fpr.personnelManagement.management.utils.CommandHolder;
import de.jlandsmann.whs.fpr.personnelManagement.management.utils.CommandReader;
import de.jlandsmann.whs.fpr.personnelManagement.management.utils.RepositoryHolder;
import de.jlandsmann.whs.fpr.personnelManagement.storage.BaseInMemoryStorage;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        BaseRepository<Employee> repo = new BaseInMemoryStorage<>();
        RepositoryHolder.setRepository(repo);
        repo.create(new Employee("1234", "Max Mustermann", LocalDate.now(), 1234.00));
        repo.create(new Employee("1234", "Max Mustermann", LocalDate.now(), 1234.00));
        repo.create(new Employee("1234", "Max Mustermann", LocalDate.now(), 1234.00));
        repo.create(new Employee("1234", "Max Mustermann", LocalDate.now(), 1234.00));
        repo.create(new Employee("1234", "Max Mustermann", LocalDate.now(), 1234.00));
        CommandReader commandReader = new CommandReader();
        String commandName = commandReader.readCommand();
        while (!commandName.equals("exit")) {
            BaseCommand command = CommandHolder.getCommandByName(commandName);
            command.execute();

            commandName = commandReader.readCommand();
        }
    }
}
