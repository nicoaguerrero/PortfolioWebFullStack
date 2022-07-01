package com.portfolio.nakein.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSkill;
    private String titleSkill;
    private String imgSkill;
    private int percentage;
    
    public Skill(){
        
    }

    public Skill(Long idSkill, String titleSkill, String imgSkill, int percentage) {
        this.idSkill = idSkill;
        this.titleSkill = titleSkill;
        this.imgSkill = imgSkill;
        this.percentage = percentage;
    }
    
    
    
}
