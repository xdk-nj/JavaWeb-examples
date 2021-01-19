package transaction;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main1 {

    public static void main(String[] args) {
        ComboPooledDataSource dataSource = new ComboPooledDataSource("testc3p0");
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            //JDBC中默认事务是自动提交的，false就不会自动提交
            connection.setAutoCommit(false);
            PreparedStatement ps1 = connection.prepareStatement("insert into  book (author, name) values(?,?) ");
            PreparedStatement ps2 = connection.prepareStatement("insert into  book (author, name) values(?,?) ");


            ps1.setString(1, "薛之谦");
            ps1.setString(2, "狐狸");

            ps2.setString(1, "薛之谦");
            ps2.setString(2, "摩天大楼");
            ps1.execute();

            //模拟异常
            int i = 1 / 0;
            ps2.execute();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                connection.commit();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
