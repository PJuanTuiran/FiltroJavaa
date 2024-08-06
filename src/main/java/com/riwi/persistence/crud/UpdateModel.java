package com.riwi.persistence.crud;


import java.security.PublicKey;
// creo una interfaz para poder extenderla en otra interfaz que sirve para implementar para el modelo deseado
public interface UpdateModel<Entity, ID> {

    public void update(Entity request, ID value);
}
