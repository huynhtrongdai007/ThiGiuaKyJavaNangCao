package model;

import java.util.List;
import java.util.Vector;

public class EmployeesModelImpl implements EmployeeModel {
    private List<TableObserver>tableObservers= new Vector<>();

    @Override
    public List<Employee> getAllEmployee() {
        EmployeeDao dao =new EmployeeDaoImpl();
        return dao.getAllEmployees();
    }

    @Override
    public void addEmployee(Employee employee) {
        EmployeeDao dao = new EmployeeDaoImpl();
        dao.insertEmloyee(employee);

    }

    @Override
    public void deleteEmployee(Employee id) {
            EmployeeDao dao = new EmployeeDaoImpl();
            dao.deleteEmloyee(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        EmployeeDao dao = new EmployeeDaoImpl();
        dao.updateEmployee(employee);
    }

    @Override
    public void registerObserver(TableObserver observer) {
        if (!tableObservers.contains(observer))
            tableObservers.add(observer);
    }

    @Override
    public void unregisterObserver(TableObserver observer) {
            tableObservers.remove(observer);
    }

    private void notifyObservers() {
        List<Employee> employees = getAllEmployee();
        for (TableObserver observer: tableObservers) {
            observer.updateTable(employees);
        }
    }
}
