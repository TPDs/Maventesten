import java.io.IOException;
import java.sql.*;

public class JDBC {
    public static void main(String[] args) throws SQLException, IOException {

        DatabaseConnectionManager data = new DatabaseConnectionManager();

        Connection forbindelse = data.getConnection();

        Statement mitstate = forbindelse.createStatement();


        String getall = "select * from dept";
        ResultSet all = mitstate.executeQuery(getall);


        ResultSetMetaData meta = all.getMetaData();
        int colun = meta.getColumnCount();
        System.out.println(meta.getColumnName(1));


        while (all.next()) {
            System.out.println(all.getInt("deptno"));

        }

        for (int i = 1; i <= colun; i++) {
            System.out.println(all.getMetaData().getColumnName(i) + " ");
        }


    }

}

