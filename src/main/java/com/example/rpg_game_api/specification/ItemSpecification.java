package com.example.rpg_game_api.specification;

import com.example.rpg_game_api.model.Item;
import com.example.rpg_game_api.model.ItemFilter;
import com.example.rpg_game_api.model.ItemType;
import com.example.rpg_game_api.model.ItemRarity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ItemSpecification {
    public static Specification<Item> withFilters(ItemFilter filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.name() != null && !filter.name().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + filter.name().toLowerCase() + "%"));
            }

            if (filter.type() != null) {
                predicates.add(cb.equal(root.get("type"), filter.type()));
            }

            if (filter.minPrice() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("price"), filter.minPrice()));
            }

            if (filter.maxPrice() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("price"), filter.maxPrice()));
            }

            if (filter.rarity() != null) {
                predicates.add(cb.equal(root.get("rarity"), filter.rarity()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
