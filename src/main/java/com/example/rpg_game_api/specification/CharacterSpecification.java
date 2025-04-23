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

            if (filter.name() != null && !filter.name().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + filter.name().toLowerCase() + "%"));
            }

            if (filter.characterType() != null) {
                predicates.add(cb.equal(root.get("characterType"), filter.characterType()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
