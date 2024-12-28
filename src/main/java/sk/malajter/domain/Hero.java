package sk.malajter.domain;

import sk.malajter.ability.Ability;
import sk.malajter.constant.Constants;
import sk.malajter.item.Item;

import java.util.*;

public class Hero extends GameCharacter {

    private int heroAvailablePoints;

    private List<Item> inventory;

    public Hero(String name) {
        super(name, new HashMap<>());
        this.abilities = this.getInitialAbilities();
        this.heroAvailablePoints = Constants.INITIAL_ABILITY_POINTS;
        // Initialize inventory
        this.inventory = new ArrayList<>();
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
                Ability.SKILL, 2,
                Ability.LUCK, 1,
                Ability.HEALTH, 50
        ));
    }

    // Add item to inventory
    public void addItem(Item item) {
        inventory.add(item);
        System.out.println("You collected: " + item.getName());
    }

    // Check if inventory is full (adjust based on region completion criteria)
    public boolean isInventoryFull(int requiredItems) {
        return inventory.size() >= requiredItems;
    }
}
