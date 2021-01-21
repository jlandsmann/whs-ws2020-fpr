package de.jlandsmann.whs.fpr.personnelManagement.cli.commands;

import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.EmployeeRepository;
import de.jlandsmann.whs.fpr.personnelManagement.cli.utils.RepositoryHolder;

public class GetMinSalaryCommand extends BaseCommand {

    private final EmployeeRepository repository;

    public GetMinSalaryCommand() {
        super("get-min-salary", "Returns employee with lowest salary");
        repository = RepositoryHolder.employeeRepository;
    }

    @Override
    public void execute() {
        final var lowestSalary = repository.getMinSalary();
        System.out.println(lowestSalary);
    }
}
