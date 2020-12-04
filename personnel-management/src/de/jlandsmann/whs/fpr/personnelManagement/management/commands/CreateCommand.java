package de.jlandsmann.whs.fpr.personnelManagement.management.commands;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Employee;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.BaseRepository;
import de.jlandsmann.whs.fpr.personnelManagement.management.utils.RepositoryHolder;

import java.time.LocalDate;

public class CreateCommand extends BaseCommand {

    private final BaseRepository<Employee> repository;

    public CreateCommand() {
        super("create", "Erstellt einen Angestellten");
        repository = RepositoryHolder.getRepository();
    }

    @Override
    public void execute() {
        Employee employee = new Employee("1234", "Max Mustermann", LocalDate.now(), 1234.00);
        repository.create(employee);
    }
}
