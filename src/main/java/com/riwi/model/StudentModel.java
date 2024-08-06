package com.riwi.model;

import com.riwi.entities.StudentEntity;
import com.riwi.persistence.ConfigDB;
import com.riwi.persistence.Imodels.IStudentModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentModel implements IStudentModel {

    //implemeto todos los metodos del la interfaz IstudentModel

    // este metodo sirve para create un sutiante
    @Override
    public StudentEntity create(StudentEntity request) {
        Connection connection;
        PreparedStatement preparedStatement = null;

        connection = ConfigDB.openConnection();
        String queryCreate = "INSERT INTO students(name, email, status) VALUES(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(queryCreate, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, request.getName());
            preparedStatement.setString(2, request.getEmail());
            preparedStatement.setBoolean(3, request.getStatus());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){

                System.out.println("Student created succesfully");

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
// este metodo funciona para encontrar un studiandte por id
    @Override
    public ArrayList<StudentEntity> getById(Integer id) {
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        ArrayList<StudentEntity> students = new ArrayList<>();
        Connection connection = ConfigDB.openConnection();
        String queryRead = "SELECT * FROM students WHERE id = ? ";

        try {
            preparedStatement = connection.prepareStatement(queryRead);
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeQuery();
            while(result.next()){
                StudentEntity studentEntity = new StudentEntity();
                studentEntity.setIdStudent(result.getInt(1));
                studentEntity.setName(result.getString(2));
                studentEntity.setEmail(result.getString(3));
                students.add(studentEntity);

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


        return students;
    }
// este metodo funciona para actualizar los datos de un estudiante
    @Override
    public void update(StudentEntity request, Integer value) {
        Connection connection = ConfigDB.openConnection();
        PreparedStatement preparedStatement = null;
        String sqlUpdate = "UPDATE students SET name = ?, email = ?  WHERE id = ?;";
        try{

            preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, request.getName());
            preparedStatement.setString(2, request.getEmail());
            preparedStatement.setInt(3, value);
            int row = preparedStatement.executeUpdate();
            if(row > 0){
                System.out.println("updated record");

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
// este metodo funciona para encontrar estudiantes por id
    @Override
    public ArrayList<StudentEntity> readByEmail(String value) {
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        ArrayList<StudentEntity> students = new ArrayList<>();
        Connection connection = ConfigDB.openConnection();
        String queryRead = "SELECT * FROM students WHERE email = ? ";

        try {
            preparedStatement = connection.prepareStatement(queryRead);
            preparedStatement.setString(1, value);
            result = preparedStatement.executeQuery();
            while(result.next()){
                StudentEntity studentEntity = new StudentEntity();
                studentEntity.setIdStudent(result.getInt(1));
                studentEntity.setName(result.getString(2));
                studentEntity.setEmail(result.getString(3));
                students.add(studentEntity);

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


        return students;
    }

// este metodo funciona para mostrar todos los estudiantes que existen
    @Override
    public ArrayList<StudentEntity> getAll() {
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        ArrayList<StudentEntity> students = new ArrayList<>();
        Connection connection = ConfigDB.openConnection();
        String queryRead = "SELECT * FROM students where status = true";

        try {
            preparedStatement = connection.prepareStatement(queryRead);

            result = preparedStatement.executeQuery();
            while(result.next()){
                StudentEntity studentEntity = new StudentEntity();
                studentEntity.setIdStudent(result.getInt(1));
                studentEntity.setName(result.getString(2));
                studentEntity.setEmail(result.getString(3));
                students.add(studentEntity);

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


        return students;
    }
}

