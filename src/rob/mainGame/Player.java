package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    String playerImage = "playr.png";
    ImageIcon ii = new ImageIcon(this.getClass().getResource(playerImage));
    Image image = ii.getImage();
    static String name;
    MeleeWeapon Mweapon;
    RangeWeapon Rweapon;

    int scope, aegis, pace, twitch, cognition, vigor, exp, hp, basehp, mp, basemp, levelUpxp, sp, y, x;

    static int fortune, level;

    static {
        fortune = 10;
        level = 1;
    }

    public Player(MeleeWeapon Mweapon, RangeWeapon Rweapon, int scope, int aegis, int pace, int twitch, int cognition, int vigor, int exp, int hp, int basehp, int mp, int basemp, int levelUpxp, int sp, int y, int x) {
        this.Mweapon = Mweapon;
        this.Rweapon = Rweapon;
        Player.name = "Rob";
        this.scope = scope;
        this.aegis = aegis;
        this.pace = pace;
        this.twitch = twitch;
        this.cognition = cognition;
        this.vigor = vigor;
        this.exp = exp;
        this.hp = hp;
        this.basehp = basehp;
        this.mp = mp;
        this.basemp = basemp;
        this.levelUpxp = levelUpxp;
        this.sp = sp;
        this.y = y;
        this.x = x;
    }

    static Player player = new Player(MeleeWeapon.fists, RangeWeapon.bb_gun, 2, 5, 5, 10, 30, 15, 0, 100, 100, 50, 50, (level * level) + 40, 0, 0, 0);

    public static MeleeWeapon MweaponInventory[] = {MeleeWeapon.fists, MeleeWeapon.police_baton};
    public static RangeWeapon RweaponInventory[] = {RangeWeapon.bb_gun, RangeWeapon.revolver};
    public static HealingItem HIInventory[] = {HealingItem.bandages, HealingItem.potion};
    public static DamageMagic DMInventory[] = {DamageMagic.fireball, DamageMagic.thunder_bolt};
    public static HealingMagic HMInventory[] = {HealingMagic.basic_heal, HealingMagic.recover};

    public void move() {
        if (y > 425) {
            y = 425;
        }
        if (x < 10) {
            x = 10;
        } else if (y < 10) {
            y = 10;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_LEFT:
                x -= 10;
                break;
            case KeyEvent.VK_RIGHT:
                x += 10;
                break;
            case KeyEvent.VK_UP:
                y -= 10;
                break;
            case KeyEvent.VK_DOWN:
                y += 10;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_LEFT:
                x = 0;
                break;
            case KeyEvent.VK_RIGHT:
                x = 0;
                break;
            case KeyEvent.VK_UP:
                y = 0;
                break;
            case KeyEvent.VK_DOWN:
                y = 0;
                break;
        }
    }
}
