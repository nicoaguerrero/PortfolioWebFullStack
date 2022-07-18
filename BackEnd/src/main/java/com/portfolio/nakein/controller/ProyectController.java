package com.portfolio.nakein.controller;

import com.portfolio.nakein.model.Proyect;
import com.portfolio.nakein.service.IProyectService;
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
@RequestMapping("/api/proyect")
public class ProyectController {
    @Autowired
    private IProyectService iproyectService;
    
    @GetMapping("/bring")
    public List<Proyect> getProyect(){
        return iproyectService.getProyect();
    }
    
    @PostMapping("/create")
    public String createProyect(@RequestBody Proyect proyect){
        iproyectService.saveProyect(proyect);
        return "Proyect was created sucessfully";
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteProyect(@PathVariable Long id){
        iproyectService.deleteProyect(id);
        return "The proyect was deleted sucessfully";
    }
    
    @PutMapping("/edit/{id}")
    public Proyect editProyect(@PathVariable Long id,
                               @RequestParam("titlePro") String newTitle,
                               @RequestParam("descriptionPro") String newDescription,
                               @RequestParam("urlPro") String newUrl,
                               @RequestParam("imgExp") String newImg){
       Proyect proyect = iproyectService.findProyect(id);
       
       proyect.setTitlePro(newTitle);
       proyect.setDescriptionPro(newDescription);
       proyect.setUrlPro(newUrl);
       proyect.setImgPro(newImg);
       
       iproyectService.saveProyect(proyect);
       return proyect;
    }
    
    @GetMapping("/bring/profile")
    public Proyect findProyect(){
        //should have the parameter!!!
        return iproyectService.findProyect((long)1);
    }
    
}
