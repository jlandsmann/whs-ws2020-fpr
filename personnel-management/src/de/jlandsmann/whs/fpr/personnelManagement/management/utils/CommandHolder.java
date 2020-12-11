package de.jlandsmann.whs.fpr.personnelManagement.management.utils;

import de.jlandsmann.whs.fpr.personnelManagement.management.commands.*;

import java.util.Arrays;
import java.util.Collections;

public class CommandHolder {

    private static final BaseCommand[] commands = {
            new GetAllCommand(),
            new CreateCommand(),
            new CheckDuplicateCommand(),
            new GetMinSalaryCommand(),
            new GetMaxSalaryCommand()
    };

    public static BaseCommand getCommandByName(String name) {
        return Arrays.stream(CommandHolder.commands)
                .filter(cmd -> cmd.getName().equals(name))
                .findFirst()
                .orElseThrow()
        ;
    }

    public static boolean existsCommand(String name) {
        return Arrays.stream(CommandHolder.commands)
                .anyMatch(cmd -> cmd.getName().equals(name))
        ;
    }

}
