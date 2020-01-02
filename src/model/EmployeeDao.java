package model;

import java.util.List;

public interface EmployeeDao  {
    // Create
void insertEmloyee(Employee employee);

Employee getEmloyeeById(int id);
    // Read
List<Employee> getAllEmployees();

//Update
void updateEmployee(Employee employee);
//Delete
void deleteEmloyee(Employee id);

}
