package rob;

public class RangeWeapon {
    String name;
    int damage;

    public RangeWeapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    static RangeWeapon bb_gun = new RangeWeapon("BB Gun", 1);
    static RangeWeapon revolver = new RangeWeapon("Revolver", 4);
}
