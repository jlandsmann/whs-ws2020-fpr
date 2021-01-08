package de.jlandsmann.whs.fpr.personnelManagement.domain.models;

import java.util.Objects;

public class BaseResource {
    private final String id;

    BaseResource(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseResource)) return false;
        BaseResource that = (BaseResource) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return this.getId();
    }
}
