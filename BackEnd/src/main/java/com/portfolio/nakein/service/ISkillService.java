package com.portfolio.nakein.service;

import com.portfolio.nakein.model.Skill;
import java.util.List;

public interface ISkillService {
    
    public List<Skill> getSkill();
    
    public Skill saveSkill(Skill skill);
    
    public void deleteSkill(Long id);
    
    public Skill findSkill(Long id);
    
}
