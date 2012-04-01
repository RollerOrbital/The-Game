package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

public class Player {
    public int x;
    public int y;

    private static enum FacingDirection {
        UP(2, KeyEvent.VK_UP, 0, -1),
        RIGHT(3, KeyEvent.VK_RIGHT, 1, 0),
        LEFT(1, KeyEvent.VK_LEFT, -1, 0),
        DOWN(0, KeyEvent.VK_DOWN, 0, 1);

        public final int frameRow;
        public final int dx;
        public final int dy;
        private final int key;

        FacingDirection(int frameRow, int key, int dx, int dy) {
            this.frameRow = frameRow;
            this.key = key;
            this.dx = dx;
            this.dy = dy;
        }

        public static FacingDirection forKey(int key) {
            FacingDirection[] values = values();
            for (FacingDirection direction : values) {
                if (direction.key == key) {
                    return direction;
                }
            }
            return null;
        }
    }

    private FacingDirection direction;
    private int dx, dy;
    private final int MOVING, STILL, TALKING;
    private int stateOfBeing, stepCount;

    private final Image image;
    private int frameNumber;

    public static boolean isMenuOpen;
    private final StartMenu startMenu;
    public String menuAction;
    public int cursorPosition;
    public boolean selectedMenuIcon;

    public Player() {
        startMenu = new StartMenu();
        isMenuOpen = false;
        x = 0;
        y = 0;
        dx = 0;
        dy = 0;
        direction = FacingDirection.DOWN;
        ImageIcon playerSheet = new ImageIcon(getClass().getResource("player.png"));
        image = playerSheet.getImage();
        frameNumber = 0;
        TALKING = 3;
        MOVING = 1;
        STILL = 0;
        cursorPosition = 2;
    }

    public int getCursorPosition() {
        if (cursorPosition < 1) {
            cursorPosition = 6;
        }
        return cursorPosition % 6;
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

    public int getWidth() {
        return 12;
    }

    public int getHeight() {
        return 18;
    }

    private int getFrame() {
        return frameNumber * getWidth();
    }

    public int getDirection() {
        return direction.frameRow * getHeight();
    }

    private void getFrameNumber() {
        if (stateOfBeing == MOVING) {
            stepCount++;
            int stepSpeed = 60;
            if (stepCount % stepSpeed < stepSpeed / 4) {
                frameNumber = 0;
            } else if (stepCount % stepSpeed >= stepSpeed / 4 && stepCount % stepSpeed < stepSpeed / 2) {
                frameNumber = 1;
            } else if (stepCount % stepSpeed >= stepSpeed / 2 && stepCount % stepSpeed < (stepSpeed * 3) / 4) {
                frameNumber = 0;
            } else if (stepCount % stepSpeed >= (stepSpeed * 3) / 4 && stepCount % stepSpeed <= stepSpeed) {
                frameNumber = 2;
            }
        } else if (stateOfBeing == STILL) {
            frameNumber = 0;
        }
    }

    private void getBounds() {
        if (x < -198) {
            x = -198;
        }
        if (x > 376) {
            x = 376;
        }
        if (y < -155) {
            y = -155;
        }
        if (y > 160) {
            y = 160;
        }
    }

    public void move() {
        if (isMenuOpen) {
            dx = 0;
            dy = 0;
        } else {
            cursorPosition = 0;
            x += dx;
            y += dy;
            getFrameNumber();
            getBounds();
        }
    }

    private void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        FacingDirection facingDirection = FacingDirection.forKey(key);
        if (facingDirection != null && !isMenuOpen) {
            direction = facingDirection;
            dx = facingDirection.dx;
            dy = facingDirection.dy;
            stateOfBeing = MOVING;
        } else if (key == KeyEvent.VK_ENTER) {
            if (isMenuOpen) {
                isMenuOpen = false;
            } else {
                isMenuOpen = true;
                stateOfBeing = STILL;
                frameNumber = 0;
            }
        } else if (key == KeyEvent.VK_X) {
            if (isMenuOpen) {
                isMenuOpen = false;
            }
        }
        if (key == KeyEvent.VK_Z) {
            Idroid.speechCounter++;
        }
        if (isMenuOpen) {
            if (key == KeyEvent.VK_Z) {
                if (!selectedMenuIcon) {
                    selectedMenuIcon = true;
                    menuAction = startMenu.getMenuAction(cursorPosition);
                } else {
                    selectedMenuIcon = false;
                }
            } else if (key == KeyEvent.VK_UP) {
                cursorPosition--;
                selectedMenuIcon = false;
            } else if (key == KeyEvent.VK_DOWN) {
                cursorPosition++;
                selectedMenuIcon = false;
            }
        }
    }

    private void keyReleased(KeyEvent e) {
        int key = (e.getKeyCode());
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_RIGHT) {
            dy = 0;
            dx = 0;
            stateOfBeing = STILL;
        }
    }

    public void drawPlayer(Graphics g, ImageObserver imageObserver) {
        g.drawImage(getImage(), 200, 150, 200 + getWidth() * 2, 150 + getHeight() * 2, getFrame(), getDirection(), getFrame() + getWidth(), getDirection() + getHeight(), imageObserver);
    }

    public KeyAdapter keyListener() {
        return new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                Player.this.keyPressed(e);
            }

            public void keyReleased(KeyEvent e) {
                Player.this.keyReleased(e);
            }
        };
    }
}