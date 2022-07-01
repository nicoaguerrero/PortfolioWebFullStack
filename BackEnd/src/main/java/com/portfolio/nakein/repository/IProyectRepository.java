package com.portfolio.nakein.repository;

import com.portfolio.nakein.model.Proyect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectRepository extends JpaRepository<Proyect,Long>{
    
}
