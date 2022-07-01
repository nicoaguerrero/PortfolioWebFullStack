package com.portfolio.nakein.service;

import com.portfolio.nakein.model.Experience;
import com.portfolio.nakein.repository.IExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperienceService{
    @Autowired IExperienceRepository iexperienceRepository; 
    
    @Override
    public List<Experience> getExperience() {
        List<Experience> experienceList = iexperienceRepository.findAll();
        return experienceList;
    }

    @Override
    public void saveExperience(Experience experience) {
        iexperienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long id) {
        iexperienceRepository.deleteById(id);
    }

    @Override
    public Experience findExperience(Long id) {
        Experience experience = iexperienceRepository.findById(id).orElse(null);
        return experience;
    }
    
}
