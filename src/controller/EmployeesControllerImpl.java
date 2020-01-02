package controller;


import model.Employee;
import model.EmployeeModel;
import view.EmployeesView;

public class EmployeesControllerImpl implements EmployeeController{

    private EmployeesView view;
    public EmployeesControllerImpl(EmployeeModel model)
    {
        this.view = new EmployeesView(model);
    }




}
