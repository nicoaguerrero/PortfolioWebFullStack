package com.portfolio.nakein.controller;

import com.portfolio.nakein.model.Experience;
import com.portfolio.nakein.service.IExperienceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/experience")
public class ExperienceController {
    
    @Autowired
    private IExperienceService iexperienceService;
    
    @GetMapping("/bring")
    public List<Experience> getExperience(){
        return iexperienceService.getExperience();
    }
    
    @PostMapping("/create")
    public String createExperience(@RequestBody Experience experience){
        iexperienceService.saveExperience(experience);
        return "Experience was created sucessfully";
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteExperience(@PathVariable Long id){
        iexperienceService.deleteExperience(id);
        return "The experience was deleted sucessfully";
    }
    
    @PutMapping("/edit/{id}")
    public Experience editExperience(@PathVariable Long id,
                               @RequestParam("titleExp") String newTitle,
                               @RequestParam("descriptionExp") String newDescription,
                               @RequestParam("dateExp") String newDate,
                               @RequestParam("imgExp") String newImg){
       Experience experience = iexperienceService.findExperience(id);
       
       experience.setTitleExp(newTitle);
       experience.setDescriptionExp(newDescription);
       experience.setDateExp(newDate);
       experience.setImgExp(newImg);
       
       iexperienceService.saveExperience(experience);
       return experience;
    }
    
    @GetMapping("/bring/profile")
    public Experience findExperience(){
        return iexperienceService.findExperience((long)1);
    }
    
    
}
