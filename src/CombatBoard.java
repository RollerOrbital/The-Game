public class CombatBoard {
    static int board[][] = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};{
    }

    public static void boardDisplay() {
        System.out.println("\t1\t2\t3\t4\t5\t6\t7\t8\t9");
        System.out.println("");
        for (int x = 0; x < 10; x++) {
            for (int i = 0; i < 10; i++) {
                if (i == 0) {
                    System.out.print(x + 1 + "\tx" + "\t");
                } else {
                    if (i < 9) {
                        System.out.print("x" + "\t");
                    } else {
                        System.out.println("");
                    }
                }
            }
        }
    }

}