package com.riwi.entities;

public class StudentEntity {
    private int idStudent;
    private String name;
    private String email;
    private Boolean status = true;

    public StudentEntity() {
    }

    public StudentEntity(String name, String email, Boolean status) {
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getIdStudent() {
        return idStudent;
    }



    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "idStudent=" + idStudent +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
