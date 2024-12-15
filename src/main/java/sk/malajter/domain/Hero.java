package sk.malajter.domain;

import sk.malajter.ability.Ability;
import sk.malajter.constant.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hero extends GameCharacter {

    private int heroAvailablePoints;

    public Hero(String name) {
        super(name, new HashMap<>());
        this.abilities = this.getInitialAbilities();
        this.heroAvailablePoints = Constants.INITIAL_ABILITY_POINTS;
    }

    public Hero(String name, Map<Ability, Integer> abilities, int heroAvailablePoints) {
        super(name, abilities);
        this.heroAvailablePoints = heroAvailablePoints;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeroAvailablePoints() {
        return heroAvailablePoints;
    }

    public void updateAbility(Ability ability, int delta) {
        if (ability.equals(Ability.HEALTH)) {
            this.abilities.put(ability, this.abilities.get(ability) + delta * Constants.HEALTH_OF_ONE_POINT);
        } else {
            this.abilities.put(ability, this.abilities.get(ability) + delta);
        }
    }

    public void updateHeroAvailablePoints(int delta) {
        this.heroAvailablePoints += delta;
    }

    private int calculateBoostedValue(int boostValue) {
        return boostValue * boostValue;
    }

    public void setAbility(Ability ability, int value) {
        abilities.put(ability, value);
    }

    // Method for creating hashMap of Abilities and their values.
    private Map<Ability, Integer> getInitialAbilities() {
        return new HashMap<>(Map.of(
              Ability.ATTACK, 1,
              Ability.DEFENCE, 1,
                Ability.DEXTERITY, 1,
                Ability.SKILL, 1,
                Ability.LUCK, 1,
                Ability.HEALTH, 50
        ));
    }
}
