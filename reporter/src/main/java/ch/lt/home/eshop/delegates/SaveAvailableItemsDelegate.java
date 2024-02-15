package ch.lt.home.eshop.delegates;

import ch.lt.home.eshop.dto.Item;
import ch.lt.home.helper.camunda.CamundaVariableHelper;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import static ch.lt.home.eshop.EshopCamundaVariables.SHOP;

@Component("saveAvailableItems")
public class SaveAvailableItemsDelegate implements JavaDelegate {


    @Override
    public void execute(DelegateExecution execution) {
        var variableHelper = new CamundaVariableHelper(execution);
        variableHelper.set(SHOP, Item.builder().id("1").name("Keyboard").price(9.95).build());
    }
}
