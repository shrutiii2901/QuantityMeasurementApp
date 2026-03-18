package support;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {


    public static Connection getConnection() {
    try {
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/quantitymeasurementdb",
            "root",
            ""
        );

        System.out.println("✅ Database Connected Successfully!");
        return conn;

    } catch (Exception e) {
        System.out.println("❌ Connection Failed");
        e.printStackTrace();
        return null;
    }
}
}