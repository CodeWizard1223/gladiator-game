package sk.malajter.service;

import sk.malajter.ability.HeroAbilityManager;
import sk.malajter.constant.Constants;
import sk.malajter.domain.Hero;
import sk.malajter.utility.InputUtils;
import sk.malajter.utility.PrintUtils;

public class GameManager {

    private final Hero hero;

    private final HeroAbilityManager heroAbilityManager;

    private int currentLevel;

    public GameManager() {
        this.hero = new Hero("");
        // an option to start game in Main is put the startGame method to constructor of GameManager
        //startGame();
        this.heroAbilityManager = new HeroAbilityManager(this.hero);
        this.currentLevel = Constants.INITIAL_LEVEL;
    }

    public void startGame() {
        this.initGame();

        while (currentLevel <= 5) {
            System.out.println("0. Fight " + "Level " + this.currentLevel);
            System.out.println("1. Upgrade abilities (" + hero.getHeroAvailablePoints() + " points to spend.");
            System.out.println("2. Save game.");
            System.out.println("3. Exit game.");

            final int choice = InputUtils.readInt();
            switch (choice) {
                case 0 -> {
                    // TODO fight
                    this.currentLevel++;
                }
                case 1 -> {
                    // TODO upgrade abilities
                }
                case 2 -> {
                    // TODO save game
                }
                case 3 -> {
                    System.out.println("Are you sure?");
                    System.out.println("0. No");
                    System.out.println("1. Yes");
                    final int exitChoice = InputUtils.readInt();
                    if (exitChoice == 1) {
                        System.out.println("Bye!");
                        return;
                    }
                    System.out.println("Continuing....");
                    PrintUtils.printDivider();
                }
                default -> System.out.println("Invalid input.");
            }
        }
        System.out.println("Congratulation! You won the game.");
    }
    private void initGame() {
        System.out.println("Welcome to the Gladiatus game!");
        System.out.println("Enter your name: ");
        final String name = InputUtils.readString();
        this.hero.setName(name);
        System.out.println("Hello " + hero.getName() + ". Let's start the game!");
        PrintUtils.printDivider();
        System.out.println("\nYour abilities: ");
        PrintUtils.printAbilities(hero);
        PrintUtils.printDivider();
        this.heroAbilityManager.spendHeroAvailablePoints();
    }
}
