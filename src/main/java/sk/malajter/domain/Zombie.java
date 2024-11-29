package sk.malajter.domain;

import sk.malajter.ability.PlantAbility;
import sk.malajter.ability.ZombieAbility;

import java.util.Map;

public class Zombie {

    private String name;

    private Map<ZombieAbility, Integer> abilities;

    public Zombie(String name, Map<ZombieAbility, Integer> abilities) {
        this.name = name;
        this.abilities = abilities;
    }
}
