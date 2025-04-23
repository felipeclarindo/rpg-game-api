package com.example.rpg_game_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.rpg_game_api.model.Character;

public interface CharacterRepository extends JpaRepository<Character, Long>, JpaSpecificationExecutor<Character> {
}
