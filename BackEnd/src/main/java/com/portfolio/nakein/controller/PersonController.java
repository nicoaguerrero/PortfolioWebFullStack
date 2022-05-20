package com.portfolio.nakein.controller;

import com.portfolio.nakein.model.Person;
import com.portfolio.nakein.service.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {
    
    @Autowired
    private IPersonService ipersonService;
    
    @GetMapping("/person/bring")
    public List<Person> getPerson(){
        return ipersonService.getPerson();
    }
    
    @PostMapping("/person/create")
    public String createPerson(@RequestBody Person person){
        ipersonService.savePerson(person);
        return "The person was created sucessfully";
    }
    
    @DeleteMapping("/person/delete/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonService.deletePerson(id);
        return "The person was deleted sucessfully";
    }
    
    @PutMapping("person/edit/{id}")
    public Person editPersona(@PathVariable Long id,
                               @RequestParam("name") String newName,
                               @RequestParam("surname") String newSurname,
                               @RequestParam("img") String newImg){
       Person person = ipersonService.findPerson(id);
       
       person.setSurname(newSurname);
       person.setName(newName);
       person.setImg(newImg);
       
       ipersonService.savePerson(person);
       return person;
    }
    
    @GetMapping("/person/bring/profile")
    public Person findPerson(){
        return ipersonService.findPerson((long)1);
    }
    
}
