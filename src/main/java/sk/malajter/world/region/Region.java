package sk.malajter.world.region;

import sk.malajter.world.location.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Region {

    protected String name;

    protected String description;

    protected int difficulty;

    protected Map<Integer, Location> locations;

    public Region(String name, String description, int difficulty) {
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.locations = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public Map<Integer, Location> getLocations() {
        return locations;
    }


}
