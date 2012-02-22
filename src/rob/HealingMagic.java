package rob;

public class HealingMagic {
    String name;
    int healthRestored, mpCost;

    public HealingMagic(String name, int healthRestored, int mpCost) {
        this.name = name;
        this.healthRestored = healthRestored;
        this.mpCost = mpCost;
    }

    static HealingMagic basic_heal = new HealingMagic("Basic Heal", 20, 30);
    static HealingMagic recover = new HealingMagic("Recover", 30, 50);
    static HealingMagic regeneration = new HealingMagic("Regeneration", 70, 90);

}
