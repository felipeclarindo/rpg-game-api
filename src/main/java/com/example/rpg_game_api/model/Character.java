package com.example.rpg_game_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "The field name is needed.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @NotNull(message = "The field characterType is needed.")
    @Enumerated(EnumType.STRING)
    private CharacterType characterType;

    @Min(value = 1, message = "The level must be at least 1.")
    @Max(value = 99, message = "The level must be at most 50.")
    @NotNull(message = "The field level is needed.")
    private int level;

    @NotNull(message = "The field coins is needed.")
    @Min(value = 0, message = "Coins cannot be negative.")
    private int coins;
}
