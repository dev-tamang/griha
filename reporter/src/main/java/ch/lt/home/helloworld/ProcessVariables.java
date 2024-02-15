package ch.lt.home.helloworld;

import ch.lt.home.helloworld.dto.Person;
import ch.lt.home.helper.camunda.CamundaVariableDefinition;

public class ProcessVariables {

    public static final CamundaVariableDefinition<Person> PERSON = new CamundaVariableDefinition<>("person", Person.class);
    public static final CamundaVariableDefinition<Person> PERSON2 = new CamundaVariableDefinition<>("person2", Person.class);
    public static final CamundaVariableDefinition<String> TESTER = new CamundaVariableDefinition<>("tester", String.class);
}
