package sk.malajter.domain;

import sk.malajter.ability.PlantAbility;
import sk.malajter.ability.ZombieAbility;

import java.util.Map;

public class Zombie extends GameCharacter<ZombieAbility>{

    private String name;

    private final Map<ZombieAbility, Integer> abilities;

    public Zombie(String name, Map<ZombieAbility, Integer> abilities) {
        super(name);
        this.abilities = abilities;
    }

    @Override
    public String getName() {
        return name;
    }

    public Map<ZombieAbility, Integer> getAbilities() {
        return abilities;
    }
}
