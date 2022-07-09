package com.portfolio.nakein.service;

import com.portfolio.nakein.model.Skill;
import com.portfolio.nakein.repository.ISkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService{
    @Autowired ISkillRepository iskillRepository; 

    @Override
    public List<Skill> getSkill() {
        List<Skill> skillList = iskillRepository.findAll();
        return skillList;
    }

    @Override
    public void saveSkill(Skill skill) {
        iskillRepository.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        iskillRepository.deleteById(id);
    }

    @Override
    public Skill findSkill(Long id) {
        Skill skill = iskillRepository.findById(id).orElse(null);
        return skill;
    }
    
}
