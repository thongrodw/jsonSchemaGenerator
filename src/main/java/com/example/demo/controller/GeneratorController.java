package com.example.demo.controller;

import com.example.demo.model.ExampleClass;
import com.example.demo.model.User;
import com.example.demo.utils.Generator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class GeneratorController {

    @Autowired
    Generator generator;

    @GetMapping(path = "/json")
    public JsonSchema generateJsonSchema() throws JsonMappingException {
        return generator.generateJsonSchema(User.class);
    }

}
