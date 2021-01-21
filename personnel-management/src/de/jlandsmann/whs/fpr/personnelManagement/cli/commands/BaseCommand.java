package de.jlandsmann.whs.fpr.personnelManagement.cli.commands;

public abstract class BaseCommand {
    private final String name;
    private final String description;

    BaseCommand(String commandName, String description) {
        this.name = commandName;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}
