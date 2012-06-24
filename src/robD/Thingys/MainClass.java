package robD.Thingys;

import java.lang.Math;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Rob
 * Date: 24/06/12
 * Time: 13:34
 * To change this template use File | Settings | File Templates.
 */
public class MainClass {
    public static void main(String[] args) {
        double sum = 0; //sum of all values
        double value; //when you /6 and root sum = value
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter number of times to carry out function");
        double y = keyboard.nextInt(); //y = number of times(accuracy)
        for(double x=1; x<=y; x++){
            sum = sum +(1/(Math.pow(x,2)));
        }
    value = Math.sqrt(sum*6);// because function gives pi^2/6
    double accuracy = (value/Math.PI)*100;//might replace this with something to find how many dp it's accurate to.
    System.out.print(accuracy +"%");


    }
}
