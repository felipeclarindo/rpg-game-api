package com.example.rpg_game_api.specification;

import com.example.rpg_game_api.model.Character;
import com.example.rpg_game_api.model.CharacterFilter;
import com.example.rpg_game_api.model.CharacterType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CharacterSpecification {
    public static Specification<Character> withFilters(CharacterFilter filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getName() != null && !filter.getName().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + filter.getName().toLowerCase() + "%"));
            }

            if (filter.getCharacterType() != null) {
                predicates.add(cb.equal(root.get("characterType"), filter.getCharacterType()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
