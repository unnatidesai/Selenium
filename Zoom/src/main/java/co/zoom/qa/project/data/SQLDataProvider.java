package co.zoom.qa.project.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDataProvider {
    private Connection connection;

    public SQLDataProvider() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://host1:33060/sakila");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


}
