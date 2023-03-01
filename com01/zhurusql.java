package com01;

import java.sql.*;

public class zhurusql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/jiayao?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =DriverManager.getConnection(url,"root","2004125");

        //statement 接受由mysql返回的连接信息
        Statement statement = connection.createStatement();
        String sql = "show tables";
        //resulesrt 接受mysql的行信息
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            //int id = resultSet.getInt("id");
            String name = resultSet.getString(1);
           // String sex = resultSet.getString("sex");
         //   System.out.print("ID: " + id);
            System.out.print(", 名字: " + name);
           // System.out.print(", 性别: " + sex);
            //System.out.print("\n");
        }
        statement.close();
        connection.close();
        resultSet.close();
    }
}
