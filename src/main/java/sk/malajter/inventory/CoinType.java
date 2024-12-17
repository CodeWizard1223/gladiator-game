package sk.malajter.inventory;

public enum CoinType {

    GOLD("- Purchasing top-quality gear and rare artifacts.\n" +
            "- Unlocking exclusive locations or arenas.\n" +
            "- Upgrading advanced gladiator abilities."),
    SILVER("- Buying basic gear, potions, and supplies.\n" +
            "- Minor training or skill refreshes.\n" +
            "- Entry fees for mid-tier battles or events.");

    private final String description;

    CoinType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
