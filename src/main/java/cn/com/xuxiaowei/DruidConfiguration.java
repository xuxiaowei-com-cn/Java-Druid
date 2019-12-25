package cn.com.xuxiaowei;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Druid 示例
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
public class DruidConfiguration {

    public static void main(String[] args) {

        DruidConfiguration druidConfiguration = new DruidConfiguration();

        druidConfiguration.mysql();

        druidConfiguration.oracle();

    }

    public void mysql() {

        // 创建连接池示例
        DruidDataSource dataSource = new DruidDataSource();

        // 设置连接池所需驱动
        dataSource.setDriverClassName(com.mysql.cj.jdbc.Driver.class.getName());

        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/druid?useSSL=false&serverTimezone=GMT%2B8");

        dataSource.setUsername("root");

        dataSource.setPassword("root");

        // 设置连接池初始连接数
        dataSource.setInitialSize(5);

        // 设置连接池最少的空闲连接数
        dataSource.setMinIdle(2);

        try (Connection connection = dataSource.getConnection()) {

            System.out.println(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void oracle() {

        // 创建连接池示例
        DruidDataSource dataSource = new DruidDataSource();

        // 设置连接池所需驱动
        dataSource.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());

        dataSource.setUrl("jdbc:oracle:thin:@192.168.8.128:1521:ORCL");

        dataSource.setUsername("scott");

        dataSource.setPassword("orcl");

        // 设置连接池初始连接数
        dataSource.setInitialSize(5);

        // 设置连接池最少的空闲连接数
        dataSource.setMinIdle(2);

        try (Connection connection = dataSource.getConnection()) {

            System.out.println(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
