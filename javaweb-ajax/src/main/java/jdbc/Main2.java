package jdbc;

import java.sql.*;

public class Main2 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/springboot?useUnicode=true&characterEncoding=UTF-8";
            String username = "root";
            String password = "123456";

            Connection con = DriverManager.getConnection(url, username, password);
            String sql1 = "select * from book";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql1);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String author = resultSet.getString("author");
                String name = resultSet.getString("name");
                System.out.println(id + "-" + author + "-" + name);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
