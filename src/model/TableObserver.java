package model;

import java.util.List;

public interface TableObserver {
    void updateTable(List<Employee> employees);
    void deleteTable(Employee i,int row);
    void editTable(List<Employee> employees);

}
