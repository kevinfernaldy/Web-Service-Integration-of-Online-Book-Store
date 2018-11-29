

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DbConnection {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = DbConfig.DB_URL;
    private static final String USER = DbConfig.USER;
    private static final String PASS = DbConfig.PASS;

    private static Connection conn;

    public static Connection getConnection() throws Exception {
        if (conn == null) {
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                if(conn != null) {
                    System.out.println("Success");
                } else {
                    System.out.println("Failed");
                }
            }
            catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public void disconnect() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
