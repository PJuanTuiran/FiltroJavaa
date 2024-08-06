package com.riwi.controller;

import com.riwi.entities.ScoreEntity;
import com.riwi.entities.StudentEntity;
import com.riwi.model.ScoreModel;
import com.riwi.model.StudentModel;

public class ScoreController {
    static ScoreModel scoreModel  = new ScoreModel();


    public static void create (ScoreEntity score){
        scoreModel.create(score);
    }

    public static void update(ScoreEntity score, int id){
        scoreModel.update( score ,id );
    }
}
