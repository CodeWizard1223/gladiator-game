package sk.malajter.service;

import sk.malajter.ability.HeroAbilityManager;
import sk.malajter.domain.Hero;
import sk.malajter.utility.InputUtils;
import sk.malajter.utility.PrintUtils;

public class GameManager {

    private final Hero hero;

    private final HeroAbilityManager heroAbilityManager;

    public GameManager() {
        this.hero = new Hero("");
        // an option to start game in Main is put the startGame method to constructor of GameManager
        //startGame();
        this.heroAbilityManager = new HeroAbilityManager(this.hero);
    }

    public void startGame() {
        System.out.println("Welcome to the Gladiatus game!");
        System.out.println("Enter your name: ");
        final String name = InputUtils.readString();
        this.hero.setName(name);
        System.out.println("Hello " + hero.getName() + " . Let's start the game!");
        PrintUtils.printDivider();
        System.out.println("\nYour abilities: ");
        PrintUtils.printAbilities(hero);
        PrintUtils.printDivider();
        this.heroAbilityManager.spendHeroAvailablePoints();
    }
}
