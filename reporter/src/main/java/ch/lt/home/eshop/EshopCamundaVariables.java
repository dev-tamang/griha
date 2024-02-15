package ch.lt.home.eshop;

import ch.lt.home.eshop.dto.Item;
import ch.lt.home.helper.camunda.CamundaVariableDefinition;

public class EshopCamundaVariables{
    public static final CamundaVariableDefinition<?> SHOP = new CamundaVariableDefinition<>("shop", Item.class);
}