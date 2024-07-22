package com.example.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter //Getter annotations
@Setter //Setter annotations
@Entity(name = "cities") //annotation for creating a class
public class City extends BaseModel{
    private String name;
    @OneToMany()
    private List<Theatre> theatres;
}
