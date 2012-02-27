package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameBoard extends JPanel implements ActionListener {

    private Player player;

    public GameBoard() {
        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        Timer timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        player.move();
        repaint();
    }

    private class adapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }
    }
}


/*
static Scanner input = new Scanner(System.in);
static Random randomNum = new Random();

private int xBoardMax = 5;
private int yBoardMax = 5;

public void playerMove(Player player, Enemy enemy) {
System.out.println("What is the xco of where you want to go?");
int xco = input.nextInt();
System.out.println("What is the yco of where you want to go?");
int yco = input.nextInt();

int stepsRequired = Math.abs(yco - player.y) + Math.abs(xco - 1 - player.x);

if (yco - 1 < xBoardMax && xco - 1 < yBoardMax) {
if (stepsRequired <= player.pace) {
if (xco - 1 != enemy.x || yco - 1 != enemy.y) {
System.out.println();
player.y = yco - 1;
player.x = xco - 1;
System.out.println("You are now at position (" + xco + "," + yco + ")");
} else {
System.out.println();
System.out.println("On top of enemy -__-");
System.out.println("You are now at position (" + player.x + "," + player.y + ")");
}
} else {
System.out.println();
System.out.println("You don't have a high enough pace skill -__-");
System.out.println("You are now at position (" + player.x + "," + player.y + ")");
}
} else {
System.out.println("Out of range -__-");
System.out.println("You are now at position (" + player.x + "," + player.y + ")");
}
}

public void displayBoard(Player player, Enemy enemy) {
for (int x = 0; x < xBoardMax; x++) {
for (int i = 0; i < yBoardMax; i++) {
if (x < xBoardMax) {
if (x == player.y && i == player.x) {
System.out.print("P\t");
i++;
}
if (x == enemy.y && i == enemy.x) {
System.out.print("E\t");
i++;
}
if (i != 5) {
System.out.print(".\t");
}
if (i >= 4) {
System.out.println();
}
}
}
}
}

public void enemyAIMove(Player player, Enemy enemy) {
int stepsRequiredRight = Math.abs(player.y + 1 - enemy.y) + Math.abs(player.x - enemy.x);
int stepsRequiredLeft = Math.abs(player.y - 1 - enemy.y) + Math.abs(player.x - enemy.x);
int stepsRequiredDown = Math.abs(player.y - enemy.y) + Math.abs(player.x + 1 - enemy.x);
int stepsRequiredUp = Math.abs(player.y - enemy.y) + Math.abs(player.x - 1 - enemy.x);

int stepsRequiredx = player.y - enemy.y;
int stepsRequiredy = player.x - enemy.x;

if (canGoNextToPlayer(Player.player, Enemy.enemyYouFight)) {
if (stepsRequiredRight <= enemy.pace) {
enemy.y = player.y + 1;
enemy.x = player.x;
} else if (stepsRequiredLeft <= enemy.pace) {
enemy.y = player.y - 1;
enemy.x = player.x;
} else if (stepsRequiredDown <= enemy.pace) {
enemy.y = player.y;
enemy.x = player.x + 1;
} else if (stepsRequiredUp <= enemy.pace) {
enemy.y = player.y;
enemy.x = player.x - 1;
} else {
goRandomPlace(enemy);
}
} else if (canGoInLineWithPlayer(player, enemy)) {
if (stepsRequiredx <= enemy.pace) {
enemy.y = player.x;
} else if (stepsRequiredy <= enemy.pace) {
enemy.x = player.x;
}
} else {
goRandomPlace(enemy);
}
}

public static boolean areNextToEachOther(Player player, Enemy enemy) {
return player.y == enemy.y && Math.abs(player.x - enemy.x) == 1 || (player.x == enemy.x && Math.abs(enemy.y - player.y) == 1);
}

private static boolean canGoNextToPlayer(Player player, Enemy enemy) {
int stepsRequiredRight = Math.abs(player.y + 1 - enemy.y) + Math.abs(player.x - enemy.x);
int stepsRequiredLeft = Math.abs(player.y - 1 - enemy.y) + Math.abs(player.x - enemy.x);
int stepsRequiredDown = Math.abs(player.y - enemy.y) + Math.abs(player.x + 1 - enemy.x);
int stepsRequiredUp = Math.abs(player.y - enemy.y) + Math.abs(player.x - 1 - enemy.x);

return stepsRequiredRight <= enemy.pace || stepsRequiredLeft <= enemy.pace || stepsRequiredDown <= enemy.pace || stepsRequiredUp <= enemy.pace;
}

private void goRandomPlace(Enemy enemy) {
enemy.y = randomNum.nextInt(enemy.pace - 1) % xBoardMax;
enemy.x = randomNum.nextInt(enemy.pace - 1) % yBoardMax;
}

private static boolean canGoInLineWithPlayer(Player player, Enemy enemy) {
int stepsRequiredx = player.y - enemy.y;
int stepsRequiredy = player.x - enemy.x;

return stepsRequiredx <= enemy.pace || stepsRequiredy <= enemy.pace;
}
*/
