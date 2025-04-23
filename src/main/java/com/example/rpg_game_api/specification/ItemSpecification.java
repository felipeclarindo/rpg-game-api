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

            if (filter.getName() != null && !filter.getName().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + filter.getName().toLowerCase() + "%"));
            }

            if (filter.getType() != null) {
                predicates.add(cb.equal(root.get("type"), filter.getType()));
            }

            if (filter.getMinPrice() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("price"), filter.getMinPrice()));
            }

            if (filter.getMaxPrice() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("price"), filter.getMaxPrice()));
            }

            if (filter.getRarity() != null) {
                predicates.add(cb.equal(root.get("rarity"), filter.getRarity()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
