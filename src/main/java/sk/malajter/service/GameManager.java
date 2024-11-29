package sk.malajter.service;

import sk.malajter.ability.PlantAbility;
import sk.malajter.ability.HeroAbilityManager;
import sk.malajter.constant.Constants;
import sk.malajter.domain.Zombie;
import sk.malajter.domain.Plant;
import sk.malajter.domain.LoadedGame;
import sk.malajter.utility.ZombieGenerator;
import sk.malajter.utility.InputUtils;
import sk.malajter.utility.PrintUtils;

import java.util.Map;

public class GameManager {

    private Plant plant;

    private final HeroAbilityManager heroAbilityManager;

    private int currentLevel;

    private final FileService fileService;

    private final BattleService battleService;

    private final Map<Integer, Zombie> enemiesByLevel;

    public GameManager() {
        this.plant = new Plant("");
        // An option to start game in Main is put the startGame method to constructor of GameManager:
        //startGame();
        this.heroAbilityManager = new HeroAbilityManager(this.plant);
        this.currentLevel = Constants.INITIAL_LEVEL;
        this.fileService = new FileService();
        this.battleService = new BattleService();
        this.enemiesByLevel = ZombieGenerator.createZombies();
    }

    public void startGame() throws InterruptedException {
        this.initGame();

        while (this.currentLevel <= this.enemiesByLevel.size()) {
            final Zombie zombie = this.enemiesByLevel.get(this.currentLevel);
            System.out.println("0. Fight " + zombie.getName() + " (Level " + this.currentLevel + ")");
            System.out.println("1. Upgrade abilities (" + plant.getHeroAvailablePoints() + " points to spend.)");
            System.out.println("2. Choose weapons or special items.");
            System.out.println("3. Save game.");
            System.out.println("4. Exit game.");

            final int choice = InputUtils.readInt();
            switch (choice) {
                case 0 -> {
                    if (this.battleService.isHeroReadyToBattle(this.plant, zombie)) {
                        final int heroHealthBeforeBattle = this.plant.getAbilities().get(PlantAbility.HEALTH);

                        final boolean hasHeroWon = this.battleService.battle(this.plant, zombie);
                        if (hasHeroWon) {
                            PrintUtils.printDivider();
                            System.out.println("You have won this battle! You have gained " + this.currentLevel + " ability points.");
                            this.plant.updateHeroAvailablePoints(this.currentLevel);
                            this.currentLevel++;
                        } else {
                            System.out.println("You have lost.");
                        }
                        this.plant.setAbility(PlantAbility.HEALTH, heroHealthBeforeBattle);
                        System.out.println("You have full health now.");
                        PrintUtils.printDivider();
                    }
                }
                case 1 -> {
                    this.upgradeAbilities();
                }
                case 2 -> {
                    

                    // choose weapon TODO
                }
                case 3 -> {
                    this.fileService.saveGame(this.plant, this.currentLevel);
                }
                case 4 -> {
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

    private void upgradeAbilities() {
        System.out.println("Your abilities are:");
        PrintUtils.printAbilities(this.plant);

        System.out.println("0. Go back.");
        System.out.println("1. Spend points. (" + plant.getHeroAvailablePoints() + " points to spend.)");
        System.out.println("2. Remove points.");

        final int choice = InputUtils.readInt();
        switch (choice) {
            case 0 -> {}
            case 1 -> this.heroAbilityManager.spendHeroAvailablePoints();
            case 2 -> this.heroAbilityManager.removeHeroAvailablePoints();
            default -> System.out.println("Invalid choice.");
        }
    }

    private void initGame() {
        System.out.println("Welcome to the Gladiatus game!");

        System.out.println("0. Start new game.");
        System.out.println("1. Load game.");

        final int choice = InputUtils.readInt();
        switch (choice) {
            case 0 -> {
                System.out.println("Let's go then.");
            }
            case 1 -> {
                final LoadedGame loadGame = fileService.loadGame();
                if (loadGame != null) {
                    this.plant = loadGame.getHero();
                    this.currentLevel = loadGame.getLevel();
                    return;
                }
            }
            default -> System.out.println("Invalid choice.");
        }

        System.out.println("Enter your name: ");
        final String name = InputUtils.readString();
        this.plant.setName(name);
        System.out.println("Hello " + plant.getName() + ". Let's start the game!");
        PrintUtils.printDivider();
        System.out.println("\nYour abilities: ");
        PrintUtils.printAbilities(plant);
        PrintUtils.printDivider();
        this.heroAbilityManager.spendHeroAvailablePoints();
    }
}
