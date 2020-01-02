import controller.EmployeeController;
import controller.EmployeesControllerImpl;
import model.EmployeeModel;
import model.EmployeesModelImpl;
import view.EmployeesView;

public class Main {

    public static void main(String[] args) {
        EmployeeModel model = new EmployeesModelImpl();
        EmployeeController controller = new EmployeesControllerImpl(model);
    }
}
