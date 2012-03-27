package rob.nonMainGames.sideGames.RadioactiveDecaySim;

import java.util.Random;

public class Decay {
    private static Random random = new Random();

    public static void getDecay(int atoms, int chance, int time) {
        int atomsRemaining = atoms;
        for (int j = 0; j < time; j++) {
            System.out.println("Atoms = " + atomsRemaining);
            //getChanceToDecay
            int[] scores = new int[atomsRemaining];
            for (int i = 0; i < scores.length; i++) {
                scores[i] = random.nextInt(chance);
            }
            //getDecay
            for (int atomScore : scores) {
                if (atomScore == 0) {
                    atomsRemaining--;
                }
            }
        }
    }
}
