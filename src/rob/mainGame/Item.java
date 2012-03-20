package rob.mainGame;

public class Item {

    public Item() {
    }

    public class Bandage {
        private int healthRestored;
        private String name;

        public Bandage(int healthRestored, String name) {
            this.healthRestored = healthRestored;
            this.name = name;
        }

        public Bandage weakBandage = new Bandage(20, "Weak Bandage");
        public Bandage mediumBandage = new Bandage(40, "Medium Bandage");
    }

    public class MeleeWeapon {
        private int damage;
        private String name;

        public MeleeWeapon(int damage, String name) {
            this.damage = damage;
            this.name = name;
        }

        public MeleeWeapon dagger = new MeleeWeapon(10, "Dagger");
        public MeleeWeapon club = new MeleeWeapon(20, "Club");
    }
}
