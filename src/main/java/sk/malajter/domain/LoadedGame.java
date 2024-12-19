package sk.malajter.domain;

import sk.malajter.world.region.Region;

public class LoadedGame {

    private final Hero hero;

    private final int level;

    private Region region;

    public LoadedGame(Hero hero, int level, Region region) {
        this.hero = hero;
        this.level = level;
        this.region = region;
    }

    public Hero getHero() {
        return hero;
    }

    public int getLevel() {
        return level;
    }

    public Region getLocation() {
        return region;
    }
}
