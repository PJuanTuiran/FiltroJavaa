package com.riwi.controller;

import com.riwi.entities.StudentEntity;
import com.riwi.model.StudentModel;

import javax.swing.*;
import java.security.PublicKey;
import java.util.ArrayList;

public class StudentController {

    static StudentModel studentModel = new StudentModel();


    public static void create (StudentEntity student){
        studentModel.create(student);
    }

    public static void update(StudentEntity student, int id){
        studentModel.update( student,id );
    }

    public static void getAll(){
        ArrayList<StudentEntity> students =  studentModel.getAll();

        for(StudentEntity student: students){
            JOptionPane.showMessageDialog(null, student);
        }
    }


    public static void readById(int id){
      ArrayList<StudentEntity> students =  studentModel.getById(id);
      JOptionPane.showMessageDialog(null, students);
    }

    public static void readByEmail(String email){
        ArrayList<StudentEntity> student = studentModel.readByEmail(email);
        JOptionPane.showMessageDialog(null, student);

    }
}
