package sk.malajter.domain;

import sk.malajter.ability.Ability;

import java.util.Map;

public abstract class GameCharacter {

    protected String name;

    protected Map<Ability, Integer> abilities;

    public GameCharacter(String name, Map<Ability, Integer> abilities) {
        this.abilities = abilities;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<Ability, Integer> getAbilities() {
        return abilities;
    }
}