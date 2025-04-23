package com.example.rpg_game_api.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rpg_game_api.model.ApiResponseDescription;

import io.swagger.v3.oas.annotations.Operation;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
@Cacheable(value = "apiDescription")
public class ApiController {

    @GetMapping
    @Operation(summary = "API description", description = "Get API description", tags = { "API" })
    public ResponseEntity<Object> index() {
        ApiResponseDescription apiDescription = new ApiResponseDescription();

        apiDescription.setMessage("Welcome to the Students Manager API").setStatus("API is running")
                .setDescription("This API is a simple CRUD to manage students.").setAuthor("Felipe Clarindo")
                .setGithubAuthor("https://github.com/felipeclarindo").setVersion("1.0.0")
                .setRepositoryUrl("https://github.com/felipeclarindo/students-manager-api");

        return ResponseEntity.status(200).body(apiDescription);
    }
}