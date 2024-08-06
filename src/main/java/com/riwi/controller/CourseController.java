package com.riwi.controller;

import com.riwi.entities.CourseEntity;
import com.riwi.entities.StudentEntity;
import com.riwi.model.CourseModel;
import com.riwi.model.StudentModel;

import javax.swing.*;
import java.util.ArrayList;

public class CourseController {
    static CourseModel courseModel = new CourseModel();
    public static void create (CourseEntity student){
        courseModel.create(student);
    }

    public static void update(CourseEntity course, int id){
        courseModel.update( course ,id );
    }

    public static void getAll(){
        ArrayList<CourseEntity> courses =  courseModel.getAll();

        for(CourseEntity course: courses){
            JOptionPane.showMessageDialog(null, course);
        }
    }

    public static void delete(int id){
        courseModel.delete(id);
    }
}
