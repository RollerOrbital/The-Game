package rob.mainGame;

import javax.swing.*;
import java.awt.*;

public class Enemy {

    public int dx;
    private int dy;
    public int x;
    private int y;
    private int movex;
    private int movey;
    private int width;
    private int height;
    private ImageIcon i;
    private Image image;
    private int sprframe;
    private int sprdir;
    private int[] AnimationFrame;
    private int AnimationCounter;
    private int AnimationSpeed;

    //battle stats:
    private int vigor, pace, fortune, agility, aegis, baseYield;
    private int hp, basehp, mp, basemp;

    public Enemy(int dx, int dy, int x, int y, int movex, int movey, int width, int height, ImageIcon i, Image image, int sprframe, int sprdir, int[] AnimationFrame, int AnimationCounter, int AnimationSpeed, int vigor, int pace, int fortune, int agility, int aegis, int baseYield, int hp, int basehp, int mp, int basemp) {
        this.dx = dx;
        this.dy = dy;
        this.x = x;
        this.y = y;
        this.movex = movex;
        this.movey = movey;
        this.width = width;
        this.height = height;
        this.i = i;
        this.image = image;
        this.sprframe = sprframe;
        this.sprdir = sprdir;
        this.AnimationFrame = AnimationFrame;
        this.AnimationCounter = AnimationCounter;
        this.AnimationSpeed = AnimationSpeed;
        this.vigor = vigor;
        this.pace = pace;
        this.fortune = fortune;
        this.agility = agility;
        this.aegis = aegis;
        this.baseYield = baseYield;
        this.hp = hp;
        this.basehp = basehp;
        this.mp = mp;
        this.basemp = basemp;
    }

}
