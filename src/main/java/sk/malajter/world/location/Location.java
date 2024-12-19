package sk.malajter.world.location;

public class Location {

    protected String name;

    protected String description;

    protected int gameLevel;

    public Location(String name, String description, int gameLevel) {
        this.name = name;
        this.description = description;
        this.gameLevel = gameLevel;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getGameLevel() {
        return gameLevel;
    }
}
