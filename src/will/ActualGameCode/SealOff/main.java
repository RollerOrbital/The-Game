package will.ActualGameCode.SealOff;

import java.util.Scanner;

public class main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("You notice a seal dressed in a suit that covers his upper body waddling towards you...");
        System.out.println("'Hello there, what is your name???' \n");

        String name = scan.next();

        System.out.println("'Hello there " + name + ". I am Archibald Flipper the Third, pleased to meet you.' ");
        System.out.println("'I understand that death sent you here to, play a little game. Well I would not like to displease death, so here is a short introduction to \"Seal Off\".'");
        System.out.println("'The basic layout of the game is that you face your opponent in a one on one fight to the... FISH... oh sorry, not to the fish, to the death, I get distracted!'");
        System.out.println("You nod, slightly perturbed by the well dressed talking seal... ");
        System.out.println("Each turn you choose a fighting move to inflict on to your opponent! This is pure melee, none of your fancy magic, us seals prefer unfinned combat thank you very much!");
        System.out.println("You and your opponent each take turns to hit each other, you see, this is a gentleman's game!");
        System.out.println("So, do you understand? yes/no \n");

        String response = scan.next();

        if (response.equals("yes")) {
            battleCode fight = new battleCode();
        }

        if (response.equals("no")) {
            System.out.println("The aim of the game is to reduce your enemies hp down to 0 using your attacks");
            battleCode fight = new battleCode();
        }


    }
}
