package com.portfolio.nakein.service;

import com.portfolio.nakein.model.Education;
import java.util.List;

public interface IEducationService {
    
    public List<Education> getEducation();
    
    public Education saveEducation(Education education);
    
    public void deleteEducation(Long id);
    
    public Education findEducation(Long id);
    
}
