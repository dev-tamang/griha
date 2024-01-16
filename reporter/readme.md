## Rest Api

* Need to send serialized json string when using object as variable type.

```
{
  "variables": {
    "person": {
      "type": "Object",
      "value": "{\"firstName\":\"Test\",\"lastName\":\"Person\",\"dateOfBirth\":\"2000-01-01\"}",
      "valueInfo": {
        "serializationDataFormat": "application/json",
        "objectTypeName": "ch.lt.home.helloworld.dto.Person"
      }
    }
  }
}
```

## LocalDate Serializer and Deserializer

See Person.java class for use jackson annotation to serialize and deserialize.

DO NOT FORGET TO USE THE FOLLOWING LIBRARY

> implementation("org.camunda.bpm:camunda-engine-plugin-spin")

> implementation("org.camunda.spin:camunda-spin-dataformat-json-jackson")

instead of

> implementation("org.camunda.spin:camunda-spin-dataformat-all")
