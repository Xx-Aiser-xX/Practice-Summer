package org.example.practice.models;

import jakarta.persistence.*;

//@MappedSuperclass
public abstract class BaseEntity {
    protected int id;

//    @Id
//    @Column(insertable = false, name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public abstract int getId();
    public abstract void setId(int id);
}
