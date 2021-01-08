package de.jlandsmann.whs.fpr.personnelManagement.storage;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Manager;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.ManagerRepository;
import de.jlandsmann.whs.fpr.personnelManagement.domain.utils.Pair;

import java.util.Collections;
import java.util.Comparator;

public class ManagerStorage<T extends Manager> extends EmployeeStorage<T> implements ManagerRepository<T> {

    @Override
    public Pair<T> getMinMaxBonusPair() {
        final var min = this.getMinBonus();
        final var max = this.getMaxBonus();
        return new Pair<>(min, max);
    }

    private T getMinBonus() {
        return Collections.min(this.collection, Comparator.comparingDouble(Manager::getBonus));
    }

    private T getMaxBonus() {
        return Collections.max(this.collection, Comparator.comparingDouble(Manager::getBonus));
    }
}
