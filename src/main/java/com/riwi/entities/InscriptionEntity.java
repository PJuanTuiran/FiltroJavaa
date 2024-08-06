package com.riwi.entities;

import java.sql.Time;
import java.util.Date;

public class InscriptionEntity {
   private int idInscription;
   private String fechaInscription;
   private Time horaInscription;
   private int idEstudent;
   private int idCourse;

    public int getIdInscription() {
        return idInscription;
    }

    public InscriptionEntity() {
    }

    public InscriptionEntity(int idInscription, String fechaInscription, Time horaInscription, int idEstudent, int idCourse) {
        this.idInscription = idInscription;
        this.fechaInscription = fechaInscription;
        this.horaInscription = horaInscription;
        this.idEstudent = idEstudent;
        this.idCourse = idCourse;
    }

    public void setIdInscription(int idInscription) {
        this.idInscription = idInscription;
    }

    public String getFechaInscription() {
        return fechaInscription;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setFechaInscription(String fechaInscription) {
        this.fechaInscription = fechaInscription;
    }

    public Time getHoraInscription() {
        return horaInscription;
    }

    public void setHoraInscription(Time horaInscription) {
        this.horaInscription = horaInscription;
    }

    public int getIdEstudent() {
        return idEstudent;
    }

    public void setIdEstudent(int idEstudent) {
        this.idEstudent = idEstudent;
    }

    @Override
    public String toString() {
        return "InscriptionEntity{" +
                "idInscription=" + idInscription +
                ", fechaInscription=" + fechaInscription +
                ", horaInscription=" + horaInscription +
                ", idEstudent=" + idEstudent +
                '}';
    }
}
