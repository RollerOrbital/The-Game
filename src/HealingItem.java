public class HealingItem {
    String name;
    int healthRestored;

    public HealingItem(String name, int healthRestored) {
        this.name = name;
        this.healthRestored = healthRestored;
    }

    static HealingItem bandages = new HealingItem("Bandages", 20);
    static HealingItem potion = new HealingItem("Potion", 30);
    static HealingItem power_herbs = new HealingItem("Power Herbs", 50);

}
