package com.riwi.persistence.crud;

import java.util.ArrayList;
// creo una interfaz para poder extenderla en otra interfaz que sirve para implementar para el modelo deseado
public interface ReadAllModel<Entity> {
    public ArrayList<Entity> getAll();
}
