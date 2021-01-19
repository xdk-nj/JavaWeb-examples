package dbutils;

import bean.Book;
import bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class main1 {

    public static void main(String[] args) {
        ComboPooledDataSource dataSource = new ComboPooledDataSource("testc3p0");
        try {
            Connection connection = dataSource.getConnection();
            String sql = "select * from book where id = 1";
            QueryRunner queryRunner = new QueryRunner();
            Book book = queryRunner.query(connection, sql, new BeanHandler<>(Book.class));
            System.out.println(book);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
