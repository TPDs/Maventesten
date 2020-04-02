import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {


    private Connection conn;

    public EmployeeDAO(Connection conn) {
        this.conn=conn;

    }


    public EmployeeDTO getSingleEmployeeById(int id){
        EmployeeDTO objectToReturn = new EmployeeDTO();

        try{
            PreparedStatement getSingleStatement = conn.prepareStatement("select * from emp where empno=?");
            getSingleStatement.setInt(1,id);
            ResultSet singleEmployee = getSingleStatement.executeQuery();
            while (singleEmployee.next()) {
                objectToReturn.setEmpno(singleEmployee.getInt("empno"));
                objectToReturn.setEname(singleEmployee.getString("ename"));
                objectToReturn.setJob(singleEmployee.getString("job"));
                objectToReturn.setMgr(singleEmployee.getInt("mgr"));
                objectToReturn.setHiredate(singleEmployee.getDate("hiredate"));
                objectToReturn.setSale(singleEmployee.getInt("sale"));
                objectToReturn.setComm(singleEmployee.getInt("comm"));
                objectToReturn.setDeptno(singleEmployee.getInt("deptno"));

            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return objectToReturn;
    }


}
