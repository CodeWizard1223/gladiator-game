package sk.malajter.domain;

public class LoadedGame {

    private final Plant plant;

    private final int level;

    public LoadedGame(Plant plant, int level) {
        this.plant = plant;
        this.level = level;
    }

    public Plant getHero() {
        return plant;
    }

    public int getLevel() {
        return level;
    }
}
