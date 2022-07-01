package com.portfolio.nakein.repository;

import com.portfolio.nakein.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillRepository extends JpaRepository<Skill,Long>{
    
}
