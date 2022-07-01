package com.portfolio.nakein.controller;

import com.portfolio.nakein.model.Education;
import com.portfolio.nakein.service.IEducationService;
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
@RequestMapping("/education")
public class EducationController {
    
    @Autowired
    private IEducationService ieducationService;
    
    @GetMapping("/bring")
    public List<Education> getEducation(){
        return ieducationService.getEducation();
    }
    
    @PostMapping("/create")
    public String createEducation(@RequestBody Education education){
        ieducationService.saveEducation(education);
        return "Education was created sucessfully";
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteEducation(@PathVariable Long id){
        ieducationService.deleteEducation(id);
        return "The person was deleted sucessfully";
    }
    
    @PutMapping("/edit/{id}")
    public Education editEducation(@PathVariable Long id,
                               @RequestParam("title") String newTitle,
                               @RequestParam("description") String newDescription,
                               @RequestParam("date") String newDate,
                               @RequestParam("img") String newImg){
       Education education = ieducationService.findEducation(id);
       
       education.setTitleEdu(newTitle);
       education.setDescriptionEdu(newDescription);
       education.setDateEdu(newDate);
       education.setImgEdu(newImg);
       
       ieducationService.saveEducation(education);
       return education;
    }
    
    @GetMapping("/bring/profile")
    public Education findEducation(){
        return ieducationService.findEducation((long)1);
    }
    
}
