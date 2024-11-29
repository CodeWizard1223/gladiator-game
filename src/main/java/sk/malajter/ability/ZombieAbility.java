package sk.malajter.ability;

public enum ZombieAbility {

    CHARGE("Increases movement speed for a short period of time."),
    AREA_ATTACK("Deals damage to multiple plants in a radius."),
    STRENGTH("Increases attack damage."),
    ARMOR("Reduces incoming damage from plants.");

    private final String description;

    ZombieAbility(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
