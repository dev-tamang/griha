package itest;

import ch.lt.home.eshop.delegates.SaveAvailableItemsDelegate;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.mock.Mocks;
import org.camunda.bpm.extension.junit5.test.ProcessEngineExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@ExtendWith(ProcessEngineExtension.class)
@Deployment(resources = {"bpmn/eshop.bpmn"})
public class ProcessEshopTest {
    public ProcessEngine processEngine;

    @BeforeAll
    public static void setup(){
        Mocks.register("saveAvailableItems", new SaveAvailableItemsDelegate());
    }
    @Test
    public void startEshopProcess() {
        RuntimeService runtimeService = processEngine.getRuntimeService();
        var processInstance = runtimeService.startProcessInstanceByKey("Process_Eshop");
        assertNotNull(processInstance.getProcessInstanceId());

    }

}
