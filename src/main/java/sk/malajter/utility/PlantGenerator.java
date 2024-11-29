package sk.malajter.utility;

import sk.malajter.ability.PlantAbility;
import sk.malajter.domain.Plant;

import java.util.HashMap;
import java.util.Map;

public class PlantGenerator {
    public static Map<Integer, Plant> createPlants() {
        Map<Integer, Plant> plants = new HashMap<>();

        // Peashooter: Basic attacker
        plants.put(
                1, new Plant("Peashooter", Map.of(
                        PlantAbility.PIERCING_ATTACK, 5,
                        PlantAbility.PUSH_EFFECT, 2,
                        PlantAbility.HEALTH, 50
                ))
        );

        // Sunflower: Resource generator with minor healing
        plants.put(
                2, new Plant("Sunflower", Map.of(
                        PlantAbility.ENERGY_PRODUCTION, 10,
                        PlantAbility.HEALING, 3,
                        PlantAbility.HEALTH, 50
                ))
        );

        // Wall-nut: High defense blocker
        plants.put(
                3, new Plant("Wall-nut", Map.of(
                        PlantAbility.BLOCK, 8,
                        PlantAbility.PUSH_EFFECT, 1,
                        PlantAbility.HEALTH, 50
                ))
        );

        // Cherry Bomb: Explosive area damage
        plants.put(
                4, new Plant("Cherry Bomb", Map.of(
                        PlantAbility.AREA_DAMAGE, 20,
                        PlantAbility.POISON_EFFECT, 5,
                        PlantAbility.HEALTH, 50
                ))
        );

        // Snow Pea: Slows zombies and attacks
        plants.put(
                5, new Plant("Snow Pea", Map.of(
                        PlantAbility.SLOW_EFFECT, 3,
                        PlantAbility.PIERCING_ATTACK, 6,
                        PlantAbility.PUSH_EFFECT, 2,
                        PlantAbility.HEALTH, 50
                ))
        );

        // Chomper: High damage and poison effect
        plants.put(
                6, new Plant("Chomper", Map.of(
                        PlantAbility.POISON_EFFECT, 10,
                        PlantAbility.AREA_DAMAGE, 7,
                        PlantAbility.HEALTH, 50
                ))
        );

        // Potato Mine: Explosive trap
        plants.put(
                7, new Plant("Potato Mine", Map.of(
                        PlantAbility.AREA_DAMAGE, 15,
                        PlantAbility.PUSH_EFFECT, 5,
                        PlantAbility.HEALTH, 50
                ))
        );

        // Cactus: Long-range attacker with piercing
        plants.put(
                8, new Plant("Cactus", Map.of(
                        PlantAbility.PIERCING_ATTACK, 7,
                        PlantAbility.BLOCK, 2,
                        PlantAbility.HEALTH, 50
                ))
        );

        // Repeater: Multi-shot attacker
        plants.put(
                9, new Plant("Repeater", Map.of(
                        PlantAbility.PIERCING_ATTACK, 9,
                        PlantAbility.PUSH_EFFECT, 3,
                        PlantAbility.HEALTH, 50
                ))
        );

        // Gatling Pea: Rapid-fire, high-damage attacker
        plants.put(
                10, new Plant("Gatling Pea", Map.of(
                        PlantAbility.PIERCING_ATTACK, 12,
                        PlantAbility.AREA_DAMAGE, 6,
                        PlantAbility.HEALTH, 50
                ))
        );
        return plants;
    }
}
