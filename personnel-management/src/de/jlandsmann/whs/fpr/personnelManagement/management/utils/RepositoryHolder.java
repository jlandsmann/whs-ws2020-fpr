package de.jlandsmann.whs.fpr.personnelManagement.management.utils;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Employee;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.BaseRepository;

public class RepositoryHolder {
    private static BaseRepository<Employee> repository;

    public static void setRepository(BaseRepository<Employee> repository) {
        RepositoryHolder.repository = repository;
    }

    public static BaseRepository<Employee> getRepository() {
        return repository;
    }
}
