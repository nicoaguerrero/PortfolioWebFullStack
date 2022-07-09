package com.portfolio.nakein.controller;

import com.portfolio.nakein.model.Skill;
import com.portfolio.nakein.service.ISkillService;
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
@RequestMapping("/skill")
public class SkillController {
    
    @Autowired
    private ISkillService iskillService;
    
    @GetMapping("/bring")
    public List<Skill> getSkill(){
        return iskillService.getSkill();
    }
    
    @PostMapping("/create")
    public String createSkill(@RequestBody Skill skill){
        iskillService.saveSkill(skill);
        return "Skill was created sucessfully";
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteSkill(@PathVariable Long id){
        iskillService.deleteSkill(id);
        return "The skill was deleted sucessfully";
    }
    
    @PutMapping("/edit/{id}")
    public Skill editSkill(@PathVariable Long id,
                               @RequestParam("titleSkill") String newTitle,
                               @RequestParam("imgSkill") String newImg,
                               @RequestParam("percentage") int newPercentage,
                               @RequestParam("language") boolean newLanguage){
       Skill skill = iskillService.findSkill(id);
       
       skill.setTitleSkill(newTitle);
       skill.setImgSkill(newImg);
       skill.setPercentage(newPercentage);
       skill.setLanguage(newLanguage);
       
       iskillService.saveSkill(skill);
       return skill;
    }
    
    @GetMapping("/bring/profile")
    public Skill findSkill(){
        return iskillService.findSkill((long)1);
    }
    
}
