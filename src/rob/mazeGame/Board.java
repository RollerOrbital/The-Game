package rob.mazeGame;

import java.util.Scanner;

public class Board {
    static Scanner input = new Scanner(System.in);

    static String[][] board = new String[10][10];

    public static void displayBoard(String[][] board) {
        for (int x = 0; x < 10; x++) {
            for (int i = 0; i < 10; i++) {

                board[x][i] = ".";

                board[0][1] = "W";
                board[2][0] = "W";
                board[2][1] = "W";
                board[3][1] = "W";
                board[2][3] = "W";
                board[3][3] = "W";
                board[1][3] = "W";
                board[1][4] = "W";
                board[5][3] = "W";
                board[5][2] = "W";
                board[3][4] = "W";
                board[3][5] = "W";
                board[5][1] = "W";
                board[7][0] = "W";
                board[7][1] = "W";
                board[8][1] = "W";
                board[7][3] = "W";
                board[8][3] = "W";
                board[8][4] = "W";
                board[8][5] = "W";
                board[8][6] = "W";
                board[8][8] = "W";
                board[9][8] = "W";
                board[0][7] = "W";
                board[1][7] = "W";
                board[2][7] = "W";
                board[1][6] = "W";
                board[4][7] = "W";
                board[5][7] = "W";
                board[5][5] = "W";
                board[6][5] = "W";
                board[6][6] = "W";
                board[7][8] = "W";
                board[7][9] = "W";
                board[3][9] = "W";
                board[4][9] = "W";
                board[5][8] = "W";
                board[5][9] = "W";
                board[2][9] = "W";
                board[1][9] = "W";

                if (Player.xpos == 6 && Player.ypos == 9) {
                    board[7][9] = ".";
                }

                try {
                    if (!board[Player.xpos][Player.ypos].equals("W")) {
                        board[Player.xpos][Player.ypos] = "P";
                    } else if (Player.xpos == 7 && Player.ypos == 9) {
                        board[Player.xpos][Player.ypos] = "P";
                    } else {
                        Player.xpos = 0;
                        Player.ypos = 0;
                        board[0][0] = "P";
                        Player.fouls++;
                    }
                } catch (Exception e) {
                    Player.xpos = 0;
                    Player.ypos = 0;
                    board[0][0] = "P";
                    Player.fouls++;
                }
                board[9][9] = "F";
                System.out.print(board[x][i] + "\t");
                if (i == 9) {
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
        System.out.println("###");
        String d = input.nextLine();
        if (d.equals("s")) {
            return 1;
        } else if (d.equals("w")) {
            return 2;
        } else if (d.equals("d")) {
            return 3;
        } else if (d.equals("a")) {
            return 4;
        } else {
            return 1;
        }
    }

    public static boolean isGameOver() {
        return Player.xpos == 9 && Player.ypos == 9;
    }

    public static void game() {
        int numberOfMoves = 0;
        while (!(isGameOver())) {
            displayBoard(board);
            playerMoves();
            numberOfMoves++;
        }
        int score = lowerOne(100 - numberOfMoves - Player.fouls);
        System.out.println("You Won!!!");
        input.next();
        System.out.println("Your score was " + score + "!");
    }

    private static int lowerOne(int x) {
        if (x < 1) {
            return (1);
        } else {
            return (x);
        }
    }
}