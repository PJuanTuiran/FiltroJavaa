package com.riwi.persistence.crud;

// creo una interfaz para poder extenderla en otra interfaz que sirve para implementar para el modelo deseado

public interface CreateModel<Entity> {
    public Entity create(Entity request);
}
