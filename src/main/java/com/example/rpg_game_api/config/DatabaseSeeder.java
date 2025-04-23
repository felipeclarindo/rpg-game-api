package com.example.rpg_game_api.config;

import com.example.rpg_game_api.model.Character;
import com.example.rpg_game_api.model.CharacterType;
import com.example.rpg_game_api.model.Item;
import com.example.rpg_game_api.model.ItemType;
import com.example.rpg_game_api.model.ItemRarity;
import com.example.rpg_game_api.repository.CharacterRepository;
import com.example.rpg_game_api.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private ItemRepository itemRepository;

    private final Random random = new Random();

    @Override
    public void run(String... args) throws Exception {
        init();
    }

    public void init() {
        seedCharacters();
        seedItems();
    }

    private void seedCharacters() {
        if (characterRepository.count() == 0) {
            List<String> names = List.of(
                    "Aragorn", "Gandalf", "Legolas", "Gimli", "Frodo",
                    "Samwise", "Merry", "Pippin", "Boromir", "Galadriel");
            List<CharacterType> characterTypes = List.of(
                    CharacterType.WARRIOR, CharacterType.WIZARD, CharacterType.ARROW);

            List<Character> characters = new ArrayList<>();
            for (int i = 0; i < 15; i++) {
                characters.add(
                        Character.builder()
                                .name(names.get(random.nextInt(names.size())) + " the "
                                        + getRandomCharacterType(characterTypes))
                                .characterType(getRandomCharacterType(characterTypes))
                                .level(random.nextInt(99) + 1)
                                .coins(random.nextInt(1000))
                                .build());
            }
            characterRepository.saveAll(characters);
            System.out.println("Characters seeded successfully.");
        } else {
            System.out.println("Characters already exist in the database.");
        }
    }

    private CharacterType getRandomCharacterType(List<CharacterType> types) {
        return types.get(random.nextInt(types.size()));
    }

    private void seedItems() {
        if (itemRepository.count() == 0) {
            List<String> weaponNames = List.of("Sword", "Bow", "Staff", "Dagger", "Axe");
            List<String> armorNames = List.of("Leather Armor", "Chainmail", "Plate Armor", "Robe", "Shield");
            List<String> potionNames = List.of("Healing Potion", "Mana Potion", "Strength Potion", "Agility Potion");
            List<String> accessoryNames = List.of("Ring", "Amulet", "Bracelets", "Belt");
            List<ItemType> itemTypes = List.of(ItemType.GUN, ItemType.ARMOR, ItemType.POTION, ItemType.ACCESSORY);
            List<ItemRarity> rarities = List.of(ItemRarity.COMMON, ItemRarity.RARE, ItemRarity.EPIC,
                    ItemRarity.LEGENDARY);

            List<Item> items = new ArrayList<>();

            // Seed weapons (GUN type)
            for (int i = 0; i < 10; i++) {
                items.add(Item.builder()
                        .name(weaponNames.get(random.nextInt(weaponNames.size())) + " of " + getRandomRarity(rarities))
                        .type(ItemType.GUN)
                        .rarity(getRandomRarity(rarities))
                        .price(random.nextInt(200) + 50)
                        .build());
            }

            // Seed armors
            for (int i = 0; i < 10; i++) {
                items.add(Item.builder()
                        .name(armorNames.get(random.nextInt(armorNames.size())) + " of " + getRandomRarity(rarities))
                        .type(ItemType.ARMOR)
                        .rarity(getRandomRarity(rarities))
                        .price(random.nextInt(150) + 30)
                        .build());
            }

            // Seed potions
            for (int i = 0; i < 15; i++) {
                items.add(Item.builder()
                        .name(potionNames.get(random.nextInt(potionNames.size())))
                        .type(ItemType.POTION)
                        .rarity(ItemRarity.COMMON)
                        .price(random.nextInt(30) + 10)
                        .build());
            }

            // Seed accessories
            for (int i = 0; i < 10; i++) {
                items.add(Item.builder()
                        .name(accessoryNames.get(random.nextInt(accessoryNames.size())) + " of "
                                + getRandomRarity(rarities))
                        .type(ItemType.ACCESSORY)
                        .rarity(getRandomRarity(rarities))
                        .price(random.nextInt(100) + 20)
                        .build());
            }

            itemRepository.saveAll(items);
            System.out.println("Items seeded successfully.");
        } else {
            System.out.println("Items already exist in the database.");
        }
    }

    private ItemRarity getRandomRarity(List<ItemRarity> rarities) {
        return rarities.get(random.nextInt(rarities.size()));
    }
}
