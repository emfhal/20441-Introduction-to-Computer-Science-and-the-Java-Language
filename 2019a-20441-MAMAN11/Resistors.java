/**
 * @(#)Resistors.java
 *
 * This Resistors class will gets 3 integers number that represent the resistance of each of the resistors
 * and then calculates the overall resistance and print the result.
 *
 * @author Emmanuel Fhal, ID:XXXXXXX
 * @version 1.00 2019a (09/11/2018)
 */

//Import Scanner class for user-input purposes
import java.util.Scanner;
public class Resistors
{
    public static void main (String [] args)
    {
        //Creating an instance of Scanner and getting input from the user
        Scanner scan = new Scanner (System.in);
        System.out.println ("Please enter 3 integers:");
        System.out.println ("Please enter r1:");
        int r1 = scan.nextInt();
        System.out.println ("Please enter r2:");
        int r2 = scan.nextInt();
        System.out.println ("Please enter r3:");
        int r3 = scan.nextInt();
        
        //Calculate the total resistance by 1 divided the total of 1 divided the input numbers.
        //In addition, we have to divide the int numbers, we need to use double and divide by 1.0 instead of 1.
        double total_r = 1.0/((1.0/r1) + (1.0/r2) + (1.0/r3));

        System.out.println("The total resistance of resistors "+r1+", "+r2+", and "+r3+" connected in parallel is: "+total_r);

    } // end of method main
} //end of class Resistors
