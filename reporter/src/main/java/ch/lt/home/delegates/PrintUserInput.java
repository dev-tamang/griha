package ch.lt.home.delegates;


import ch.lt.home.dto.Person;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;


@Slf4j
@Component("printUserInput")
public class PrintUserInput implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        Person person = (Person) execution.getVariableTyped("person").getValue();
        log.info("the selected variable is " + person.toString());
    }
}
