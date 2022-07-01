package com.portfolio.nakein.repository;

import com.portfolio.nakein.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationRepository extends JpaRepository<Education,Long>{
    
}
