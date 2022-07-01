package com.portfolio.nakein.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_exp;
    private String titleExp;
    private String descriptionExp;
    private String dateExp;
    private String imgExp;
    
    public Experience(){
        
    }

    public Experience(Long id_exp, String titleExp, String descriptionExp, String dateExp, String imgExp) {
        this.id_exp = id_exp;
        this.titleExp = titleExp;
        this.descriptionExp = descriptionExp;
        this.dateExp = dateExp;
        this.imgExp = imgExp;
    }
    
    
}
