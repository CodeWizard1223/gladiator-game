package sk.malajter.domain;

import sk.malajter.ability.Ability;

import java.util.Map;

public class Weapon {

    private String name;

    private Map<Ability, Integer> boost;

    public Weapon(String name, Map<Ability, Integer> boost) {
        this.name = name;
        this.boost = boost;
    }

    public String getName() {
        return name;
    }

    public Map<Ability, Integer> getBoost() {
        return boost;
    }

    public int getBoostValue() {
        for (Map.Entry<Ability, Integer> entry : this.boost.entrySet()) {
            return entry.getValue();
        }
        return 0;
    }

    public Ability getWeaponAbility() {
        for (Map.Entry<Ability, Integer> entry : this.boost.entrySet()) {
            return entry.getKey();
        }
        return null;
    }
}
