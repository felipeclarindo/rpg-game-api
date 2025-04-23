package com.example.rpg_game_api.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.rpg_game_api.model.Item;
import com.example.rpg_game_api.model.ItemFilter;
import com.example.rpg_game_api.repository.ItemRepository;
import com.example.rpg_game_api.specification.ItemSpecification;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import jakarta.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@Slf4j
public class ItemController {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    @Operation(summary = "List all items", description = "List all items available.", tags = { "Items" })
    public List<Item> getAll() {
        log.info("Listing all items.");
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an item by ID", description = "Get an item based on the provided ID.", tags = {
            "Items" }, responses = {
                    @ApiResponse(responseCode = "200", description = "Item found"),
                    @ApiResponse(responseCode = "404", description = "Item not found") })
    public Item get(@PathVariable Long id) {
        log.info("Getting item with id: {}", id);
        return getItem(id);
    }

    @GetMapping("/filter")
    @Operation(summary = "Filter items", description = "Filter items based on the provided criteria.", tags = {
            "Items" }, responses = @ApiResponse(responseCode = "200", description = "Filtered items"))
    public Page<Item> filterItems(@ParameterObject ItemFilter filter,
            @ParameterObject @PageableDefault(size = 10, direction = Direction.DESC) Pageable pageable) {
        log.info("Filtering items with criteria: {}", filter);
        return itemRepository.findAll(ItemSpecification.withFilters(filter), pageable);
    }

    @PostMapping
    @Operation(responses = @ApiResponse(responseCode = "201", description = "Item created successfully"), requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Item object to create"), tags = {
            "Items" })
    @ResponseStatus(HttpStatus.CREATED)
    public Item create(@Valid @RequestBody Item item) {
        log.info("Creating item: {}", item.getName());
        return itemRepository.save(item);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete an item by ID", description = "Deletes an item based on the provided ID.", tags = {
            "Items" })
    public void destroy(@PathVariable Long id) {
        log.info("Deleting item with id: {}", id);
        itemRepository.delete(getItem(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an item by ID", description = "Updates an existing item based on the provided ID.", tags = {
            "Items" }, responses = {
                    @ApiResponse(responseCode = "200", description = "Item updated successfully"),
                    @ApiResponse(responseCode = "404", description = "Item not found") }, requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Item object to update"))
    public Item update(@PathVariable Long id, @Valid @RequestBody Item item) {
        log.info("Updating item with id: {}", id);
        getItem(id);
        item.setId(id);
        return itemRepository.save(item);
    }

    private Item getItem(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item with id " + id + " not found."));
    }
}
