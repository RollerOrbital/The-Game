package rob.mazeGame;

import java.util.Scanner;

public class Board {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        move();
        move();
    }

    static String[][] board = new String[5][5];

    public static void displayBoard(String[][] board) {
        for (int x = 0; x < 5; x++) {
            for (int i = 0; i < 5; i++) {
                board[x][i] = "O";
                try {
                    board[Player.xpos][Player.ypos] = "P";
                } catch (Exception e) {
                    board[0][0] = "P";
                }
                board[4][4] = "F";
                System.out.print(board[x][i] + "\t");
                if (i == 4) {
                    System.out.println();
                }
            }
        }
    }

    public static void playerMoves() {
        switch (choice()) {
            case 1:
                Player.xpos++;
                break;
            case 2:
                Player.xpos--;
                break;
            case 3:
                Player.ypos++;
                break;
            case 4:
                Player.ypos--;
                break;
        }
    }

    private static int choice() {
        System.out.println("D, L, R, U?");
        return input.nextInt();
    }

    public static void move() {
        System.out.println();
        displayBoard(board);
        playerMoves();
        System.out.println();
        displayBoard(board);
    }
}
//make a board
//make it so the board is randomly generated
//make the player start at the start
//player wins if they reach the exit
//player loses if they run our of time
//make it so the boards size is based on the number of decisions the player must make
//the decisions have a random number less than 5 of turns
