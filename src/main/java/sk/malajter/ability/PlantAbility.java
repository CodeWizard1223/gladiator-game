package sk.malajter.ability;

public enum PlantAbility {

    ENERGY_PRODUCTION("Plants like the Sunflower produce sun to serve as a resource for planting more units or using special abilities."),
    AREA_DAMAGE("Some plants (e.g., Cherry Bomb) deal damage to multiple enemies in a radius."),
    PIERCING_ATTACK("Plants like the Repeater or Laser Bean can attack multiple enemies in a straight line."),
    SLOW_EFFECT("Plants like the Snow Pea can reduce enemy movement speed or attack rate."),
    HEALING("Some plants, like the Marigold or Aloe in PvZ2, can heal themselves or other plants nearby."),
    BLOCK("Plants like the Wall-nut or Tall-nut have extra durability and can block multiple attacks."),
    PUSH_EFFECT("Some plants can push zombies backward (e.g., Kernel-pult’s butter stun effect)."),
    POISON_EFFECT("Deals damage over time (e.g., Doomshroom could release toxic gas)."),
    CLONING("Some plants might spawn smaller plants or copies of themselves to overwhelm zombies."),
    HEALTH("Temporary"),
    LUCK("Temporary");


    private final String description;

    PlantAbility(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
