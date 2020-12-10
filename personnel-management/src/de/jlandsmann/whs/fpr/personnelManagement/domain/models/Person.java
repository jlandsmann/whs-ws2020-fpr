package de.jlandsmann.whs.fpr.personnelManagement.domain.models;

import java.util.Objects;

public abstract class Person extends BaseResource {
    private final String name;

    public Person(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName());
    }

    @Override
    public String toString() {
        return super.toString() + " | " + this.getName();
    }
}
