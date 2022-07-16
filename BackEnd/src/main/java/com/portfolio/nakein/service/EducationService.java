package com.portfolio.nakein.service;

import com.portfolio.nakein.model.Education;
import com.portfolio.nakein.repository.IEducationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService{
    @Autowired IEducationRepository ieducationRepository; 
    
    @Override
    public List<Education> getEducation() {
        List<Education> educationList = ieducationRepository.findAll();
        return educationList;
    }

    @Override
    public Education saveEducation(Education education) {
        return ieducationRepository.save(education);
    }

    @Override
    public void deleteEducation(Long id) {
        ieducationRepository.deleteById(id);
    }

    @Override
    public Education findEducation(Long id) {
        Education education = ieducationRepository.findById(id).orElse(null);
        return education;
    }
}
