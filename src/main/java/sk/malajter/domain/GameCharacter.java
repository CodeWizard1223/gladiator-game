package sk.malajter.domain;

import java.util.HashMap;
import java.util.Map;

public abstract class GameCharacter<T extends Enum<T>>{

    protected String name;

    protected Map<T, Integer> abilities;

    public GameCharacter(String name) {
        this.name = name;
    }

    public GameCharacter(String name, Map<T, Integer> abilities) {
        this.name = name;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public Map<T, Integer> getAbilities() {
        return abilities;
    }

    //    public void receiveDamage(int damage) {
//        abilities.put(PlantAbility.HEALTH, Math.max(0, abilities.get(PlantAbility.HEALTH) - damage));
//    }
}
