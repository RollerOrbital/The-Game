package robD;

import java.util.Random;

public class Turn {
    public Turn(boolean alive, int power, int[]position, int[] effects ) {
        DescribePlaceX(position);
        DescribePlaceY(position);
        DescribeEffects(effects, alive);


    }

    private void DescribeEffects(int[] effects, boolean alive) {
        int burn = effects[1];
        int poison = effects[2];
        int confused = effects[3];
        int invulnerable = effects[4];
        CheckBurn(getBurn(burn),alive);
        CheckPoison(getPoison(poison),alive);
    }
        private int getBurn(int burn){
        return burn;
    }
        private void CheckBurn(int burn, boolean alive){
            switch (burn){
                case 0:
                    break;
                case 1:
                    System.out.println("You are on fire and will die in 10 turns");
                    ++burn;
                case 2:
                    System.out.println("You are on fire and will die in 9 turns");
                    ++burn;
                case 3:
                    System.out.println("You are on fire and will die in 8 turns");
                    ++burn;
                case 4:
                    System.out.println("You are on fire and will die in 7 turns");
                    ++burn;
                case 5:
                    System.out.println("You are on fire and will die in 6 turns");
                    ++burn;
                case 6:
                    System.out.println("You are on fire and will die in 5 turns");
                    ++burn;
                case 7:
                    System.out.println("You are on fire and will die in 4 turns");
                    ++burn;
                case 8:
                    System.out.println("You are on fire and will die in 3 turns");
                    ++burn;
                case 9:
                    System.out.println("You are on fire and will die in 2 turns");
                    ++burn;
                case 10:
                    System.out.println("You are on fire and will die next turn");
                    ++burn;
                case 11:
                    System.out.println("All that remains of you is a pile of ashes");
                    alive = false;


            }

        }


    private void DescribePlaceX(int position []) {
        int x = position [1];
        if (x == 0){
            System.out.println("There is a wall to your North");
        }else if (x == 16){
            System.out.println("There is a wall to your South");
        }
            
        }

   private void DescribePlaceY(int position []){
       int y = position[2];
        if (y == 0){
            System.out.println("There is a wall to your West");
        }else if (y == 16){
            System.out.println("There is a wall to your East");

        }
   }


   private int getPoison(int poison){
        return poison;
    }
   private void CheckPoison(int poison, boolean alive){
        switch (poison){
            case 0:
                break;
            case 1:
                System.out.println("You have been poisoned and will die in 5 turns");
                ++poison;
            case 2:
                System.out.println("You have been poisoned and will die in 4 turns");
                ++poison;
            case 3:
                System.out.println("You have been poisoned and will die in 3 turns");
                ++poison;
            case 4:
                System.out.println("You have been poisoned and will die in 2 turns");
                ++poison;
            case 5:
                System.out.println("You have been poisoned and will die next turn");
                ++poison;
            case 6:
                System.out.println("You intestines have melted into a slushy goo");
                alive = false;


        }

    }
        
    

    

}

