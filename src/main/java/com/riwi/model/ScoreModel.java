package com.riwi.model;

import com.riwi.entities.ScoreEntity;
import com.riwi.persistence.ConfigDB;
import com.riwi.persistence.Imodels.IScoreModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScoreModel implements IScoreModel {
    @Override
    public ScoreEntity create(ScoreEntity request) {
        Connection connection;
        PreparedStatement preparedStatement = null;

        connection = ConfigDB.openConnection();
        String queryCreate = "INSERT INTO score(description, value, inscription_id) VALUES(?,?)";
        try {
            preparedStatement = connection.prepareStatement(queryCreate, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, request.getDescription());
            preparedStatement.setDouble(2, request.getValue());
            preparedStatement.setInt(3, request.getIdInscription());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){

                JOptionPane.showMessageDialog(null, "Score created succesfully");

            }else{
                System.out.println("An error to create the score");
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
    public ArrayList<ScoreEntity> getAll() {
        return null;
    }

    @Override
    public void update(ScoreEntity request, Integer value) {
        Connection connection = ConfigDB.openConnection();
        PreparedStatement preparedStatement = null;
        String sqlUpdate = "UPDATE score SET description = ?, value = ? WHERE id = ?;";
        try{

            preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, request.getDescription());
            preparedStatement.setDouble(2, request.getValue());

            preparedStatement.setInt(3, value);
            int row = preparedStatement.executeUpdate();
            if(row > 0){
                JOptionPane.showMessageDialog(null,"updated score");

            }else {
                System.out.println("error score");
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
