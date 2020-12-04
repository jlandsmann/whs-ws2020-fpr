package de.jlandsmann.whs.fpr.personnelManagement.management.utils;

import de.jlandsmann.whs.fpr.personnelManagement.management.commands.BaseCommand;
import de.jlandsmann.whs.fpr.personnelManagement.management.commands.GetAllCommand;

import java.util.Arrays;

public class CommandHolder {

    private static final BaseCommand[] commands = {
            new GetAllCommand()
    };

    public static BaseCommand getCommandByName(String name) {
        return Arrays.stream(CommandHolder.commands)
                .filter(cmd -> cmd.getName().equals(name))
                .findFirst()
                .orElseThrow()
        ;
    }

}
