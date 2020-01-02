package view;

import controller.DeleteControllerImpl;
import controller.DeleteEmployee;
import controller.NewEmployeeController;
import controller.NewEmployeeControllerImpl;
import model.Employee;
import model.EmployeeModel;
import model.TableObserver;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Vector;

public class EmployeesView extends JFrame implements TableObserver {
    private JPanel rootpanel;
    private JTable employeesTable;
    private EmployeesTableModel employeesTableModel;
    private EmployeeModel model;
    private JButton deleteButton;
    private JButton addButton;
    private JCheckBox editCheckbox;

    public  EmployeesView(EmployeeModel model)
    {
        this.model = model;
        this.model.registerObserver(this);
        setTitle("Emlpoyees Manager");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootpanel);
        setPreferredSize(new Dimension(400, 500));
        pack();
        setVisible(true);
        employeesTableModel = new EmployeesTableModel();
        employeesTable.setModel(employeesTableModel);
        List<Employee> employees = this.model.getAllEmployee();
        employeesTableModel.updateEmployees(employees);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                onAddEmploee(e);
            }
        });


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDeleteEmployee(e);
            }
        });

        employeesTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onEmployeesTableClicked(e);
            }
        });
    }
    private void onEmployeesTableClicked(MouseEvent e) {
        if(!editCheckbox.isSelected())

            return;
            if(e.getClickCount() > 1)
            {

                int rowIndex = employeesTable.columnAtPoint(e.getPoint());
                if(rowIndex != -1)
                {
                    UpdateEmployee updateEmployee = new UpdateEmployee();
                    updateEmployee.SetID(employeesTableModel.getValueAt(rowIndex,0).toString());
                    updateEmployee.setFullname(employeesTableModel.getValueAt(rowIndex,1).toString());
                    updateEmployee.setGenderer(employeesTableModel.getValueAt(rowIndex,2).toString());

                    int option = JOptionPane.showConfirmDialog(
                            this,updateEmployee.getRootPanel(),
                            "Edit Employee",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE);
                    if(option == JOptionPane.YES_OPTION)
                    {
                        String[] employees ={updateEmployee.getID(),updateEmployee.getFullNam(),updateEmployee.getGender()};
                        Employee[] objectList = new Employee[employees.length];
                        System.out.println(employees);

                        employeesTableModel.editEmployee(rowIndex,objectList);

                    }

                }
            }
    }
    private void onAddEmploee(ActionEvent e) {
        NewEmployeeController controller = new NewEmployeeControllerImpl(this,model,new NewEmployee());
        controller.NewEmployee();
    }
    private  void onDeleteEmployee(ActionEvent e)
    {
        int row = employeesTable.getSelectedRow();
        String valueID=(employeesTable.getModel().getValueAt(row,0).toString());
        int ID = Integer.parseInt(valueID);
        employeesTableModel.deleteEmployee(ID,row);
    }

    @Override
    public void updateTable(List<Employee> employees) {

        employeesTableModel.updateEmployees(employees);
    }

    @Override
    public void deleteTable(Employee i,int row) {
        employeesTableModel.deleteEmployee(i.getId(),row);
    }

    @Override
    public void editTable(List<Employee> employees) {

    }
}
