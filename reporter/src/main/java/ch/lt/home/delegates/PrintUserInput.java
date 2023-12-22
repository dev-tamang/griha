package ch.lt.home.delegates;


import ch.lt.home.dto.Person;
import ch.lt.home.helper.camunda.CamundaVariableHelper;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.stereotype.Component;

import static ch.lt.home.helper.camunda.VariableUtils.toCamundaObjectValue;


@Slf4j
@Component("printUserInput")
public class PrintUserInput implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {

        Person person = (Person) execution.getVariableTyped("person").getValue();
        log.info("the selected variable is " + person.toString());

        person.setLastName("updatePerson");

        ObjectValue objectValue = Variables.objectValue(person)
                .serializationDataFormat(Variables.SerializationDataFormats.JSON)
                .create();


        var value = toCamundaObjectValue(person);
        execution.setVariable("person2", objectValue);

        CamundaVariableHelper variableHelper = new CamundaVariableHelper(execution);

        //Person p2 = variableHelper.get(new CamundaVariableDefinition("person", Person.class));
    }
}
