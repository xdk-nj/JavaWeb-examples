package jdbc;

import java.sql.*;

public class Main3 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/springboot?useUnicode=true&characterEncoding=UTF-8";
            String username = "root";
            String password = "123456";

            Connection con = DriverManager.getConnection(url, username, password);

            String sql1 = "select * from book where id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql1);
            preparedStatement.setInt(1, 2);
            System.out.println(sql1);
            ResultSet resultSet = preparedStatement.executeQuery();
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
