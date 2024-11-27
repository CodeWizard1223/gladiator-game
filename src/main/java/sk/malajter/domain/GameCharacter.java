package sk.malajter.domain;

import sk.malajter.ability.PlantAbility;

import java.util.Map;

public abstract class GameCharacter {

    protected String name;

    protected Map<PlantAbility, Integer> abilities;

    public GameCharacter(String name, Map<PlantAbility, Integer> abilities) {
        this.name = name;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public Map<PlantAbility, Integer> getAbilities() {
        return abilities;
    }

    public void receiveDamage(int damage) {
        abilities.put(PlantAbility.HEALTH, Math.max(0, abilities.get(PlantAbility.HEALTH) - damage));
    }
}
