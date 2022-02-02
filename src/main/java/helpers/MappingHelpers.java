package helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.ModelPackage;

public class MappingHelpers {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Map the fields of the 'Model Package' json node from the API response
     *
     * @param responseBody             the specific json body as string value which comes back from API
     * @return                         the models.ModelPackage object with field values set
     * @throws JsonProcessingException error thrown should mapping not work as expected
     */
    public static ModelPackage mapModelPackageNode(String responseBody) {
        ModelPackage modelPackage = new ModelPackage();
        try {
            objectMapper.convertValue(objectMapper.readTree(responseBody).get("modelPackage"), new TypeReference<ModelPackage>(){});
        } catch (JsonProcessingException e) {

        }
        return modelPackage;
    }
}
