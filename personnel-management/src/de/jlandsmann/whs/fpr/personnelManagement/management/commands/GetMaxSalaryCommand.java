package de.jlandsmann.whs.fpr.personnelManagement.management.commands;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Employee;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.BaseRepository;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.EmployeeRepository;
import de.jlandsmann.whs.fpr.personnelManagement.management.utils.RepositoryHolder;

import java.util.Collections;
import java.util.Comparator;

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
