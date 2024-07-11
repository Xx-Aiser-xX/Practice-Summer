package org.example.practice.Table;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public abstract class BaseEntity {
    private int id;

    @Id
    @Column(insertable = false, name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public abstract int getId();
    public abstract void setId(int id);
}
