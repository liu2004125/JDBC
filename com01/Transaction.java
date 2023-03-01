package com01;

import com01.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Transaction {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            //取消自动提交
            connection.setAutoCommit(false);
            String sql = "select * from people";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            connection.rollback();//回滚
            //无误后提交
            connection.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            JDBCUtils.close(statement,connection,resultSet);
        }
    }
}
