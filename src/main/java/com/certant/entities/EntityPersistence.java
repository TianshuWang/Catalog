package com.certant.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.google.gson.annotations.Expose;

@MappedSuperclass
public class EntityPersistence {
    @Id
    @GeneratedValue
    @Expose(serialize = true, deserialize = true)
    private int id;

    public int getId() {
        return id;
    }
}
