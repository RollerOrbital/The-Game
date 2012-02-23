package rob;

public class Board {

    public static void displayBoard(String[][] board) {
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
}
