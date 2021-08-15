/**
 * @(#)Football.java
 *
 * This Football class will receive 3 football matches. The first number representing the goals scored by the university and the second representing the goals scored by the rival team.
 * The program will calculate the final score of the universty as well as the number of times the university won and the number of times it tie scored.
 *
 * @author Emmanuel Fhal, ID:XXXXXXX
 * @version 1.00 2019a (09/11/2018)
 */

import java.util.Scanner;
public class Football
{
    public static void main (String [] args)
    {
        final int r1_1,r1_2,r2_1,r2_2,r3_1,r3_2;
        int result = 0,won = 0,tie = 0;
       
        Scanner scan = new Scanner (System.in); 
        System.out.println ("Please enter results of the last 3 games:"); 
        
        System.out.println ("Please enter the result of the first game of the universty vs rival:");
        r1_1 = scan.nextInt(); //value = 1
        r1_2 = scan.nextInt(); //value = 1
                
        System.out.println ("Please enter the result of the second game of the universty vs rival:");
        r2_1 = scan.nextInt(); //value = 1
        r2_2 = scan.nextInt(); //value = 2
        
        System.out.println ("Please enter the result of the third game of the universty vs rival:");
        r3_1 = scan.nextInt(); //value = 5
        r3_2 = scan.nextInt(); //value = 1
        
        //Here is considered the first football game. If the university football team wins, it will receive 3 points 
        //and if it does not receive 4 points. If the game ends in the university file you will receive only 2 points
        if (r1_1>r1_2) {
        result+=3;
        won++;
        }
        else if (r1_1<r1_2) {
        result-=4;      
        }
        else {
        result+=2;
        tie++;
        }

        //Here is considered the second football game. If the university football team wins, it will receive 3 points 
        //and if it does not receive 4 points. If the game ends in the university file you will receive only 2 points
        if (r2_1>r2_2) {
        result+=3;
        won++;
        }
        else if (r2_1<r2_2) {
        result-=4;      
        }
        else {
        result+=2;
        tie++;
        }

        //Here is considered the third and the last football game. If the university football team wins, it will receive 3 points plus multiply each gall by 2 
        //and if it does not receive 4 points. If the game ends in the university file you will receive only 2 points
        if (r3_1>r3_2) {
        result+=3;
        result+=2*r3_1;
        won++;
        }
        else if (r3_1<r3_2) {
        result-=4;      
        }
        else {
        result+=2;
        tie++;
        }

        //You can get a bonus points if at least one condition is met. The first if the university won the last game and the gate difference is greater than 3.
        //An additional condition if the universty won in the first two games and the difference is greater than 2 in both games. And the final condition is that in the 
        //three game was tie score.
        if((r3_1>r3_2 && r3_1-r3_2>3) || ((r2_1>r2_2 && r2_1-r2_2>2)
        && (r1_1>r1_2 && r1_1-r1_2>2)) || (tie == 3)){
        result+=5;      
        }

        //The user will receive 3 different outputs when the first is the number of victories of the university. The second output is the number of times the
        //game ends in a draw. And the final output is the final score of the university.
        System.out.println("Number of games which the university team won "+won);
        System.out.println("Number of games with tie result "+tie);
        System.out.println("Final score of the university team "+result);

    } // end of method main
} //end of class Football
