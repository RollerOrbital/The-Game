package rob;

import java.util.Scanner;

public class PlayerAtt {

    private String name() {
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = input.nextLine();
        return (name);
    }

    MeleeWeapon Mweapon;
    RangeWeapon Rweapon;
    static String name;
    int scope, aegis, pace, twitch, cognition, vigor, xp, hp, basehp, mp, basemp, levelUpxp, sp;
    static int fortune, level;static {
        fortune = 10;
        level = 1;
    }

    public PlayerAtt(MeleeWeapon Mweapon, RangeWeapon Rweapon, int scope, int aegis, int pace, int twitch, int cognition, int vigor, int xp, int hp, int basehp, int mp, int basemp, int levelUpxp, int sp) {
        this.Mweapon = Mweapon;
        this.Rweapon = Rweapon;
        PlayerAtt.name = name();
        this.scope = scope;
        this.aegis = aegis;
        this.pace = pace;
        this.twitch = twitch;
        this.cognition = cognition;
        this.vigor = vigor;
        this.xp = xp;
        this.hp = hp;
        this.basehp = basehp;
        this.mp = mp;
        this.basemp = basemp;
        this.levelUpxp = levelUpxp;
        this.sp = sp;
    }

    static PlayerAtt player = new PlayerAtt(MeleeWeapon.fists, RangeWeapon.bb_gun, 2, 5, 5, 10, 30, 15, 0, 100, 100, 50, 50, (level * level) + 40, 0);

    public static MeleeWeapon MweaponInventory[] = {MeleeWeapon.fists, MeleeWeapon.police_baton};
    public static RangeWeapon RweaponInventory[] = {RangeWeapon.bb_gun, RangeWeapon.revolver};
    public static HealingItem HIInventory[] = {HealingItem.bandages, HealingItem.potion};
    public static DamageMagic DMInventory[] = {DamageMagic.fireball, DamageMagic.thunder_bolt};
    public static HealingMagic HMInventory[] = {HealingMagic.basic_heal, HealingMagic.recover};
}
