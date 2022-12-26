package com.example.dbapp;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
}
