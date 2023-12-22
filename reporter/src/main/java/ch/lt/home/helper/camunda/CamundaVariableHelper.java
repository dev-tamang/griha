package ch.lt.home.helper.camunda;

import org.camunda.bpm.engine.delegate.VariableScope;

public class CamundaVariableHelper {

    private final VariableScope variableScope;

    public CamundaVariableHelper(VariableScope variableScope) {
        this.variableScope = variableScope;
    }

    public <T> T get(CamundaVariableDefinition<T> variable) {
        try {
            var raw = variableScope.getVariableTyped(variable.getName(), true).getValue();
            return variable.getType().cast(raw);
        } catch (Exception e) {
            throw new ClassCastException("Variable: " + variable.getName() + " is null or not found");
        }
    }
}
