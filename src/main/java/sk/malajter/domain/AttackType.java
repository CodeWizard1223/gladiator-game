package sk.malajter.domain;

public enum AttackType {
    BASIC_ATTACK("Basic Attack"),
    SPECIAL_ATTACK("Special Attack"),
    DEFENSIVE_ATTACK("Defensive Attack"),
    MAGIC_ATTACK("Magic Attack"),
    COMBO_ATTACK("Combo Attack");

    private String name;

    AttackType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
