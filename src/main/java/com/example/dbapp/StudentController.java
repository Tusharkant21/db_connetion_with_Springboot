package com.example.dbapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    DbManager dbManager;
    @PostMapping("/insert_info")
    public void inserInfo(@RequestBody()Student s) throws SQLException {
        dbManager.insert_Info(s);
        return;
    }
   @GetMapping("/info")
    public void viewstudents() throws SQLException {
        dbManager.getStudent();
        return;

   }

}
