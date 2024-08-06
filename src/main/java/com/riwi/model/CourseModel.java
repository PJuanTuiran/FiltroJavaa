package com.riwi.model;

import com.riwi.entities.CourseEntity;
import com.riwi.entities.StudentEntity;
import com.riwi.persistence.ConfigDB;
import com.riwi.persistence.Imodels.ICourseModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseModel implements ICourseModel {
    @Override
    public CourseEntity create(CourseEntity request) {
        Connection connection;
        PreparedStatement preparedStatement = null;

        connection = ConfigDB.openConnection();
        String queryCreate = "INSERT INTO courses(name) VALUES(?)";
        try {
            preparedStatement = connection.prepareStatement(queryCreate, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, request.getName());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){

                JOptionPane.showMessageDialog(null, "Student created succesfully");

            }else{
                System.out.println("An error to create the student");
                return null;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{

                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) ConfigDB.closeConnection();




            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        return request;

    }

    @Override
    public void delete(Integer value) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConfigDB.openConnection();
        String queryDelete = "DELETE FROM courses WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(queryDelete);
            preparedStatement.setInt(1, value);
            int rowAffected =  preparedStatement.executeUpdate();
            if(rowAffected > 0){
                JOptionPane.showMessageDialog(null, "Record deleted succesfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) ConfigDB.closeConnection();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public ArrayList<CourseEntity> getAll() {
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        ArrayList<CourseEntity> courses = new ArrayList<>();
        Connection connection = ConfigDB.openConnection();
        String queryRead = "SELECT * FROM courses";

        try {
            preparedStatement = connection.prepareStatement(queryRead);

            result = preparedStatement.executeQuery();
            while(result.next()){
                CourseEntity courseEntity = new CourseEntity();
                courseEntity.setIdCourse(result.getInt(1));
                courseEntity.setName(result.getString(2));
                courses.add(courseEntity);

            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(result != null) result.close();
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) ConfigDB.closeConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        return courses;

    }

    @Override
    public void update(CourseEntity request, Integer value) {

        Connection connection = ConfigDB.openConnection();
        PreparedStatement preparedStatement = null;
        String sqlUpdate = "UPDATE courses SET name = ? WHERE id = ?;";
        try{

            preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, request.getName());

            preparedStatement.setInt(2, value);
            int row = preparedStatement.executeUpdate();
            if(row > 0){
                JOptionPane.showMessageDialog(null,"updated record");

            }else {
                System.out.println("error updating data");
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{

                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) ConfigDB.closeConnection();



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
