package sk.malajter.utility;

import sk.malajter.domain.Weapon;

import java.util.ArrayList;
import java.util.List;

public class WeaponGenerator {

    public static List<Weapon> generateWeapons() {

        List<Weapon> weapons = new ArrayList<>();

        weapons.add(new Weapon("Weapon1", 1));
        weapons.add(new Weapon("Weapon2", 2));
        weapons.add(new Weapon("Weapon3", 3));

        return weapons;

    }
}
