package com.riwi.persistence.Imodels;

import com.riwi.entities.CourseEntity;
import com.riwi.entities.StudentEntity;
import com.riwi.persistence.crud.CreateModel;
import com.riwi.persistence.crud.DeleteModel;
import com.riwi.persistence.crud.ReadAllModel;
import com.riwi.persistence.crud.UpdateModel;
// aqui extenedemos las interfaces que vienen con los metodos necesarios para los modelos
public interface ICourseModel extends CreateModel<CourseEntity>, UpdateModel< CourseEntity,Integer>, DeleteModel<Integer>, ReadAllModel<CourseEntity> {
}
