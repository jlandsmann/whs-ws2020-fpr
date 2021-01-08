package de.jlandsmann.whs.fpr.personnelManagement.storage;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Employee;
import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Manager;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.EmployeeRepository;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.ManagerRepository;
import de.jlandsmann.whs.fpr.personnelManagement.domain.utils.Pair;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class EmployeeStorage extends BaseInMemoryStorage<Employee> implements EmployeeRepository, ManagerRepository {

    @Override
    public Employee getMinSalary() {
        return Collections.min(this.collection, Comparator.comparingDouble(Employee::getSalary));
    }

    @Override
    public Employee getMaxSalary() {
        return Collections.max(this.collection, Comparator.comparingDouble(Employee::getSalary));
    }

    @Override
    public Pair<Manager> getMinMaxBonusPair() {
        final var min = this.getMinBonus();
        final var max = this.getMaxBonus();
        return new Pair<>(min, max);
    }

    private Manager getMinBonus() {
        final var managers = getManagers();
        return Collections.min(managers, Comparator.comparingDouble(Manager::getBonus));
    }

    private Manager getMaxBonus() {
        final var managers = getManagers();
        return Collections.max(managers, Comparator.comparingDouble(Manager::getBonus));
    }

    private Collection<Manager> getManagers() {
        return this.collection.stream()
                .filter(employee -> employee instanceof Manager)
                .map(manager -> (Manager) manager)
                .collect(Collectors.toList());
    }
}
