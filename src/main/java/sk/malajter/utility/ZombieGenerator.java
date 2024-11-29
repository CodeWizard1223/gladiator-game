package sk.malajter.utility;

import sk.malajter.ability.ZombieAbility;
import sk.malajter.domain.Zombie;

import java.util.HashMap;
import java.util.Map;

public class ZombieGenerator {

    public static Map<Integer, Zombie> createZombies() {
        Map<Integer, Zombie> enemies = new HashMap<>();
        enemies.put(
                1, new Zombie("Regular Zombie", Map.of(
                        ZombieAbility.STRENGTH, 3,
                        ZombieAbility.ARMOR, 1
                ))
        );
        enemies.put(
                2, new Zombie("Conehead Zombie", Map.of(
                        ZombieAbility.STRENGTH, 3,
                        ZombieAbility.ARMOR, 2
                ))
        );
        enemies.put(
                3, new Zombie("Buckethead Zombie", Map.of(
                        ZombieAbility.STRENGTH, 4,
                        ZombieAbility.ARMOR, 4
                ))
        );
        enemies.put(
                4, new Zombie("Pole Vaulting Zombie", Map.of(
                        ZombieAbility.STRENGTH, 5,
                        ZombieAbility.ARMOR, 1,
                        ZombieAbility.CHARGE, 2
                ))
        );
        enemies.put(
                5, new Zombie("Football Zombie", Map.of(
                        ZombieAbility.STRENGTH, 5,
                        ZombieAbility.ARMOR, 3,
                        ZombieAbility.CHARGE, 3
                ))
        );
        enemies.put(
                6, new Zombie("Dancing Zombie", Map.of(
                        ZombieAbility.STRENGTH, 3,
                        ZombieAbility.ARMOR, 1,
                        ZombieAbility.CHARGE, 2
                ))
        );
        enemies.put(
                7, new Zombie("Zomboni", Map.of(
                        ZombieAbility.STRENGTH, 7,
                        ZombieAbility.ARMOR, 5,
                        ZombieAbility.CHARGE, 1,
                        ZombieAbility.AREA_ATTACK, 10
                ))
        );
        enemies.put(
                8, new Zombie("Gargantuar", Map.of(
                        ZombieAbility.STRENGTH, 10,
                        ZombieAbility.ARMOR, 7,
                        ZombieAbility.AREA_ATTACK, 10
                ))
        );
        return enemies;
    }
}
