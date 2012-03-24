package robD;

import java.util.Random;
public class Turn {
    public Turn(boolean alive, int power, int[]position, int[] effects ) {
        DescribePlaceX(position);
        DescribePlaceY(position);

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
}

