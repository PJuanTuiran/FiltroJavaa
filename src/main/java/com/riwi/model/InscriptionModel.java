package com.riwi.model;

import com.riwi.entities.CourseEntity;
import com.riwi.entities.InscriptionEntity;
import com.riwi.persistence.ConfigDB;
import com.riwi.persistence.Imodels.IInscriptionModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InscriptionModel implements IInscriptionModel {
    @Override
    public InscriptionEntity create(InscriptionEntity request) {
        Connection connection;
        PreparedStatement preparedStatement = null;

        connection = ConfigDB.openConnection();
        String queryCreate = "INSERT INTO inscriptions(fecha, hora, courses_id, student_id) VALUES(?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(queryCreate, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, request.getFechaInscription());
            preparedStatement.setTime(2, request.getHoraInscription());
            preparedStatement.setInt(3, request.getIdCourse());
            preparedStatement.setInt(4, request.getIdEstudent());


            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){

                JOptionPane.showMessageDialog(null, "Inscription created succesfully");

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
        String queryDelete = "DELETE FROM inscriptions WHERE id = ? ";
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
    public ArrayList<InscriptionEntity> getAll() {
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        ArrayList<InscriptionEntity> inscriptions = new ArrayList<>();
        Connection connection = ConfigDB.openConnection();
        String queryRead = "SELECT * FROM inscriptions";

        try {
            preparedStatement = connection.prepareStatement(queryRead);

            result = preparedStatement.executeQuery();
            while(result.next()){
                InscriptionEntity inscriptionEntity = new InscriptionEntity();
                inscriptionEntity.setIdInscription(result.getInt(1));
                inscriptionEntity.setFechaInscription(result.getString(2));
                inscriptionEntity.setHoraInscription(result.getTime(3));
                inscriptions.add(inscriptionEntity);

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


        return inscriptions;

    }

    @Override
    public void update(InscriptionEntity request, Integer value) {
        Connection connection = ConfigDB.openConnection();
        PreparedStatement preparedStatement = null;
        String sqlUpdate = "UPDATE inscriptions SET fecha = ?, hora = ? WHERE id = ?;";
        try{

            preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, request.getFechaInscription());

            preparedStatement.setTime(2, request.getHoraInscription());
            preparedStatement.setInt(3, value);
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


