package com.example.rpg_game_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "The field name is needed.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @NotNull(message = "The field type is needed.")
    @Enumerated(EnumType.STRING)
    private ItemType type;

    @NotNull(message = "The field rarity is needed.")
    @Enumerated(EnumType.STRING)
    private ItemRarity rarity;

    @Positive(message = "Price must be a positive value.")
    private int price;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Character owner;
}
