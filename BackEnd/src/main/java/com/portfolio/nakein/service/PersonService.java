package com.portfolio.nakein.service;

import com.portfolio.nakein.model.Person;
import com.portfolio.nakein.repository.IPersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService{
    @Autowired IPersonRepository ipersonRepository;
    //Dependency injection

    @Override
    public List<Person> getPerson() {
        List<Person> personList = ipersonRepository.findAll();
        return personList;
    }

    @Override
    public void savePerson(Person person) {
        ipersonRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        ipersonRepository.deleteById(id);
    }

    @Override
    public Person findPerson(Long id) {
        Person person = ipersonRepository.findById(id).orElse(null);
        return person;
    }
    
}
