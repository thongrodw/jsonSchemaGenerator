package com.example.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Component
public class Generator {

    public JsonSchema generateJsonSchema(Class<?> clazz) throws JsonMappingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonSchemaGenerator generator = new JsonSchemaGenerator(mapper);
        return generator.generateSchema(clazz);
    }

    public void generateAndExportJsonSchema(Class<?> clazz, String fileName) throws JsonProcessingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonSchemaGenerator generator = new JsonSchemaGenerator(mapper);
        JsonSchema jsonSchema = generator.generateSchema(clazz);
        String schemaAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema);
        writeToFile(schemaAsString, fileName);
    }

    private void writeToFile(String content, String fileName) {
        try {
            String resourcePath = "src/main/resources/";
            String filePath = resourcePath + fileName;
            Files.write(Paths.get(filePath), content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
