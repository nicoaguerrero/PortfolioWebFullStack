package com.portfolio.nakein.service;

import com.portfolio.nakein.model.Person;
import java.util.List;

public interface IPersonService {
    public List<Person> getPerson();
    
    public Person savePerson(Person person);
    
    public void deletePerson(Long id);
    
    public Person findPerson(Long id);
    
}
