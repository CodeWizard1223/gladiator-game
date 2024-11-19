package sk.malajter;

import java.util.HashMap;
import java.util.Map;

public class Hero {
    private String name;
    private Map<Ability, Integer> abilities;

    public Hero(String name) {
        this.name = name;
        this.abilities = this.geInitialAbilities();
    }

    public String getName() {
        return name;
    }

    public Map<Ability, Integer> getAbilities() {
        return abilities;
    }

    // method for creating hashMap of Abilities and their values
    private Map<Ability, Integer> geInitialAbilities() {
        return new HashMap<>(Map.of(
              Ability.ATTACK, 1,
              Ability.DEFENCE, 1,
                Ability.DEXTERITY, 1,
                Ability.SKILL, 1,
                Ability.LUCK, 1,
                Ability.HEALTH, 50
        ));
    }

    public void printAbilities() {
        int index = 1;
        System.out.println("0. Explain abilities");
        for (Map.Entry<Ability, Integer> entry : getAbilities().entrySet()) {
            String abilityName = entry.getKey().toString();
            String formattedName = abilityName.substring(0, 1).toUpperCase() + abilityName.substring(1).toLowerCase();
            System.out.println(index + ". " + formattedName);
            index++;
        }
    }
}
