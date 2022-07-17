package com.portfolio.nakein.controller;

import com.portfolio.nakein.model.Experience;
import com.portfolio.nakein.service.IExperienceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Experience> createExperience(@RequestBody Experience experience){
        Experience newExperience = iexperienceService.saveExperience(experience);
        return new ResponseEntity<>(newExperience,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExperience(@PathVariable Long id){
        iexperienceService.deleteExperience(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/edit")
    public ResponseEntity<Experience> editExperience(@RequestBody Experience experience){
       Experience updateExperience = iexperienceService.saveExperience(experience);
       return new ResponseEntity<>(updateExperience,HttpStatus.OK);
    }
    
    @GetMapping("/bring/profile")
    public Experience findExperience(){
        return iexperienceService.findExperience((long)1);
    }
    
    
}
