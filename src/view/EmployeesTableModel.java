package view;

import model.Employee;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;
import model.EmployeeDaoImpl;

public class EmployeesTableModel extends AbstractTableModel {

    private List<Employee> employees = new Vector<>();
    private List<Employee[]> employeess;
    EmployeeDaoImpl abc = new EmployeeDaoImpl();
    private static final String[] COLUMN_NAMES = {"ID","FullName","Gender"};
    private static final int ID = 0;
    private static final int FULL_NAME = 1;
    private static final int GEN_DER = 2;

    @Override
    public int getRowCount() {
        return employees.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee = employees.get(rowIndex);
        if (columnIndex == ID) {
            return employee.getId();
        } else if (columnIndex == FULL_NAME) {
            return employee.getFullName();
      }else if (columnIndex == GEN_DER){
        return employee.getGenDer();
      }
        return null;
    }
    public void updateEmployees(List<Employee> employees) {
        this.employees.clear();
        this.employees.addAll(employees);
        fireTableDataChanged();
    }

    public void deleteEmployee(int i, int row) {
        Employee md = new Employee();
        md.setId(i);
        this.employees.remove(row);
        abc.deleteEmloyee(md);
        fireTableDataChanged();
    }

    public void editEmployee(int rowIndex, Employee[] employee) {
        Employee[] dataRow = employeess.get(rowIndex);
        for (int column = 0; column < dataRow.length; column++) {
            dataRow[column] = employee[column];
        }
    }

}
