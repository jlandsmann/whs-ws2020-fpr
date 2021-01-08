package de.jlandsmann.whs.fpr.personnelManagement.domain.stores;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Employee;

public interface EmployeeRepository extends BaseRepository<Employee> {

    Employee getMinSalary();

    Employee getMaxSalary();

}
