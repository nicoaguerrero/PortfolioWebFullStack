package com.portfolio.nakein.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Proyect {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProyect;
    private String titlePro;
    private String descriptionPro;
    private String urlPro;
    private String imgPro;
    
    public Proyect(){
        
    }

    public Proyect(Long idProyect, String titlePro, String descriptionPro, String urlPro, String imgPro) {
        this.idProyect = idProyect;
        this.titlePro = titlePro;
        this.descriptionPro = descriptionPro;
        this.urlPro = urlPro;
        this.imgPro = imgPro;
    }
    
    
    
}
