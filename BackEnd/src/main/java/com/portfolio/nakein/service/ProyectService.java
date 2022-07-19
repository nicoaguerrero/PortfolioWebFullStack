package com.portfolio.nakein.service;

import com.portfolio.nakein.model.Proyect;
import com.portfolio.nakein.repository.IProyectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectService implements IProyectService{
    @Autowired IProyectRepository iproyectRepository; 
    
    @Override
    public List<Proyect> getProyect() {
        List<Proyect> proyectList = iproyectRepository.findAll();
        return proyectList;
    }

    @Override
    public Proyect saveProyect(Proyect proyect) {
        return iproyectRepository.save(proyect);
    }

    @Override
    public void deleteProyect(Long id) {
        iproyectRepository.deleteById(id);
    }

    @Override
    public Proyect findProyect(Long id) {
        Proyect proyect = iproyectRepository.findById(id).orElse(null);
        return proyect;
    }
    
}
