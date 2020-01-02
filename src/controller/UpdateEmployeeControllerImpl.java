package controller;

import model.Employee;
import model.EmployeeModel;
import view.NewEmployee;
import view.UpdateEmployee;

import javax.swing.*;
import java.awt.*;

public class UpdateEmployeeControllerImpl implements UpdateEmployeeController {

    private Component parent;
    private EmployeeModel model;
    private UpdateEmployee view;

    public UpdateEmployeeControllerImpl(Component parent,EmployeeModel model, UpdateEmployee view)
    {
        this.parent = parent;
        this.model = model;
        this.view = view;
    }


    @Override
    public void UpdateEmployee() {
        int Option = JOptionPane.showConfirmDialog(parent,view.getRootPanel(),"Update Employee",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (Option == JOptionPane.YES_OPTION) {
            String fullName = view.getFullNam();
           // boolean gender = view.getGender();
           // boolean gender = view.getGender();

            Employee employee = new Employee();
            employee.setFullName(fullName);
           // employee.setGenDer(gender);
            //student.setBirthYear(birthYear);
            model.updateEmployee(employee);
        }
    }
}
