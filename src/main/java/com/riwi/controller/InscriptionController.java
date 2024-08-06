package com.riwi.controller;

import com.riwi.entities.CourseEntity;
import com.riwi.entities.InscriptionEntity;
import com.riwi.model.CourseModel;
import com.riwi.model.InscriptionModel;

import javax.swing.*;
import java.util.ArrayList;

public class InscriptionController {
    static InscriptionModel inscriptionModel = new InscriptionModel();

    public static void create (InscriptionEntity inscription){
        inscriptionModel.create(inscription);
    }

    public static void update(InscriptionEntity inscription, int id){
        inscriptionModel.update(inscription, id);
    }

    public static void getAll(){
        ArrayList<InscriptionEntity> inscriptions = inscriptionModel.getAll();

        for(InscriptionEntity inscription: inscriptions){
            JOptionPane.showMessageDialog(null, inscription);
        }
    }

    public static void delete(int id){
        inscriptionModel.delete(id);
    }
}
