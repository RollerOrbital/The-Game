package robD;


public class Choices {
    private int PlayerPower;

    public Choices(int choiceNumber, int choice) {
        switch (choiceNumber) {
            case 1:
                switch (choice) {
                    case 1:
                        PlayerPower = 1;
                        break;
                    case 2:
                        PlayerPower = 2;
                        break;
                    case 3:
                        PlayerPower = 3;
                        break;
                    case 4:
                        PlayerPower = 4;
                        break;
                    case 5:
                        PlayerPower = 5;
                        break;
                    default:
                        PlayerPower = 6;
                }
            case 2:

            default:

        }
    }


    public int getChoice1() {
        return PlayerPower;
    }

    public Choices(String help) {
        if (help.equals("y")) {
            System.out.println("Here is a list of basic commands, you may discover other commands by trying things out");
            System.out.println("kick - kicks");
            System.out.println("punch - punch");
            System.out.println("eat - eat");
            System.out.println("move (insert direction n/s/w/e) - moves in that direction");
            System.out.println("power - uses one charge of your power");
            System.out.println("anally insert - ... you get the idea");
        } else if (help.equals("n")) {
            System.out.println("Are you sure y/n");
        }
    }

    public boolean checkHelp(String help2) {
        if (help2.equals("y")) {
            boolean alive = true;
            return alive;
        } else if (help2.equals("n")) {
            System.out.println("You are killed for being indecisive ");
            boolean alive = false;
            return alive;
        } else {
            System.out.println("Invalid Choice");
            System.out.println("Enter your choice again");
            checkHelp(help2);
            boolean alive = true;
            return alive;

        }


    }
}

