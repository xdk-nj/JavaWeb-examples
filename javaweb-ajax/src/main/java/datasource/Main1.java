package datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main1 {

    public static void main(String[] args) {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/springboot?useUnicode=true&characterEncoding=UTF-8");
            dataSource.setUser("root");
            dataSource.setPassword("123456");
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (PropertyVetoException | SQLException e) {
            e.printStackTrace();
        }
    }
}
