package com01.Utils;

import com01.people;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApDbutils {
    static Driver driver=null;
    static Connection connection=null;
    static PreparedStatement preparedStatement=null;
    static ResultSet resultSet = null;

    public static void main(String[] args) {

    }
    @Test
    //基本封装
    public  void SelectToList_old(){
        ArrayList<people> p = new ArrayList<>();
        try {
            //获取连接
            connection = JDBCUtils.getConnection();
            String sql = "select * from people";
            preparedStatement=connection.prepareStatement(sql);
            //执行sql,返回结果集
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String sex = resultSet.getString("sex");
                //放入集合中
                p.add(new people(id,name,sex));
            }
            System.out.println("结果"+p);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(preparedStatement,connection,resultSet);
        }
    }
    @Test
    public  void SelectbyDbUtils(){
        try {
            //得到连接
            connection = JDBCUtils.getConnection();
            //使用DbUtils 工具
            QueryRunner queryRunner = new QueryRunner();
            String sql = "select * from people";
            //利用queryRunner的方法自动获取结果集并放到list中，同时自动关闭statement和resultset
            //注意javabean类中要设有getter和setter，否则读取不到
            List<people> list =queryRunner.query(connection,sql,new BeanListHandler<>(people.class));
            for (people people:list)
                System.out.println(people);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,connection,null);
        }
    }
}
