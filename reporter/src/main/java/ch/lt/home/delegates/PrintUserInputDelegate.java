package ch.lt.home.delegates;


import ch.lt.home.dto.Person;
import ch.lt.home.helper.ProcessVariables;
import ch.lt.home.helper.camunda.CamundaVariableHelper;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import static ch.lt.home.helper.ProcessVariables.PERSON2;
import static ch.lt.home.helper.ProcessVariables.TESTER;


@Slf4j
@Component("printUserInput")
public class PrintUserInputDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {

        CamundaVariableHelper variableHelper = new CamundaVariableHelper(execution);
        Person p1 = variableHelper.get(ProcessVariables.PERSON);

        variableHelper.set(TESTER, "some test person");
        variableHelper.set(PERSON2, p1);

        execution.setVariable("intVariable", 23);
        execution.setVariable("stringVariable", "test person string");

        var p2 = variableHelper.get(PERSON2);

        log.info("the variable from variable helper "+ p2);
    }
}
