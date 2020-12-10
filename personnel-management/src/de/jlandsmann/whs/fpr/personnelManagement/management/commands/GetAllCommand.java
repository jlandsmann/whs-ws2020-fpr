package de.jlandsmann.whs.fpr.personnelManagement.management.commands;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Employee;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.BaseRepository;
import de.jlandsmann.whs.fpr.personnelManagement.management.utils.RepositoryHolder;

import java.util.Collection;

public class GetAllCommand extends BaseCommand {

    private final BaseRepository<Employee> repository;

    public GetAllCommand() {
        super("list", "Zeige alle Mitarbeiter an.");
        repository = RepositoryHolder.getRepository();
    }

    @Override
    public void execute() {
        int size = repository.getSize();
        Collection<Employee> collection = repository.getResultSet(0, size);
        this.printAll(collection);
    }

    private void printAll(Collection<Employee> collection) {
        collection.forEach(this::print);
    }

    private void print(Employee employee) {
        System.out.println(employee.toString());
    }
}
