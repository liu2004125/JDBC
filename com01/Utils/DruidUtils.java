package com01.Utils;

import java.io.FileReader;
import java.net.URL;
import java.sql.*;
import javax.sql.DataSource;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidUtils {
    private static DataSource ds;

    static {

        try {
            //1. 创建Properties集合类。
            Properties properties = new Properties();

            //获取src路径下的文件的方式--->ClassLoader 类加载器
            ClassLoader classLoader = DruidUtils.class.getClassLoader();
            URL res  = classLoader.getResource("Druid.properties");
            ds = DruidDataSourceFactory.createDataSource(properties);
            String path = res.getPath();
            //2. 加载文件
            properties.load(new FileReader(path));
            //注册驱动

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    /**
     * 获取连接
     * @return 连接对象
     */
//    public static Connection getConnection() throws SQLException {
//
//        return DriverManager.getConnection(url, user, password);
//    }




    /**
     * 释放资源
     * @param statement
     * @param connection
     */

    public static void close(Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    /**
     * 释放资源
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void close(Statement statement, Connection connection, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
