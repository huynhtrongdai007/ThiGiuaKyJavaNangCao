package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private final static String DB_PATH = "employeesmanager.db";
    private Connection connection;

    public DataBase()
    {
        final String url = "jdbc:sqlite:" + DB_PATH;
        try
        {
            connection = DriverManager.getConnection(url);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

        public Connection getConnection(){return connection;}

        public void close()
        {
            if(connection != null)
            {
                try {
                    connection.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }

}
