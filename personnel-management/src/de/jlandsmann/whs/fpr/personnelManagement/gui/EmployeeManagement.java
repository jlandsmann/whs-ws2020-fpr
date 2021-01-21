package de.jlandsmann.whs.fpr.personnelManagement.gui;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.Employee;
import de.jlandsmann.whs.fpr.personnelManagement.domain.utils.RepositoryHolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class EmployeeManagement extends JFrame {

    private JButton jButton1;
    private EmployeeTable employeeTable;

    public EmployeeManagement() {
        this.initJFrame();
        this.initComponents();
    }

    private void initJFrame() {
        this.setTitle("Employee Management");
        this.setSize(720, 1280);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        this.setLayout(new FlowLayout(FlowLayout.LEADING));

        jButton1 = new javax.swing.JButton();
        jButton1.setText("Hire Employee");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RepositoryHolder.employeeRepository.create(
                        new Employee("1234", "Test", LocalDate.now(), 1234.90)
                );
                employeeTable.updateUI();
            }
        });
        this.getContentPane().add(jButton1);

        employeeTable = new EmployeeTable();
        this.add(new JScrollPane(employeeTable));


    }
}
