package com.riwi.entities;

public class ScoreEntity {
    private int idScore;
    private String description;
    private Double value;
    private int idInscription;

    public ScoreEntity() {
    }



    public ScoreEntity(String description, Double value, int idInscription) {
        this.description = description;
        this.value = value;
        this.idInscription = idInscription;
    }

    public int getIdScore() {
        return idScore;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(int idInscription) {
        this.idInscription = idInscription;
    }

    public void setIdScore(int idScore) {
        this.idScore = idScore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ScoreEntity{" +
                "idScore=" + idScore +
                ", description='" + description + '\'' +
                '}';
    }
}
