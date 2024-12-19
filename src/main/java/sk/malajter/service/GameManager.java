package sk.malajter.service;

import sk.malajter.ability.Ability;
import sk.malajter.ability.HeroAbilityManager;
import sk.malajter.constant.Constants;
import sk.malajter.domain.Enemy;
import sk.malajter.domain.Hero;
import sk.malajter.domain.LoadedGame;
import sk.malajter.domain.Weapon;
import sk.malajter.world.location.Location;
import sk.malajter.world.region.Region;
import sk.malajter.utility.EnemyGenerator;
import sk.malajter.utility.InputUtils;
import sk.malajter.utility.PrintUtils;

import sk.malajter.utility.WeaponGenerator;

import java.util.*;

public class GameManager {

    private Hero hero;

    private final HeroAbilityManager heroAbilityManager;

    private int currentLevel;

    private final FileService fileService;

    private final BattleService battleService;

    private final Map<Integer, Enemy> enemiesByLevel;

    private final RegionService regionService;

    private Region currentRegion;

    private int difficulty;

    public GameManager() {
        this.hero = new Hero("");
        // An option to start game in Main is put the startGame method to constructor of GameManager:
        //startGame();
        this.heroAbilityManager = new HeroAbilityManager(this.hero);
        this.currentLevel = Constants.INITIAL_LEVEL;
        this.fileService = new FileService();
        this.battleService = new BattleService();
        this.enemiesByLevel = EnemyGenerator.createEnemies();
        this.regionService = new RegionService();
        this.difficulty = Constants.DIFFICULTY_LEVEL;
    }

    public void startGame() throws InterruptedException {
        this.initGame();
        this.setInitialRegion();

        // FIX!!!
        while (true) {
            boolean heroProgressed = false;
            for (Location location : this.currentRegion.getLocations().values()) {
                enterLocation(location);

                if (!isHeroEligibleForLocation()) {
                    printLocationEligibilityMessage();
                    break;
                }

                Enemy enemy = this.enemiesByLevel.get(this.currentLevel);
                handleUserActions(enemy);
                heroProgressed = true;

                if (this.hero.isInventoryFull(Constants.INVENTORY_CAPACITY)) {
                    handleInventoryFull();
                    return;
                }
            }
            if (!heroProgressed) {
                System.out.println("Congratulations! You have completed the game!");
                break; // Exit the while loop
            }
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
                    this.hero = loadGame.getHero();
                    this.currentLevel = loadGame.getLevel();
                    return;
                }
            }
            default -> System.out.println("Invalid choice.");
        }

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

    private void setInitialRegion() {
        this.currentRegion = this.regionService.getRegionList().get(difficulty);
        System.out.println("The game start in region " + this.currentRegion.getName() + ".");
        System.out.println(this.currentRegion.getDescription());
        PrintUtils.printDivider();
    }

    private void enterLocation(Location location) {
        System.out.println("Entering location: " + location.getName());
        System.out.println(location.getDescription());
    }

    private boolean isHeroEligibleForLocation() {
        return hero.getAbilities().get(Ability.SKILL) > this.currentLevel;
    }

    private void printLocationEligibilityMessage() {
        System.out.println("You are not ready for this location.");
        System.out.println("Try upgrading abilities or choosing better weapons.");
    }

    private void handleUserActions(Enemy enemy) throws InterruptedException {
        System.out.println("0. Fight " + enemy.getName() + " (Level " + this.currentLevel + ")");
        System.out.println("1. Upgrade abilities.");
        System.out.println("2. Save game.");
        System.out.println("3. Exit game.");

        int choice = InputUtils.readInt();
        switch (choice) {
            case 0 -> handleBattle(enemy);
            case 1 -> upgradeAbilities();
            case 2 -> fileService.saveGame(hero, currentLevel);
            case 3 -> exitGame();
            default -> System.out.println("Invalid input.");
        }
    }

    private void upgradeAbilities() {
        System.out.println("Your abilities are:");
        PrintUtils.printAbilities(this.hero);

        System.out.println("0. Go back.");
        System.out.println("1. Spend points. (" + hero.getHeroAvailablePoints() + " points to spend.)");
        System.out.println("2. Remove points.");

        final int choice = InputUtils.readInt();
        switch (choice) {
            case 0 -> {
            }
            case 1 -> this.heroAbilityManager.spendHeroAvailablePoints();
            case 2 -> this.heroAbilityManager.removeHeroAvailablePoints();
            case 3 -> System.out.println("Invalid choice.");
        }
    }

    private void handleBattle(Enemy enemy) throws InterruptedException {
        if (this.battleService.isHeroReadyToBattle(this.hero, enemy)) {
            int heroHealthBeforeBattle = this.hero.getAbilities().get(Ability.HEALTH);

            if (this.battleService.battle(this.hero, enemy)) {
                System.out.println("You have won the battle! Gained " + currentLevel + " ability points.");
                this.hero.updateHeroAvailablePoints(currentLevel);
                this.currentLevel++;
                handleWeaponChoice();
            } else {
                System.out.println("You have lost this battle.");
            }

            this.hero.setAbility(Ability.HEALTH, heroHealthBeforeBattle);
            System.out.println("Your health has been restored.");
            PrintUtils.printDivider();
        }
    }

    private void handleWeaponChoice() {
        while (true) {
            System.out.println("Do you want to choose a weapon?");
            System.out.println("0. No. Go back.");
            System.out.println("1. View weapon details.");
            System.out.println("2. Choose a weapon.");

            int choice = InputUtils.readInt();
            switch (choice) {
                case 0 -> {
                    return;
                }
                case 1 -> printWeaponDetails();
                case 2 -> {
                    handleWeaponSelection();
                    return;
                }
                default -> System.out.println("Invalid input.");
            }
        }
    }

    private void handleInventoryFull() {
        this.difficulty++;
        this.unlockNextRegion();
        System.out.println("Inventory full! You've unlocked the next region.");
    }

    private void exitGame() {
        System.out.println("Are you sure?");
        System.out.println("0. No");
        System.out.println("1. Yes");
        int exitChoice = InputUtils.readInt();

        if (exitChoice == 1) {
            System.out.println("Bye!");
            System.exit(0);
        } else {
            System.out.println("Continuing...");
            PrintUtils.printDivider();
        }
    }

    private void printWeaponDetails() {
        List<Weapon> weaponList = WeaponGenerator.generateWeapons(this.currentLevel);
        for (Weapon weapon : weaponList) {
            Map<Ability, Integer> boost = weapon.getBoost();
            System.out.println(weapon.getName() + " boost your ability: ");
            boost.forEach((ability, boostValue) ->
                    System.out.println(ability + ": " + boostValue + " times."));
            System.out.println();
        }
    }

    private void handleWeaponSelection() {
        while (true) {
            System.out.println("Do you want to choose some weapon?");
            System.out.println("0. No. Go back.");
            System.out.println("1. Description.");
            System.out.println("2. Choose a weapon.");

            final int choice = InputUtils.readInt();
            switch (choice) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    printWeaponDetails();
                }
                case 2 -> {
                    selectWeapon();
                    return;
                }
                default -> System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private void selectWeapon() {
        List<Weapon> weaponList = WeaponGenerator.generateWeapons(this.currentLevel);
        System.out.println("Available weapons:");
        for (int i = 0; i < weaponList.size(); i++) {
            System.out.println(i + ". " + weaponList.get(i).getName());
        }

        System.out.println("Enter your choice: ");
        int choice = InputUtils.readInt();
        if (choice >= 0 && choice < weaponList.size()) {
            Weapon selectedWeapon = weaponList.get(choice);
            this.applyWeaponBoost(selectedWeapon);
            Map<Ability, Integer> boost = selectedWeapon.getBoost();
            System.out.println("Boosted abilities:");
            boost.forEach((ability, boostValue) -> {
                System.out.println(ability + ": " + boostValue + " times.");
            });
            PrintUtils.printAbilities(this.hero);
        } else {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private void applyWeaponBoost(Weapon weapon) {
        Map<Ability, Integer> weaponAbilities = weapon.getBoost();
        Map<Ability, Integer> heroAbilities = this.hero.getAbilities();
        for (Map.Entry<Ability, Integer> entry : weaponAbilities.entrySet()) {
            Ability ability = entry.getKey();
            int boostValue = entry.getValue();
            heroAbilities.put(ability, heroAbilities.getOrDefault(ability, 0) + boostValue);
        }
    }

    private void unlockNextRegion() {
        System.out.println("Congratulation! You have completed region " + this.currentRegion.getName() + ".");
        int nextDifficulty = this.difficulty + 1;

        Region nextRegion = this.regionService.getRegionList().get(nextDifficulty);
        if (nextRegion != null) {
            System.out.println("You have unlocked the new region: " + nextRegion.getName() + ".");
        } else {
            System.out.println("You have reached the end of the game.");
            System.exit(0);
        }
    }
}





