import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DatabaseConnectionManager {
    private final String HOST;
    private final String USERNAME;
    private final String PASSWORD;


    public DatabaseConnectionManager() throws IOException {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String pat = rootPath + "application.properties";
        Properties ny = new Properties();
        ny.load(new FileInputStream(pat));
        String nyuser = ny.getProperty("db.username");
        String nypassword = ny.getProperty("db.password");
        String nyhost = ny.getProperty("db.host");

        this.USERNAME = nyuser;
        this.PASSWORD = nypassword;
        this.HOST = nyhost;


    }

    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(HOST,USERNAME,PASSWORD);


    }



}
