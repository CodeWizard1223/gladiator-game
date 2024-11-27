//package sk.malajter.service;
//
//import sk.malajter.ability.PlantAbility;
//import sk.malajter.constant.Constants;
//import sk.malajter.domain.Zombie;
//import sk.malajter.domain.GameCharacter;
//import sk.malajter.domain.Plant;
//import sk.malajter.utility.InputUtils;
//import sk.malajter.utility.PrintUtils;
//
//import java.util.Map;
//import java.util.Random;
//
//public class BattleService {
//
//    private final Random random;
//
//    public BattleService() {
//        this.random = new Random();
//    }
//
//    public boolean battle(Plant plant, Zombie zombie) throws InterruptedException {
//        final Map<PlantAbility, Integer> heroAbilities = plant.getAbilities();
//        final Map<PlantAbility, Integer> enemyAbilities = zombie.getAbilities();
//
//        System.out.println("You start the battle first!");
//        PrintUtils.printDivider();
//
//        boolean isHeroTurn = true;
//        while (true) {
//            final int heroLife = plant.getAbilities().get(PlantAbility.HEALTH);
//            final int enemyLife = zombie.getAbilities().get(PlantAbility.HEALTH);
//
//            System.out.println("Your life: " + heroLife);
//            System.out.println("Enemy life: " + enemyLife);
//
//            if (isHeroTurn) {
//                this.battleRound(plant, zombie);
//                isHeroTurn = false;
//            } else {
//                this.battleRound(zombie, plant);
//                isHeroTurn = true;
//            }
//
//            if (heroLife <= 0) {
//                return false;
//            } else if (enemyLife <= 0) {
//                return true;
//            }
//
//            Thread.sleep(Constants.BATTLE_DELAY_MILLIS);
//        }
//    }
//
//    public boolean isHeroReadyToBattle(Plant plant, Zombie zombie) {
//        System.out.println(plant.getName() + " VS " + zombie.getName());
//        System.out.println("View your abilities: ");
//        PrintUtils.printAbilities(plant);
//        System.out.println("View enemy abilities: ");
//        PrintUtils.printAbilities(zombie);
//
//        System.out.println("Are you ready to fight?");
//        System.out.println("0. No");
//        System.out.println("1. Yes");
//
//        final int choice = InputUtils.readInt();
//        switch (choice) {
//            case 0 -> {
//                System.out.println("You have escaped from battle.");
//                return false;
//            }
//            case 1 -> {
//                System.out.println("Let the battle begin!");
//                return true;
//            }
//            default -> {
//                System.out.println("Invalid choice.");
//                return false;
//            }
//        }
//    }
//
//    private void battleRound(GameCharacter attacker, GameCharacter defender) {
//        final Map<PlantAbility, Integer> attackerAbilities = attacker.getAbilities();
//        final Map<PlantAbility, Integer> defenderAbilities = defender.getAbilities();
//
//        // Calculate attack power of attacker.
//        final int minAttack = attackerAbilities.get(PlantAbility.ATTACK);
//        final int maxAttack = minAttack + attackerAbilities.get(PlantAbility.DEXTERITY) + attackerAbilities.get(PlantAbility.SKILL);
//        final int attackPower = random.nextInt(maxAttack - minAttack + 1) + minAttack;
//
//        // Calculate defence power of defender.
//        final int minDefence = defenderAbilities.get(PlantAbility.DEFENCE);
//        final int maxDefence = minDefence + defenderAbilities.get(PlantAbility.DEXTERITY);
//        final int defencePower = random.nextInt(maxDefence - minDefence + 1) + minDefence;
//
//        // Calculate damage.
//        final boolean isCriticalHit = (random.nextInt(101) + 1) < attackerAbilities.get(PlantAbility.LUCK);
//        int damage = Math.max(0, attackPower - defencePower);
//        if (isCriticalHit) {
//            System.out.println("Critical Hit!");
//            damage *= Constants.CRITICAL_HIT_MULTIPLIER;
//        }
//
//        System.out.println(attacker.getName() + " attacks " + defender.getName() + " with " + damage + " damage.");
//        defender.receiveDamage(damage);
//        System.out.println(defender.getName() + " has " + defenderAbilities.get(PlantAbility.HEALTH) + " health.");
//        PrintUtils.printDivider();
//    }
//}
