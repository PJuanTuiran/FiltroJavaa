package com.riwi.persistence.Imodels;

import com.riwi.entities.StudentEntity;

import com.riwi.persistence.crud.*;
// aqui extenedemos las interfaces que vienen con los metodos necesarios para los modelos
public interface IStudentModel extends CreateModel<StudentEntity>, UpdateModel< StudentEntity,Integer>, ReadByIdModel<StudentEntity, Integer>, ReadByEmailModel<StudentEntity, String>, ReadAllModel<StudentEntity> {

}
