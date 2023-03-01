package com01;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class connect {
    static final String url ="jdbc:mysql://localhost:3306/jiayao?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //静态加载
        //Driver driver = new com.mysql.cj.jdbc.Driver();
        String str ="com.mysql.cj.jdbc.Driver";
        //动态加载
        Class<?> dr = Class.forName(str);
        Driver driver = (Driver) dr.newInstance();

        //使用DriverManger
        DriverManager.registerDriver(driver);
        Connection connections = DriverManager.getConnection(url,"root","2004125");

        //使用class forname自动注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,"root","2004125");

        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","2004125");

        Connection connection = driver.connect(url,properties);
        System.out.println(connection);
        System.out.println(connections);
        System.out.println(conn);
        connection.close();
        connections.close();
        conn.close();

    }


}
