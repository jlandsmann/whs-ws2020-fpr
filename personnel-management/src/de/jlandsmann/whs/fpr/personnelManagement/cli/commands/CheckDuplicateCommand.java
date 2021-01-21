package de.jlandsmann.whs.fpr.personnelManagement.cli.commands;

import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.EmployeeRepository;
import de.jlandsmann.whs.fpr.personnelManagement.cli.utils.RepositoryHolder;

public class CheckDuplicateCommand extends BaseCommand {

    private final EmployeeRepository repository;

    public CheckDuplicateCommand() {
        super("check-duplicate", "Checks if collection contains duplicated employees.");
        repository = RepositoryHolder.employeeRepository;
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
