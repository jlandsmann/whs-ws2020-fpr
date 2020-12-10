package de.jlandsmann.whs.fpr.personnelManagement.management.commands;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Employee;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.BaseRepository;
import de.jlandsmann.whs.fpr.personnelManagement.management.utils.RepositoryHolder;

import java.time.LocalDate;
import java.util.Scanner;

public class CreateCommand extends BaseCommand {

    private final Scanner scanner;
    private final BaseRepository<Employee> repository;

    public CreateCommand() {
        super("create", "Erstellt einen Angestellten");
        repository = RepositoryHolder.getRepository();
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        final var id = askForId();
        final var name = askForName();
        final var salary = askForSalary();
        Employee employee = new Employee(id, name, LocalDate.now(), salary);
        repository.create(employee);
    }

    private String askForId() {
        print("Geben Sie eine ID ein:");
        return scanner.next();
    }

    private String askForName() {
        print("Geben Sie einen Namen ein:");
        return scanner.next();
    }

    private double askForSalary() {
        print("Geben Sie ein Gehalt ein:");
        return scanner.nextDouble();
    }

    private void print(String str) {
        System.out.println(str);
    }
}
