package sk.malajter.ability;

public enum ZombieAbility {

    CHARGE("Increases movement speed for a short period of time."),
    AREA_ATTACK("Deals damage to multiple plants in a radius."),
    SLOW_EFFECT("Reduces plant movement speed or attack rate."),
    STRENGTH("Increases attack damage."),
    ARMOR("Reduces incoming damage from plants."),
    LEAP("Jumps over plants or obstacles."),
    STEALTH("Becomes invisible to plants for a short time."),
    BURN("Applies fire damage over time to plants."),
    POISON("Deals damage over time to plants."),
    REGENERATION("Heals the zombie over time.");

    private final String description;

    ZombieAbility(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
