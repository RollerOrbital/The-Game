package robD;

/**
 * Created by IntelliJ IDEA.
 * User: Rob
 * Date: 21/03/12
 * Time: 19:57
 * To change this template use File | Settings | File Templates.
 */
public class Turn {
    public Turn(String PlayerName,boolean alive,int power,int x,int y,int z) {
        DescribePlacex(x,y);

    }

   private void DescribePlacex(int x, int y) {
        if (x == 0){
            System.out.println("There is a wall to your North");
        }else if (x == 16){
            System.out.println("There is a wall to your South");
    }


    }
}

