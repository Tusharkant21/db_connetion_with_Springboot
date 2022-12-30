package com.example.dbapp;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbManager {

    public Connection connection;
    public DbManager() throws SQLException{
        getConnection();
        createTable();

    }
    public Connection getConnection() throws SQLException {
        if(connection==null)
        {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
        }
        return connection;
    }
    public void createTable() throws SQLException {
        String sql= "create table if not exists student_information(id INT primary key auto_increment,age INT, name VARCHAR(20))";
        Statement st = connection.createStatement();
        boolean return_value=st.execute(sql);
        System.out.println(return_value);
    }
    public void insert_Info(Student s) throws SQLException{
        String sqlQuery="insert into student_information(age,name) value("+s.getAge()+",'"+s.getName()+"')";
        Statement st= connection.createStatement();
       int rows= st.executeUpdate(sqlQuery);
        System.out.println("number of rows affectted = "+rows);


    }
    public List<List<String>> getStudent() throws SQLException{
        List<List<String>> list=new ArrayList<>();
        String sqlQuery="Select * from student_information";
        Statement st= connection.createStatement();
        ResultSet student=st.executeQuery(sqlQuery);
        while(student.next()){
            String id=student.getString("id");
            String name=student.getString("name");
            String age= student.getString("age");
            List<String> curList=new ArrayList<>();
           curList.add(id);
           curList.add(name);
           curList.add(age);
           list.add(curList);
        }
            return list;


    }
}
