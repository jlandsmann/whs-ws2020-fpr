package de.jlandsmann.whs.fpr.personnelManagement.management.commands;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Employee;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.BaseRepository;
import de.jlandsmann.whs.fpr.personnelManagement.management.utils.RepositoryHolder;

public class CheckDuplicateCommand extends BaseCommand {

    private final BaseRepository<Employee> repository;

    public CheckDuplicateCommand() {
        super("check-duplicate", "Checks if collection contains duplicated employees.");
        repository = RepositoryHolder.getRepository();
    }

    @Override
    public void execute() {
        final var employees = repository.getResultSet(0, repository.getSize());
        for (final var employeeA : employees) {
            for (final var employeeB : employees) {
                if (employeeA.equals(employeeB)) {
                    System.out.println("There are duplicate employees");
                    return;
                }
            }
        }
        System.out.println("There are no duplicate employees");
    }
}
