package de.jlandsmann.whs.fpr.personnelManagement.domain.models;

public abstract class Properties {

    public interface Size {
        String getSize();
        void setSize(String size);
    }

    public interface Age {
        int getAge();
    }
}
