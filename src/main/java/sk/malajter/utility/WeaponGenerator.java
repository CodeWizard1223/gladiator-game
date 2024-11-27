package sk.malajter.utility;

import sk.malajter.domain.Weapon;

import java.util.HashMap;
import java.util.Map;

public class WeaponGenerator {

    public static Map<Integer, Weapon> createWeapons() {
        Map<Integer, Weapon> weapons = new HashMap<>();
        weapons.put(
                1, new Weapon("Iron Sword", " A basic weapon.\n" +
                        "Boosts: Slightly increases attack and dexterity.")
        );
        weapons.put(
                2, new Weapon("Steel Shield", "Defensive item.\n" +
                        "Boosts: Increases defence significantly, with a minor luck boost.")
        );
        weapons.put(
                3, new Weapon("Flaming Axe", "High-damage weapon with flair.\n" +
                        "Boosts: Increases attack, reduces defence (tradeoff).")
        );
        weapons.put(
                4, new Weapon("Golden Bow", "A ranged weapon for accuracy.\n" +
                        "Boosts: Improves dexterity and luck.")
        );
        weapons.put(
                5, new Weapon("Magic Staff", "A mystical weapon.\n" +
                        "Boosts: Slightly increases attack and skill, heals a small amount of health after each turn.")
        );
        weapons.put(
                6, new Weapon("Venom Dagger", "A small but deadly weapon.\n" +
                        "Boosts: Increases dexterity and luck, with a small attack boost.")
        );
        weapons.put(
                7, new Weapon("Thunder Hammer", "A powerful, heavy weapon.\n" +
                        "Boosts: Increases attack and skill, reduces dexterity slightly (tradeoff).")
        );
        weapons.put(
                8, new Weapon("Ancient Spear", "A legendary weapon for a gladiator.\n" +
                        "Boosts: Increases attack, defence, and luck moderately.")
        );
        weapons.put(
                9, new Weapon("Healing Orb", "Allows partial healing during battles.\n" +
                        "Boosts: Increases health directly and slightly increases luck.")
        );
        weapons.put(
                10, new Weapon("Shadow Blade", "A rare, stealthy weapon.\n" +
                        "Boosts: Improves dexterity, skill, and luck.")
        );
        return weapons;
    }
}
