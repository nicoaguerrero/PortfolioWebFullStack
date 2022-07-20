package com.portfolio.nakein.controller;

import com.portfolio.nakein.model.Skill;
import com.portfolio.nakein.service.ISkillService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfolio-83c77.web.app")
@RequestMapping("/api/skill")
public class SkillController {
    
    @Autowired
    private ISkillService iskillService;
    
    @GetMapping("/bring")
    public List<Skill> getSkill(){
        return iskillService.getSkill();
    }
    
    @PostMapping("/create")
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill){
        Skill newSkill = iskillService.saveSkill(skill);
        return new ResponseEntity<>(newSkill,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable Long id){
        iskillService.deleteSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/edit")
    public ResponseEntity<Skill> editSkill(@RequestBody Skill skill){
       Skill updateSkill = iskillService.saveSkill(skill);
       return new ResponseEntity<>(updateSkill,HttpStatus.OK);
    }
    
}
