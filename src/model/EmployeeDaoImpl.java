package model;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

public class EmployeeDaoImpl implements EmployeeDao {

public EmployeeDaoImpl(){
        DataBase db = new DataBase();
String SQL_CREATE_EMPLOYEES_TABLE = "CREATE TABLE IF NOT EXISTS EmployeeTable (\n"
        + "    ID integer PRIMARY KEY,\n"
        + "    FullName text NOT NULL,\n"
        + "    Gender boolean \n"
        + ");";

    try{
        Statement statement = db.getConnection().createStatement();
        statement.execute(SQL_CREATE_EMPLOYEES_TABLE);

    }
    catch (SQLException e)
    {
        e.printStackTrace();
    }
    db.close();
}


    @Override
    public void insertEmloyee(Employee employee) {
        DataBase db = new DataBase();
final  String SQL_CREATE_EMPLOYEE = "INSERT INTO EmployeeTable(FullName,Gender)" +
                " VALUES(?,?)";

    try {
        PreparedStatement ps = db.getConnection().prepareStatement(SQL_CREATE_EMPLOYEE,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,employee.getFullName());
        ps.setBoolean(2,employee.getGenDer());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next())
        {
            int id=rs.getInt(1);
            employee.setId(id);
            System.out.println("Insert " + id);
        }
    }
    catch (SQLException e)
    {
        e.printStackTrace();
    }
    db.close();
}

    @Override
    public Employee getEmloyeeById(int id) {
    Employee employee =null;
    DataBase db = new DataBase();
    final String SQL_SELECT_EMPLOYEE_BY_ID = "SELECT * FROM EmployeeTable WHERE ID = ?";
    try {
    PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT_EMPLOYEE_BY_ID);
    ps.setInt(1,id);
        ResultSet rs =ps.executeQuery();
        if(rs.next())
        {
            int employeeId =rs.getInt(1);
            String fullName = rs.getString(2);
            boolean genDer = rs.getBoolean(3);
            employee = new Employee(employeeId,fullName,genDer);
            System.out.println("ID: " + employeeId + ", Full name: " + fullName + ", Gender: " + genDer);

        }
    }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        db.close();
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
    List<Employee> employees = new Vector<>();
      DataBase db = new DataBase();
        final String SQL_SELECT_ALL_EMPLOYEES = "SELECT * FROM EmployeeTable";
        try {
            Statement statement = db.getConnection().createStatement();

            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_EMPLOYEES);
            while (rs.next()) {

                int id = rs.getInt(1);
                String fullName = rs.getString(2);
                boolean genDer = rs.getBoolean(3);
                Employee employee = new Employee(id, fullName, genDer);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.close();

        return employees;

    }

    @Override
    public void updateEmployee(Employee employee) {
        DataBase db = new DataBase();
        String SQL_UPDATE_EMPLOYEES = "UPDATE EmployeeTable SET FullName = ?, Gender = ? WHERE ID = ?";
        try {
            System.out.println(employee.getId());
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_EMPLOYEES);

            ps.setString(1,employee.getFullName());
            ps.setBoolean(2,employee.getGenDer());
            ps.setInt(3,employee.getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void deleteEmloyee(Employee employee) {
        DataBase db = new DataBase();
        String SQL_DELETE_EMPLOYEES = "DELETE FROM EmployeeTable WHERE ID = ?";
        try {
            System.out.println(employee.getId());
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE_EMPLOYEES);
            ps.setInt(1,employee.getId());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        db.close();


    }
}
