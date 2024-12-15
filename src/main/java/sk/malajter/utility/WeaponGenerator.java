package sk.malajter.utility;

import sk.malajter.ability.Ability;
import sk.malajter.domain.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeaponGenerator {
    public static List<Weapon> generateWeapons(int level) {
        List<Weapon> weapons = new ArrayList<>();

        // Weapons unlocked for level 1
        if (level >= 1) {
            weapons.add(new Weapon("Iron Sword", Map.of(Ability.ATTACK, 5)));
            weapons.add(new Weapon("Wooden Shield", Map.of(Ability.DEFENCE, 3)));
            weapons.add(new Weapon("Leather Boots", Map.of(Ability.DEXTERITY, 2)));
            weapons.add(new Weapon("Healing Herb", Map.of(Ability.HEALTH, 10))); // HEALTH!!!
        }

        // Weapons unlocked for level 3
        if (level >= 3) {
            weapons.clear();
            weapons.add(new Weapon("Steel Dagger", Map.of(Ability.ATTACK, 7, Ability.DEXTERITY, 2)));
            weapons.add(new Weapon("Chainmail Armor", Map.of(Ability.DEFENCE, 5, Ability.DEXTERITY, 5)));
            weapons.add(new Weapon("Quickstrike Gauntlets", Map.of(Ability.ATTACK, 4, Ability.SKILL, 3)));
            weapons.add(new Weapon("Poisoned Blade", Map.of(Ability.ATTACK, 6, Ability.LUCK, 3)));
        }

        // Weapons unlocked for level 5
        if (level >= 5) {
            weapons.clear();
            weapons.add(new Weapon("Mystic Staff", Map.of(Ability.SKILL, 6, Ability.ATTACK, 4)));
            weapons.add(new Weapon("Blessed Shield", Map.of(Ability.DEFENCE, 8, Ability.HEALTH, 10)));
            weapons.add(new Weapon("Shadow Cloak", Map.of(Ability.DEXTERITY, 5, Ability.SKILL, 4)));
            weapons.add(new Weapon("Dual Daggers", Map.of(Ability.ATTACK, 10, Ability.DEXTERITY, 3)));
        }

        // Weapons unlocked for level 7
        if (level >= 7) {
            weapons.clear();
            weapons.add(new Weapon("Dragon Helm", Map.of(Ability.DEFENCE, 10, Ability.LUCK, 5)));
            weapons.add(new Weapon("Warhammer", Map.of(Ability.ATTACK, 15, Ability.SKILL, 3)));
            weapons.add(new Weapon("Frost Wand", Map.of(Ability.ATTACK, 8, Ability.DEFENCE, 5, Ability.SKILL, 5)));
            weapons.add(new Weapon("Amulet of Agility", Map.of(Ability.DEXTERITY, 10, Ability.LUCK, 5)));
        }

        // Weapons unlocked for level 10
        if (level >= 10) {
            weapons.clear();
            weapons.add(new Weapon("Excalibur", Map.of(Ability.ATTACK, 20, Ability.DEXTERITY, 5)));
            weapons.add(new Weapon("Phoenix Armor", Map.of(Ability.DEFENCE, 15, Ability.LUCK, 20)));
            weapons.add(new Weapon("Ring of Precision", Map.of(Ability.SKILL, 10, Ability.LUCK, 8)));
            weapons.add(new Weapon("Thunder Spear", Map.of(Ability.ATTACK, 18, Ability.DEXTERITY, 8, Ability.SKILL, 5)));
        }

        return weapons;
    }
}
