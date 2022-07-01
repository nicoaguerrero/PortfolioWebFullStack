package com.portfolio.nakein.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Person implements Serializable {
    //Serializable makes storing and sending objects easy.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*It's supposed that i'm the only in the db but, i saw on internet that
    it's better to have an id so i added it.
    IDENTITY = auto increment*/
  
    //nullable: table restriction so you cant insert a null value
    @Column(nullable=false, length=30)
    private String name;
    @Column(nullable=false, length=30)
    private String surname;
    @Column(nullable=false, length=50)
    private String degree;
    @Column(nullable=false, length=600)
    private String description;
    private String img;
    
    //Lazy gets the entity only when we really need it
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idEdu")
    private List<Education> educationList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_exp")
    private List<Experience> experienceList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idSkill")
    private List<Skill> skillList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idProyect")
    private List<Proyect> proyectList;
    
    public Person(){
        
    }

    public Person(Long id, String name, String surname, String degree, String description, String img) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.degree = degree;
        this.description = description;
        this.img = img;
    }
    
    
}


