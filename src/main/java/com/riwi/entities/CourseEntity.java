package com.riwi.entities;

public class CourseEntity {
    private int idCourse;
    private String name;
    private int idStudent;
    private int idScore;

    public CourseEntity(int idCourse, String name, int idStudent, int idScore) {
        this.idCourse = idCourse;
        this.name = name;
        this.idStudent = idStudent;
        this.idScore = idScore;
    }

    public CourseEntity() {
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdScore() {
        return idScore;
    }

    public void setIdScore(int idScore) {
        this.idScore = idScore;
    }

    @Override
    public String toString() {
        return "CourseEntity{" +
                "idCourse=" + idCourse +
                ", name='" + name + '\'' +
                ", idStudent=" + idStudent +
                ", idScore=" + idScore +
                '}';
    }
}
