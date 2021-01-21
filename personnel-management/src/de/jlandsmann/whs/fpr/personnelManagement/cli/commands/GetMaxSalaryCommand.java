package de.jlandsmann.whs.fpr.personnelManagement.cli.commands;

import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.EmployeeRepository;
import de.jlandsmann.whs.fpr.personnelManagement.domain.utils.RepositoryHolder;

public class GetMaxSalaryCommand extends BaseCommand {

    private final EmployeeRepository repository;

    public GetMaxSalaryCommand() {
        super("get-max-salary", "Returns employee with highest salary");
        repository = RepositoryHolder.employeeRepository;
    }

    @Override
    public void execute() {
        final var highestSalary = repository.getMaxSalary();
        System.out.println(highestSalary);
    }
}
