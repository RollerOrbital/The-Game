package rob.mainGame;

import java.awt.*;

public class IDroid {
    //movement stats:
    public int dx;
    public int dy;
    public int x;
    public int y;
    private int movex;
    private int movey;
    private int width;
    private int height;
    private Image image;
    private int sprframe;
    private int sprdir;
    private int[] AnimationFrame;
    private int AnimationCounter;
    private int AnimationSpeed;

    public int vigor;
    public int pace;
    public int fortune;
    public int twitch;
    public int aegis;
    public int scope;
    public int cognition;

    public int hp;
    private int basehp;
    private int mp;
    private int basemp;

    public IDroid() {
        scope = 5;
        vigor = 5;
        pace = 3;
        fortune = 5;
        twitch = 15;
        aegis = 5;
        cognition = 30;

        hp = 40;
        basehp = 40;
        mp = 40;
        basemp = 40;
    }
}
