package com.portfolio.nakein.service;

import com.portfolio.nakein.model.Proyect;
import java.util.List;

public interface IProyectService {
    
    public List<Proyect> getProyect();
    
    public void saveProyect(Proyect proyect);
    
    public void deleteProyect(Long id);
    
    public Proyect findProyect(Long id);
    
}
