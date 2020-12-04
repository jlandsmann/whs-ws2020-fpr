package de.jlandsmann.whs.fpr.personnelManagement.domain.models;

public class BaseResource {
    private final String id;

    BaseResource(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
