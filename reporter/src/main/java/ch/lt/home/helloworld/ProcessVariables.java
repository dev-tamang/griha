package ch.lt.home.helloworld;

import ch.lt.home.helloworld.dto.Person;
import ch.lt.home.helper.camunda.CamundaVariableDefinition;

public class ProcessVariables {

    public static CamundaVariableDefinition<Person> PERSON = new CamundaVariableDefinition<>("person", Person.class);
    public static CamundaVariableDefinition<Person> PERSON2 = new CamundaVariableDefinition<>("person2", Person.class);
    public static CamundaVariableDefinition<String> TESTER = new CamundaVariableDefinition<>("tester", String.class);
}
