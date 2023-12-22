package ch.lt.home.helper.camunda;

import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;

public  class VariableUtils {

    public static ObjectValue toCamundaObjectValue(Object object){
        return Variables.objectValue(object)
                .serializationDataFormat(Variables.SerializationDataFormats.JSON)
                .create();
    }
}
