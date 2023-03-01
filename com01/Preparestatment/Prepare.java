package com01.Preparestatment;

import java.sql.*;
import java.util.Scanner;

public class Prepare {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/jiayao?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url,"root","2004125");

        String sql1 = "select * from people";
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        ResultSet resultSet = preparedStatement.executeQuery();
        select(resultSet);
//
//        Scanner in = new Scanner(System.in);
//        int id = in.nextInt();
//        String name = in.next();
//        String sex = in.next();
//
//        String sql = "insert into people values(?,?,?)";
//        PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
//        preparedStatement1.setInt(1,id);
//        preparedStatement1.setString(2,name);
//        preparedStatement1.setString(3,sex);
//        preparedStatement1.executeUpdate();
        resultSet = preparedStatement.executeQuery();
        select(resultSet);

        resultSet.close();
        connection.close();
        preparedStatement.close();
    }
    public static void select(ResultSet resultSet) throws SQLException {
        while(resultSet.next()){
            System.out.println("id=" + resultSet.getInt(1));
            System.out.println("name=" + resultSet.getString(2));
            System.out.println("sex=" + resultSet.getString(3));
        }
    }
}
