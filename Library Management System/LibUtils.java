import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class LibUtils {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream("D:\\PROJECTS\\Library Management System\\DBProperties");
            prop.load(fis);
            String driverName = prop.getProperty("DBDriver");
            Class.forName(driverName);
            String dbName = prop.getProperty("DBName");
            String User = prop.getProperty("User");
            String Password = prop.getProperty("Password");
            con = DriverManager.getConnection(dbName, User, Password);
            return con;
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            if( con == null)
            {
                try
                {
                    con.close();
                }catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
