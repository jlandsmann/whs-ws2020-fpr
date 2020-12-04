package de.jlandsmann.whs.fpr.personnelManagement.management.utils;

import de.jlandsmann.whs.fpr.personnelManagement.management.commands.BaseCommand;

import java.util.Scanner;

public class CommandReader {

    private final Scanner scanner;

    public CommandReader() {
        scanner = new Scanner(System.in);

    }

    public BaseCommand readCommand() {
        String commandName;
        do {
            System.out.println("Was möchten Sie als nächstes tun?");
            commandName = scanner.next();
        } while (!CommandHolder.existsCommand(commandName));
        return CommandHolder.getCommandByName(commandName);
    }
}
