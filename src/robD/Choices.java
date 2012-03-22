package robD;


public class Choices {
    private int PlayerPower;
    public Choices(int choiceNumber, int choice){
    switch (choiceNumber){
        case 1:
            switch (choice){
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
                    PlayerPower = 0;
            }
    }
    }


    public int getChoice1(){
        return PlayerPower;
    }
}
