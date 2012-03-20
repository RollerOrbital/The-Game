package rob.mainGame;

public class Potion implements Item {
    private PlayerAttribute player = new PlayerAttribute();
    private int hr;
    private String name;

    public Potion(int hr, String name) {
        this.hr = hr;
        this.name = name;
    }

    public Potion basicPotion = new Potion(20, "Basic Potion");

    @Override
    public void useItem(Item i) {
        Potion p = (Potion) i;
        player.health += p.hr;
    }
}
