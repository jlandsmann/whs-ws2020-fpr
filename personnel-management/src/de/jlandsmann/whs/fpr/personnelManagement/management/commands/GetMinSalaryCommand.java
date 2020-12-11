package de.jlandsmann.whs.fpr.personnelManagement.management.commands;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Employee;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.BaseRepository;
import de.jlandsmann.whs.fpr.personnelManagement.management.utils.RepositoryHolder;

import java.util.Collections;
import java.util.Comparator;

public class GetMinSalaryCommand extends BaseCommand {

    private final BaseRepository<Employee> repository;

    public GetMinSalaryCommand() {
        super("get-min-salary", "Returns employee with lowest salary");
        repository = RepositoryHolder.getRepository();
    }

    @Override
    public void execute() {
        final var employees = repository.getAll();
        final var lowestSalary = Collections.min(employees, Comparator.comparingDouble(Employee::getSalary));
        System.out.println(lowestSalary);
    }
}
