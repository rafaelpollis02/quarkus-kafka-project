package br.com.kafka;

import br.com.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class PersonProducer {

    @Inject
    @Channel("person-out")
    Emitter<String> emitter;

    @Inject
    ObjectMapper objectMapper;

    public void sendKafkaData(Person person) throws JsonProcessingException {

        for (int i = 1; i < 1000; i++) {
            person.setId(Long.valueOf(i));
            String jsonMessage = objectMapper.writeValueAsString(person);
            emitter.send(jsonMessage);
            System.out.println("Mensagem enviado ao Kafka: " + jsonMessage);
        }
    }
}
