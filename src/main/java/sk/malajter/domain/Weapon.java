package sk.malajter.domain;

public class Weapon {

    private final String name;

    private int boost;

    public Weapon(String name, int boost) {
        this.name = name;
        this.boost = boost;
    }

    public String getName() {
        return name;
    }

    public int getBoost() {
        return boost;
    }
}
