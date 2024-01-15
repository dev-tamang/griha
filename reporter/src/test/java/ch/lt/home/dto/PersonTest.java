package ch.lt.home.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@Slf4j
public class PersonTest {

    @Test
    void personFormatterTest() throws JsonProcessingException {
        var person = new Person("Test", "Person", LocalDate.now());
        var mapper = new ObjectMapper();
        var jsonString = mapper.writeValueAsString(person);
        log.info("the json person is "+ jsonString);
        var jsonperson = mapper.readValue(jsonString, Person.class);
        log.info("the person is " + jsonperson);
    }


}
