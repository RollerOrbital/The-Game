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

    public static void setAll(String[][] board, String s) {
        for (int rowNumber = 0; rowNumber < board.length; rowNumber++) {
            String[] row = board[rowNumber];
            for (int columnNumber = 0; columnNumber < row.length; columnNumber++) {
                board[columnNumber][rowNumber] = s;
            }
        }
    }

    public static void setBoard(int x, int y) {
        String[][] board = new String[5][5];
        Board.setAll(board, "O");
        board[x][y] = "P";
        board[2][3] = "E";
        Board.displayBoard(board);
        System.out.println();
        System.out.println();
    }

    public static void stepsRequired(int currentX, int currentY, PlayerAtt player, String[][] board) {
        System.out.println("What is the currentX co-ordinate of the position you want to go to?");
        int yco = input.nextInt() - 1;
        System.out.println("What is the currentY co-ordinate of the position you want to go to?");
        int xco = input.nextInt() - 1;
        int stepsRequired = Math.abs(xco - currentX) + Math.abs(yco - currentY);
        if (stepsRequired <= player.pace && board[xco][yco] != "E")
            try {
                setBoard(xco, yco);
            } catch (Exception e) {
            }
        else {
            System.out.println("You can't do that -_-");
            setBoard(currentX, currentY);
        }
    }
}
