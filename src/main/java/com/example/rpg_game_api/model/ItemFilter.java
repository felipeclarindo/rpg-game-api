package com.example.rpg_game_api.model;

public record ItemFilter(String name, ItemType type, Integer minPrice, Integer maxPrice, ItemRarity rarity) {
}
