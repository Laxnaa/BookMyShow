package com.example.bms.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;
@Data //getter and setter annotations
@MappedSuperclass //to map it is primary key for the child class to make table
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ) //autoicrement
    private int id;
    Date createdAt;
    Date updatedAt;

}
