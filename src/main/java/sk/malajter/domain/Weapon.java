package sk.malajter.domain;

public class Weapon {

    private final String name;

    private final String description;

    public Weapon(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void printWeapons() {
        System.out.println(this.name + ": " + this.description);
    }
}
