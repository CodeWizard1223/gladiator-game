package sk.malajter.domain;

import sk.malajter.ability.PlantAbility;
import sk.malajter.constant.Constants;

import java.util.Map;

public class Plant extends GameCharacter<PlantAbility> {

    private int heroAvailablePoints;

    private Map<PlantAbility, Integer> abilities;

    public Plant(String name, Map<PlantAbility, Integer> abilities) {
        super(name, abilities);
        this.heroAvailablePoints = Constants.INITIAL_ABILITY_POINTS;
    }

    public Plant(String name) {
        super(name);
    }

    public Plant(String name, Map<PlantAbility, Integer> abilities, int heroAvailablePoints) {
        super(name, abilities);
        this.heroAvailablePoints = heroAvailablePoints;
    }

    public Map<PlantAbility, Integer> getAbilities() {
        return abilities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeroAvailablePoints() {
        return heroAvailablePoints;
    }

    public void updateAbility(PlantAbility plantAbility, int delta) {
        if (plantAbility.equals(PlantAbility.HEALTH)) {
            this.abilities.put(plantAbility, this.abilities.get(plantAbility) + delta * Constants.HEALTH_OF_ONE_POINT);
        } else {
            this.abilities.put(plantAbility, this.abilities.get(plantAbility) + delta);
        }
    }

    public void updateHeroAvailablePoints(int delta) {
        this.heroAvailablePoints += delta;
    }

    public void setAbility(PlantAbility plantAbility, int value) {
        abilities.put(plantAbility, value);
    }

    // Method for creating hashMap of Abilities and their values.
//    private Map<PlantAbility, Integer> geInitialAbilities() {
//        return new HashMap<>(Map.of(
//              PlantAbility., 1,
//              PlantAbility.DEFENCE, 1,
//                PlantAbility.DEXTERITY, 1,
//                PlantAbility.SKILL, 1,
//                PlantAbility.LUCK, 1,
//                PlantAbility.HEALTH, 50
//        ));

}
