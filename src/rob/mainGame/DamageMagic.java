package rob.mainGame;

public class DamageMagic {
    String name;
    int damage, mpCost;

    public DamageMagic(String name, int damage, int mpCost) {
        this.name = name;
        this.damage = damage;
        this.mpCost = mpCost;
    }

    static DamageMagic fireball = new DamageMagic("Fireball", 30, 30);
    static DamageMagic thunder_bolt = new DamageMagic("Thunder Bolt", 40, 45);
}
//