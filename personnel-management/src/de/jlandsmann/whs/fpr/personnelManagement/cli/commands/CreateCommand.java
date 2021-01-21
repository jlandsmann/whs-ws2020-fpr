package de.jlandsmann.whs.fpr.personnelManagement.cli.commands;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Employee;
import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Manager;
import de.jlandsmann.whs.fpr.personnelManagement.domain.utils.RepositoryHolder;

import java.time.LocalDate;
import java.util.Scanner;

public class CreateCommand extends BaseCommand {

    private final Scanner scanner;

    public CreateCommand() {
        super("create", "Erstellt einen Angestellten");
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        final var createManager = askForCreateManager();
        final var id = askForId();
        final var name = askForName();
        final var salary = askForSalary();

        if (createManager) {
            final var bonus = askForBonus();
            Manager manager = new Manager(id, name, LocalDate.now(), salary, bonus);
            RepositoryHolder.employeeRepository.create(manager);
        } else {
            Employee employee = new Employee(id, name, LocalDate.now(), salary);
            RepositoryHolder.employeeRepository.create(employee);
        }
    }

    private boolean askForCreateManager() {
        String pattern = "^y|n";
        String result = "n";
        do {
            print("Wollen Sie einen Manager erstellen?: (y/n)");
            result = scanner.next();
        } while (!result.matches(pattern));
        return "y".equals(result);
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

    private double askForBonus() {
        print("Geben Sie einen Bonus ein:");
        return scanner.nextDouble();
    }

    private void print(String str) {
        System.out.println(str);
    }
}
