package rob.mazeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    private int fouls = 0;
    private String player = "PLAYER.png";
    private int dx;
    private int dy;
    private int x;
    private int y;
    private int width;
    private int height;
    private Image image;

    public Player() {
        ImageIcon i = new ImageIcon(this.getClass().getResource(player));
        image = i.getImage();
        x = 40;
        y = 40;
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public void move() {
        x += dx;
        y += dy;
        if (y > 425) {
            y = 425;
            fouls++;
        }
        if (x < 0) {
            x = 0;
            fouls++;
        } else if (y < 0) {
            y = 0;
            fouls++;

            //Horizontal Lines
        } else if ((x >= -10 && x < 100) && (y <= 90 && y >= 80)) {
            if (y > 85) {
                y = 90;
            } else if (y < 85) {
                y = 80;
            }
            fouls++;
        } else if ((x >= -10 && x < 100) && (y <= 270 && y >= 260)) {
            if (y > 265) {
                y = 270;
            } else if (y < 265) {
                y = 260;
            }
            fouls++;
        } else if ((x >= 90 && x < 320) && (y <= 195 && y >= 185)) {
            if (y > 190) {
                y = 195;
            } else if (y < 190) {
                y = 185;
            }
            fouls++;
        } else if ((x >= 150 && x < 370) && (y <= 50 && y >= 40)) {
            if (y > 45) {
                y = 50;
            } else if (y < 45) {
                y = 40;
            }
            fouls++;
        } else if ((x >= 150 && x < 370) && (y <= 130 && y >= 120)) {
            if (y > 125) {
                y = 130;
            } else if (y < 135) {
                y = 120;
            }
            fouls++;
        } else if ((x >= -10 && x < 100) && (y <= 100 && y >= 90)) {
            if (y > 95) {
                y = 100;
            } else if (y < 95) {
                y = 90;
            }
            fouls++;
        } else if (x > 725) {
            x = 725;
            fouls++;
        } else if ((x >= 150 && x < 465) && (y <= 300 && y >= 290)) {
            if (y > 295) {
                y = 300;
            } else if (y < 295) {
                y = 290;
            }
            fouls++;
        } else if ((x >= 380 && x < 465) && (y <= 230 && y >= 220)) {
            if (y > 225) {
                y = 230;
            } else if (y < 225) {
                y = 220;
            }
            fouls++;
        } else if ((x >= 465 && x < 650) && (y <= 140 && y >= 130)) {
            if (y > 135) {
                y = 140;
            } else if (y < 135) {
                y = 130;
            }
            fouls++;
        } else if ((x >= 500 && x < 690) && (y <= 200 && y >= 190)) {
            if (y > 195) {
                y = 200;
            } else if (y < 195) {
                y = 190;
            }
            fouls++;
        } else if ((x >= -50 && x < 750) && (y <= 0)) {
            y = 0;
            fouls++;
        } else if ((x >= -50 && x < 750) && (y >= 350)) {
            y = 350;
            fouls++;
        }
        //vertical lines
        else if ((y >= 40 && y < 140) && (x <= 150 && x >= 140)) {
            if (x > 145) {
                x = 150;
            } else if (x < 145) {
                x = 140;
            }
            fouls++;
        } else if ((y >= -50 && y < 800) && (x >= 700)) {
            x = 700;
            fouls++;
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

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}//