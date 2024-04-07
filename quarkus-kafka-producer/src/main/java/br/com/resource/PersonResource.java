package br.com.resource;

import br.com.domain.Person;
import br.com.kafka.PersonProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("api/v1/producer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonProducer personProducer;

    @POST
    public Response sendMessageToKafka(Person person) throws JsonProcessingException {
        personProducer.sendKafkaData(person);
        return Response.ok().build();
    }

}
