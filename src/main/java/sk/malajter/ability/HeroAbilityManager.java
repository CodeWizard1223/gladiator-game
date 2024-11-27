package sk.malajter.ability;

import sk.malajter.domain.Plant;
import sk.malajter.utility.InputUtils;
import sk.malajter.utility.PrintUtils;

public class HeroAbilityManager {

    private final Plant plant;

    public HeroAbilityManager(Plant plant) {
        this.plant = plant;
    }

    public void removeHeroAvailablePoints() {
        while (true) {
            System.out.println("Which ability do you want to remove?");
            System.out.println("0. I am done.");
            System.out.println("1. Attack.");
            System.out.println("2. Defence.");
            System.out.println("3. Dexterity.");
            System.out.println("4. Skill.");
            System.out.println("5. Luck.");
            System.out.println("6. Health.");

            final int abilityIndex = InputUtils.readInt();
            PlantAbility plantAbility;
            switch (abilityIndex) {
                case 0 -> {
                    return;
                }
                case 1 -> plantAbility = PlantAbility.ATTACK;
                case 2 -> plantAbility = PlantAbility.DEFENCE;
                case 3 -> plantAbility = PlantAbility.DEXTERITY;
                case 4 -> plantAbility = PlantAbility.SKILL;
                case 5 -> plantAbility = PlantAbility.LUCK;
                case 6 -> plantAbility = PlantAbility.HEALTH;
                // Need to have default because of int variable, if the variable would be enum, we can skip the default option.
                default -> {
                    System.out.println("Invalid ability index.");
                    continue;
                }
            }
            if (this.plant.getAbilities().get(plantAbility) == 1) {
                System.out.println("You cannot remove points from this ability.");
            } else {
                this.plant.updateAbility(plantAbility, -1);
                this.plant.updateHeroAvailablePoints(1);
                System.out.println("You have removed 1 point from " + plantAbility);
                PrintUtils.printAbilities(this.plant);
                PrintUtils.printDivider();
            }
        }
    }

    public void spendHeroAvailablePoints() {
        int availablePoints = plant.getHeroAvailablePoints();

        if (availablePoints == 0) {
            System.out.println("You have no points to spend!");
            return;
        }

        while (availablePoints > 0) {
            System.out.println("You have " + availablePoints + " points to spend. Choose wisely.");
            System.out.println("0. Explain abilities.");
            System.out.println("1. Attack.");
            System.out.println("2. Defence.");
            System.out.println("3. Dexterity.");
            System.out.println("4. Skill.");
            System.out.println("5. Luck.");
            System.out.println("6. Health.");

            final int abilityIndex = InputUtils.readInt();
            PlantAbility plantAbility;
            switch (abilityIndex) {
                case 0 -> {
                    for (PlantAbility a: PlantAbility.values()) {
                        System.out.println(a + ": " + a.getDescription());
                    }
                    System.out.println();
                    continue;
                }
                case 1 -> plantAbility = PlantAbility.ATTACK;
                case 2 -> plantAbility = PlantAbility.DEFENCE;
                case 3 -> plantAbility = PlantAbility.DEXTERITY;
                case 4 -> plantAbility = PlantAbility.SKILL;
                case 5 -> plantAbility = PlantAbility.LUCK;
                case 6 -> plantAbility = PlantAbility.HEALTH;
                default -> {
                    System.out.println("Invalid index.");
                    continue;
                }
            }
            plant.updateAbility(plantAbility, 1);
            System.out.println("You have upgraded " + plantAbility + ".");

            plant.updateHeroAvailablePoints(-1);
            if (availablePoints > 1) {
                PrintUtils.printAbilities(plant);
            }
            availablePoints--;
        }
        System.out.println("You have spent all your available points. Your abilities are: ");
        PrintUtils.printAbilities(plant);
        System.out.println();
    }
}
