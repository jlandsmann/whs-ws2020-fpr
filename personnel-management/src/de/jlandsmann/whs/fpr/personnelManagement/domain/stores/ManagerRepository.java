package de.jlandsmann.whs.fpr.personnelManagement.domain.stores;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Manager;
import de.jlandsmann.whs.fpr.personnelManagement.domain.utils.Pair;

public interface ManagerRepository extends EmployeeRepository {

    public Pair<Manager> getMinMaxBonusPair();

}
