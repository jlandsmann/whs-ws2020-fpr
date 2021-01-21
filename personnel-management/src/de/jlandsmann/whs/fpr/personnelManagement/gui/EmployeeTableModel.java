package de.jlandsmann.whs.fpr.personnelManagement.gui;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Employee;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.EmployeeRepository;
import de.jlandsmann.whs.fpr.personnelManagement.domain.utils.RepositoryHolder;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;

public class EmployeeTableModel extends AbstractTableModel {

    private final EmployeeRepository repository;

    private final String[] columnNames = {
            "ID", "Name", "Salary", "Employee since"
    };

    public EmployeeTableModel() {
        repository = RepositoryHolder.employeeRepository;
    }

    @Override
    public int getRowCount() {
        return this.repository.getSize();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return double.class;
            case 3:
                return LocalDate.class;
            default:
                throw new IllegalStateException("column does not exist");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee = repository.getAll().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return employee.getId();
            case 1:
                return employee.getName();
            case 2:
                return employee.getSalary();
            case 3:
                return employee.getEmployeeSince();
            default:
                throw new IllegalStateException("column does not exist");
        }
    }
}
