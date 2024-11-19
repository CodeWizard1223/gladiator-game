package sk.malajter;

import java.util.Map;
import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);
    private static int MAX_POINTS = 7;

    public static void main(String[] args) {

        System.out.println("Welcome to the Gladiatus game!");
        System.out.println("Enter your name: ");

        final String name = scanner.nextLine();
        final Hero hero = new Hero(name);
        System.out.println("Hello " + hero.getName() + " . Let's start the game!");

        while (true) {
            if (MAX_POINTS == 0) {
                System.out.println("You have no more points to spend.");
                break;
            }
            System.out.println("\nYour abilities: ");
            for (Map.Entry<Ability, Integer> entry : hero.getAbilities().entrySet()) {
                System.out.print(entry.getKey() + ": " + entry.getValue() + ", ");
            }
            System.out.println();

            System.out.println("\nYou have " + MAX_POINTS + " points to spend.");
            hero.printAbilities();
            int upgradeAbilities = scanner.nextInt();
            // Explain abilities if user enters 0
            if (upgradeAbilities == 0) {
                for (Map.Entry<Ability, Integer> entry : hero.getAbilities().entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getKey().getDescription());
                }
                // Upgrade a specific ability
            } else if (upgradeAbilities > 0 && upgradeAbilities <= hero.getAbilities().size()) {
                int index = 1;
                for (Map.Entry<Ability, Integer> entry : hero.getAbilities().entrySet()) {
                    if (index == upgradeAbilities) {
                        hero.getAbilities().put(entry.getKey(), entry.getValue() + 1);
                        MAX_POINTS -= 1;
                        break;
                    }
                    index++;
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
