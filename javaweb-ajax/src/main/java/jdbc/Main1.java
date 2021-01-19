package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/springboot?useUnicode=true&characterEncoding=UTF-8";
            String username = "root";
            String password = "123456";

            Connection con = DriverManager.getConnection(url, username, password);
            //增 删 改 都与此类似
            String sql1 = "insert into book (author,name) values ('薛之谦','动物世界')";
            Statement statement = con.createStatement();
            int row = statement.executeUpdate(sql1);
            System.out.println(row);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
