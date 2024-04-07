package br.com.kafka;

import domain.Person;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import repository.PersonRepository;
import service.PersonService;

@ApplicationScoped
public class PersonConsumer {

    @Inject
    PersonService personService;

    @Incoming("person-in")
    @Transactional
    public void receiveMessageFromKafka(String message){

        JsonObject json = new JsonObject(message);

            Person person = new Person();
            person.setId(Long.valueOf(json.getInteger("id")));
            person.setName(json.getString("name"));

            personService.create(person);
            System.out.println("Mensagem enviada ao Kafka: " + person.getId() + " : " + person.getName());
    }
}
