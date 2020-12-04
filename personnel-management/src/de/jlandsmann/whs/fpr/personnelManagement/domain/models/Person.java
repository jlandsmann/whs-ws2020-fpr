package de.jlandsmann.whs.fpr.personnelManagement.domain.models;

public abstract class Person extends BaseResource {
    private final String name;

    public Person(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
