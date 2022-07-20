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
    private String dateEduStart;
    private String dateEduEnd;
    private String imgEdu;
    
    public Education(){
        
    }

    public Education(Long idEdu, String titleEdu, String descriptionEdu, 
            String dateEduStart, String dateEduEnd, String imgEdu) {
        this.idEdu = idEdu;
        this.titleEdu = titleEdu;
        this.descriptionEdu = descriptionEdu;
        this.dateEduStart = dateEduStart;
        this.dateEduEnd = dateEduEnd;
        this.imgEdu = imgEdu;
    }
    
    
    
}
