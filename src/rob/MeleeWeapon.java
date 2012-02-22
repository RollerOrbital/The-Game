package rob;

public class MeleeWeapon {
    String name;
    int damage;

    public MeleeWeapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    static MeleeWeapon fists = new MeleeWeapon("Fist", 1);
    static MeleeWeapon police_baton = new MeleeWeapon("Police Baton", 5);
}
