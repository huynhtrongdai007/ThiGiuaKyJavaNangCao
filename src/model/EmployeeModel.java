package model;

import java.util.List;

public interface EmployeeModel {
    List<Employee> getAllEmployee();
    void addEmployee(Employee employee);
    void deleteEmployee(Employee id);
    void updateEmployee(Employee employee);
    void registerObserver(TableObserver observer);
    void unregisterObserver(TableObserver observer);
}
