package ch.lt.home.helper.camunda;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.type.ValueType;
import org.camunda.bpm.engine.variable.value.ObjectValue;

import java.util.Arrays;
import java.util.List;

@Slf4j
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

    public List<Class<?>> primitiveTypes() {
        return Arrays.asList(
                ValueType.INTEGER.getJavaType(),
                ValueType.BOOLEAN.getJavaType(),
                ValueType.STRING.getJavaType());
    }

    public void set(CamundaVariableDefinition<?> variable, Object value) {
        try {
            if (primitiveTypes().contains(variable.getType())) {
                variableScope.setVariable(variable.getName(), value);
            } else {
                ObjectValue objectValue = Variables.objectValue(value)
                        .serializationDataFormat(Variables.SerializationDataFormats.JSON)
                        .create();
                variableScope.setVariable(variable.getName(), objectValue);
            }
        } catch (Exception e) {
            log.warn("the exception is " + e);
            throw new ClassCastException("while updating Variable: " + variable.getName());
        }
    }
}
