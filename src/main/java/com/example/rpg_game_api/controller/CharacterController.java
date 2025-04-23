package com.example.rpg_game_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.rpg_game_api.model.Character;
import com.example.rpg_game_api.model.CharacterFilter;
import com.example.rpg_game_api.repository.CharacterRepository;
import com.example.rpg_game_api.specification.CharacterSpecification;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springdoc.core.annotations.ParameterObject;

import jakarta.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@Slf4j
public class CharacterController {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @GetMapping
    @Operation(summary = "List all characters", description = "List all characters.", tags = { "Characters" })
    public List<Character> getAll() {
        log.info("Listing all characters.");
        return characterRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a character by ID", description = "Get a character based on the provided ID.", tags = {
            "Characters" }, responses = {
                    @ApiResponse(responseCode = "200", description = "Character found"),
                    @ApiResponse(responseCode = "404", description = "Character not found") })
    public Character get(@PathVariable Long id) {
        log.info("Getting character with id: {}", id);
        return getCharacter(id);
    }

    @GetMapping("/filter")
    @Operation(summary = "Filter characters", description = "Filter characters based on the provided criteria.", tags = {
            "Characters" }, responses = @ApiResponse(responseCode = "200", description = "Filtered characters"))
    public Page<Character> filterCharacters(@ParameterObject CharacterFilter filter,
            @ParameterObject @PageableDefault(size = 10, direction = Direction.DESC) Pageable pageable) {
        log.info("Filtering characters with criteria: {}", filter);
        return characterRepository.findAll(CharacterSpecification.withFilters(filter), pageable);
    }

    @PostMapping
    @Operation(responses = @ApiResponse(responseCode = "201", description = "Character created successfully"), requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Character object to create"), tags = {
            "Characters" })
    @ResponseStatus(HttpStatus.CREATED)
    public Character create(@Valid @RequestBody Character character) {
        log.info("Creating character: {}", character.getName());
        return characterRepository.save(character);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a character by ID", description = "Deletes a character based on the provided ID.", tags = {
            "Characters" })
    public void destroy(@PathVariable Long id) {
        log.info("Deleting character with id: {}", id);
        characterRepository.delete(getCharacter(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a character by ID", description = "Updates an existing character based on the provided ID.", tags = {
            "Characters" }, responses = {
                    @ApiResponse(responseCode = "200", description = "Character updated successfully"),
                    @ApiResponse(responseCode = "404", description = "Character not found") }, requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Character object to update"))
    public Character update(@PathVariable Long id, @Valid @RequestBody Character character) {
        log.info("Updating character with id: {}", id);
        getCharacter(id);
        character.setId(id);
        return characterRepository.save(character);
    }

    private Character getCharacter(Long id) {
        return characterRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Character with id " + id + " not found."));
    }
}
