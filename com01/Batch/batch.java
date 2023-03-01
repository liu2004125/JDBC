package com01.Batch;

import com01.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class batch {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

//        try {
//            connection= JDBCUtils.getConnection();
//            String sql = "insert into people value(?,?,?)";
//            preparedStatement = connection.prepareStatement(sql);
//            for (int i = 0; i < 10; i++) {
//                String user = String.valueOf(110+i);
//                preparedStatement.setInt(1,i);
//                preparedStatement.setString(2,user);
//                preparedStatement.setString(3,"男");
//                preparedStatement.addBatch();
//            }
//            preparedStatement.executeBatch();
//            resultSet = preparedStatement.executeQuery("select * from people");
//            while(resultSet.next()){
//                System.out.print(resultSet.getInt(1)+" ");
//                System.out.print(resultSet.getString(2)+" ");
//                System.out.println();
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        } finally {
//            JDBCUtils.close(preparedStatement,connection,resultSet);
//        }

        try {
            connection= JDBCUtils.getConnection();
            String sql = "delete from people where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < 10; i++) {
                String user = String.valueOf(110+i);
                preparedStatement.setString(1,user);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            resultSet = preparedStatement.executeQuery("select * from people");
            while(resultSet.next()){
                System.out.print(resultSet.getInt(1)+" ");
                System.out.print(resultSet.getString(2)+" ");
                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            JDBCUtils.close(preparedStatement,connection,resultSet);
        }
    }
}
