package com.portfolio.nakein.controller;

import com.portfolio.nakein.model.Proyect;
import com.portfolio.nakein.service.IProyectService;
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
@CrossOrigin(origins = "https://portfolio-83c77.web.app/")
@RequestMapping("/api/proyect")
public class ProyectController {
    @Autowired
    private IProyectService iproyectService;
    
    @GetMapping("/bring")
    public List<Proyect> getProyect(){
        return iproyectService.getProyect();
    }
    
    @PostMapping("/create")
    public ResponseEntity<Proyect> createProyect(@RequestBody Proyect proyect){
        Proyect newProyect = iproyectService.saveProyect(proyect);
        return new ResponseEntity<>(newProyect,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProyect(@PathVariable Long id){
        iproyectService.deleteProyect(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/edit")
    public ResponseEntity<Proyect> editProyect(@RequestBody Proyect proyect){
       Proyect updateProyect = iproyectService.saveProyect(proyect);
       return new ResponseEntity<>(updateProyect,HttpStatus.OK);
    }
    
}
