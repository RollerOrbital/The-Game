package rob;

import java.util.Scanner;

public class Board {
    static Scanner input = new Scanner(System.in);

    private static void displayBoard(String[][] board) {
        for (String[] row : board) {
            for (int column = 0; column < row.length; column++) {
                System.out.print(row[column]);
                System.out.print("\t");
                if (column == row.length - 1) {
                    System.out.println();
                }
            }
        }
    }

    private static void setAll(String[][] board, String s) {
        for (int rowNumber = 0; rowNumber < board.length; rowNumber++) {
            String[] row = board[rowNumber];
            for (int columnNumber = 0; columnNumber < row.length; columnNumber++) {
                board[columnNumber][rowNumber] = s;
            }
        }
    }

    public static void move(String[][] board, int x, int y, PlayerAtt player) {
        setBoard();
        directionPlayer(board, 2, 1, player);
    }

    private static void setBoard() {
        String[][] board = new String[5][5];
        Board.setAll(board, "O");
        board[2][1] = "P";
        board[2][3] = "E";
        Board.displayBoard(board);
        System.out.println();
        System.out.println();
    }

    private static void directionPlayer(String[][] board, int x, int y, PlayerAtt player) {
        System.out.println("Right");
        System.out.println("Left");
        System.out.println("Down");
        System.out.println("Up");
        int choice = input.nextInt();
        if (choice == 1) {
            board[x][y] = "O";
            board[x][y + howFar(player)] = "P";
            Board.displayBoard(board);
        } else if (choice == 2) {
            board[x][y] = "O";
            board[x][y - howFar(player)] = "P";
            Board.displayBoard(board);
        } else if (choice == 3) {
            board[x][y] = "O";
            board[x + howFar(player)][y] = "P";
            Board.displayBoard(board);
        } else if (choice == 4) {
            board[x][y] = "O";
            board[x - howFar(player)][y] = "P";
            Board.displayBoard(board);
        }
    }

    private static int howFar(PlayerAtt player) {
        System.out.println("How far in that direction would you like to go?");
        int choice = input.nextInt();
        if (choice > player.pace) {
            choice = 1;
        }
        return (choice);
    }
}
