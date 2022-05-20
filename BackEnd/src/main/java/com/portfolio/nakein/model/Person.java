package com.portfolio.nakein.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*It's supposed that i'm the only in the db but, i saw on internet that
    it's better to have an id so i added it.
    IDENTITY = auto increment*/
    
    @NotNull
    @Size(min=1,max=30,message="Must be between 1 to 30 characters")
    private String name;
    
    @NotNull
    @Size(min=1,max=30,message="Must be between 1 to 30 characters")
    private String surname;
    
    private String img;
}
