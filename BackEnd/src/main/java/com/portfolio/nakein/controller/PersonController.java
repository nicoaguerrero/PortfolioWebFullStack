package com.portfolio.nakein.controller;

import com.portfolio.nakein.model.Person;
import com.portfolio.nakein.service.IPersonService;
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
@CrossOrigin(origins = "https://portfolio-83c77.web.app")
@RequestMapping("/api/person")
public class PersonController {
    
    @Autowired
    private IPersonService ipersonService;
    
    @GetMapping("/bring")
    public List<Person> getPerson(){
        return ipersonService.getPerson();
    }
    
    @PostMapping("/create")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person newPerson = ipersonService.savePerson(person);
        return new ResponseEntity<>(newPerson,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id){
        ipersonService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/edit")
    public ResponseEntity<Person> editPerson(@RequestBody Person person){
       Person updatePerson = ipersonService.savePerson(person);
       return new ResponseEntity<>(updatePerson,HttpStatus.OK);
    }
    
    @GetMapping("/bring/profile")
    public Person findPerson(){
        return ipersonService.findPerson((long)1);
    }
    
}
