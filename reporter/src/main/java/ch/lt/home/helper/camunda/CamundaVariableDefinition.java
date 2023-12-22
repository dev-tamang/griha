package ch.lt.home.helper.camunda;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CamundaVariableDefinition<T> {
    private String name;
    private Class<T> type;
}
