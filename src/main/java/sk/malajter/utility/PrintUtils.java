package sk.malajter.utility;

import sk.malajter.ability.PlantAbility;
import sk.malajter.domain.GameCharacter;

import java.util.Map;

public class PrintUtils {

    public static void printAbilities(GameCharacter hero) {
        for (Map.Entry<PlantAbility, Integer> entry: hero.getAbilities().entrySet()) {
            System.out.print(entry.getKey() + ": " + entry.getValue() + ", ");
        }
        System.out.println();
    }

    public static void printDivider() {
        System.out.println("-------------------------------------");
    }
}
