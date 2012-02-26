package will.Learning;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("What is your name? \n");
        String name = scanner.next();

        System.out.println("And how old are you? \n");
        int age = scanner.nextInt();

        System.out.println("Your name is " + name + ", and you are " + age + "years old and you are ");

        if (age <= 50) {
            System.out.print("You are still young!");
        }
        if (age >= 50) {
            System.out.print("You are getting on a bit...");
        }
    }
}