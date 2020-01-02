package controller;

import model.Employee;
import model.EmployeeModel;

import javax.swing.*;

public class DeleteControllerImpl implements DeleteEmployee {

    private EmployeeModel model;



    @Override
    public void DeleteEmployee(Employee i) {
        model.deleteEmployee(i);
    }

    @Override
    public void getEmloyeeById(Employee i) {

    }


}
