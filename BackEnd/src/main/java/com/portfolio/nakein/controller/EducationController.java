package com.portfolio.nakein.controller;

import com.portfolio.nakein.model.Education;
import com.portfolio.nakein.service.IEducationService;
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
@RequestMapping("/api/education")
public class EducationController {
    
    @Autowired
    private IEducationService ieducationService;
    
    @GetMapping("/bring")
    public List<Education> getEducation(){
        return ieducationService.getEducation();
    }
    
    @PostMapping("/create")
    public ResponseEntity<Education> createEducation(@RequestBody Education education){
        Education newEducation = ieducationService.saveEducation(education);
        return new ResponseEntity<>(newEducation,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEducation(@PathVariable Long id){
        ieducationService.deleteEducation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/edit")
    public ResponseEntity<Education> editEducation(@RequestBody Education education){
        Education updateEducation = ieducationService.saveEducation(education);
        return new ResponseEntity<>(updateEducation,HttpStatus.OK);
    }
    
}
