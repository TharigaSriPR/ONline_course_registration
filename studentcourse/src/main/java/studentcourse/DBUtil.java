package studentcourse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/course_registration_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Thari@15171819";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
    	
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	
    	
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}


