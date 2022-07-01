package com.portfolio.nakein.service;

import com.portfolio.nakein.model.Experience;
import java.util.List;

public interface IExperienceService {
    
    public List<Experience> getExperience();
    
    public void saveExperience(Experience experience);
    
    public void deleteExperience(Long id);
    
    public Experience findExperience(Long id);
    
}
