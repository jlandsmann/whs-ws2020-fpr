package de.jlandsmann.whs.fpr.personnelManagement.management.commands;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Employee;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.BaseRepository;
import de.jlandsmann.whs.fpr.personnelManagement.management.utils.RepositoryHolder;

import java.util.Collections;
import java.util.Comparator;

public class GetMaxSalaryCommand extends BaseCommand {

    private final BaseRepository<Employee> repository;

    public GetMaxSalaryCommand() {
        super("get-max-salary", "Returns employee with highest salary");
        repository = RepositoryHolder.getRepository();
    }

    @Override
    public void execute() {
        final var employees = repository.getAll();
        final var highestSalary = Collections.max(employees, Comparator.comparingDouble(Employee::getSalary));
        System.out.println(highestSalary);
    }
}
