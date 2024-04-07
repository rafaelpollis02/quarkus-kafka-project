package service;

import domain.Person;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import repository.PersonRepository;

@ApplicationScoped
public class PersonService {

    @Inject
    PersonRepository personRepository;

    @Transactional
    public void create(Person person){
        personRepository.persist(person);
    }

}
