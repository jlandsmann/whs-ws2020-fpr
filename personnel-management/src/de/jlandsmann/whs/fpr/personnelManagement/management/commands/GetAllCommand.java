package de.jlandsmann.whs.fpr.personnelManagement.management.commands;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.BaseResource;
import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Employee;
import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Person;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.BaseRepository;
import de.jlandsmann.whs.fpr.personnelManagement.management.utils.RepositoryHolder;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class GetAllCommand extends BaseCommand {

    private final BaseRepository<Employee> repository;
    private final Scanner scanner;

    public GetAllCommand() {
        super("list", "Zeige alle Mitarbeiter an.");
        repository = RepositoryHolder.getRepository();
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        int size = repository.getSize();
        final var sortProperty = askForSortProperty();
        final var comparator = getComparatorByProperty(sortProperty);
        final var collection = repository.getResultSet(0, size);
        collection.sort(comparator);
        this.printAll(collection);
    }

    private Comparator<? super Employee> getComparatorByProperty(String sortProperty) {
        return switch (sortProperty) {
            case "id" -> Comparator.comparing(BaseResource::getId);
            case "name" -> Comparator.comparing(Person::getName);
            case "employeeSince" -> Comparator.comparing(Employee::getEmployeeSince);
            case "salary" -> Comparator.comparingDouble(Employee::getSalary);
            default -> throw new IllegalStateException();
        };
    }

    private String askForSortProperty() {
        System.out.println("Geben Sie die Eigenschaft ein, nach der Sie sortieren wollen:");
        return scanner.next();
    }

    private void printAll(Collection<Employee> collection) {
        collection.forEach(this::print);
    }

    private void print(Employee employee) {
        System.out.println(employee.toString());
    }
}
