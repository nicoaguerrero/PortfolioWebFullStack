package com.portfolio.nakein.repository;

import com.portfolio.nakein.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person,Long>{
    
}
