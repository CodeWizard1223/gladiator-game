package sk.malajter.domain.location;

import sk.malajter.domain.Enemy;
import sk.malajter.item.Item;

import java.util.List;

public abstract class Location {

    protected String name;

    protected String description;

    protected Enemy enemies;

    protected Item item;

    protected boolean HasEnemies;

    protected int difficultyLevel;

    protected List<String> rewards;
}
