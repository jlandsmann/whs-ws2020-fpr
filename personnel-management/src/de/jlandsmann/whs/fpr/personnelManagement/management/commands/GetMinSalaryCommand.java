package de.jlandsmann.whs.fpr.personnelManagement.management.commands;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Employee;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.BaseRepository;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.EmployeeRepository;
import de.jlandsmann.whs.fpr.personnelManagement.management.utils.RepositoryHolder;

import java.util.Collections;
import java.util.Comparator;

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
