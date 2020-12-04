package de.jlandsmann.whs.fpr.personnelManagement.management.utils;

import java.util.Scanner;

public class CommandReader {

    private final Scanner scanner;

    public CommandReader() {
        scanner = new Scanner(System.in);

    }

    public String readCommand() {
        System.out.println("Was möchten Sie als nächstes tun?");
        return scanner.next();
    }
}
