package com.portfolio.nakein.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Education {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEdu;
    private String titleEdu;
    private String descriptionEdu;
    private String dateEdu;
    private String imgEdu;
    
    public Education(){
        
    }

    public Education(Long idEdu, String titleEdu, String descriptionEdu, String dateEdu, String imgEdu) {
        this.idEdu = idEdu;
        this.titleEdu = titleEdu;
        this.descriptionEdu = descriptionEdu;
        this.dateEdu = dateEdu;
        this.imgEdu = imgEdu;
    }
    
    
    
}
