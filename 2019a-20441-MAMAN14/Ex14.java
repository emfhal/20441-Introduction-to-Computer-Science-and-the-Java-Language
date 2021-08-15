/**
 * @(#)Ex14.java
 *
 * Represents information about Maman14 question 1-4 2019a
 *
 * @author Emmanuel Fhal, ID:XXXXXXX
 * @version 1.00 2019a (10/01/2019)
 */

public class Ex14 {

 /**
   * public static void win(int[] arr)
   * A coin game between two players who have alternating turns. For each turn the player collects the value of his chosen coin (this can be the coin at either end of the row). Player 1 can never lose but can either win or finish with a draw. Player 2 will alwyas choose the coin with the highest value from either end of the row. 
   * The complexity of the running time and the place is O(n) - These O(1) operations are performed at most "some constant" times in two O(n) loops, making the entire computation O(n) in time. 
   * 
   * @param arr  The coin value line of the game.
   *
   * @return in order what each player chooses. When the game is over, the amounts of all the coins they collect will be returned.
   */
  
 public static void win(int[] arr) {
  int n = arr.length;
  int even = 0, odd = 0;

  for (int gap = 0; gap < n; ++gap) {
   even += (gap % 2 == 0) ? arr[gap] : 0;
   odd += (gap % 2 != 0) ? arr[gap] : 0;
  }

  int i = 0,j = n - 1;
  for (int gap = 0; gap < n; ++gap) {
   if (j > i) {
    if (j % 2 == 0 && even >= odd) {
     System.out.println("Amir took " + arr[j]);
     j--;
    } else {
     System.out.println("Amir took " + arr[i]);
     i++;
    }
    if (arr[j] > arr[i]) {
     System.out.println("Tamar took " + arr[j]);
     j--;
    } else {
     System.out.println("Tamar took " + arr[i]);
     i++;
    }
   }
  }

   System.out.println("Final Score:");
  if (even >= odd) {System.out.println("Amir total " + even);System.out.println("Tamar total " + odd);
  } else {System.out.println("Amir total " + odd);System.out.println("Tamar total " + even);}
  
 }

 /**
   * public static boolean what(int[]a, int num)
   * The method performs a calculation between the possible sub-array within the array where the num is equal to the sum of the possible sub-array.
   * The algorithm prints the beginning and end of the sub-array elements place to which the sum of num appears and if not print the word no (Alef answer).
   * The complexity of the running time and the place is O(n^3) - There is a loop within the loop within the loop called by the condition (Beit answer).
   * According to the method i wrote, the complexity of the running time and the place is O(n) because there is one loop up to the specific condition (Dalet answer).
   * 
   * @param a  The array whose values ​​are searched within num value.
   * @param num  A number to look for its sum within the array.
   * 
   * @return True if the sum of the number is found within the array or false if he did not.
   */
 
 public static boolean what(int[]a, int num) {
  int total = 0, left = 0, right = a.length - 1;
  
  for (int i = 0; i < a.length; i++)
   total += a[i];

  if (total < num){System.out.println("No ");return false;}
  
  while (left < right && total != num) {
   if (total - (a[right] + a[left]) == num || total - a[right] == num || total - a[left] == num){
    System.out.println("between " +left+ " and "+right);return true;}
   if (total - (a[right] + a[left]) > num) {
    total -= (a[right] + a[left]);
    left++;
    right--;
   } else if (total - a[right] > num) {
    total -= a[right];
    right--;
   } else if (total - a[left] > num) {
    total -= a[left];
    left++;
   } else
    System.out.println("No ");return false;
  }
  
  if (total == num){ System.out.println("between " +left+ " and "+right);return true;}else{System.out.println("No ");return false;}
 }
 
 
 /**
   * public static int longestSlope(int[][] mat, int num)
   * The method getting a two-dimensional array of integers and a num. If we receive num = 2 we will look for all the values ​​in the cells whose difference is 2.
   * When you can move and check the difference only to the right, left, up and down (not allowed move in diagonals). The method returns the maximum length of the longest option.
   * 
   * @param mat  The two-dimensional array in which values are searched.
   * @param num  The number of the difference between the elements in the two-dimensional array.
   * 
   */
  
  public static int longestSlope(int[][] mat, int num) {
  return longestSlope(mat, 0, 0, num);
 }
 
 private static int longestSlope(int[][] mat, int row, int col, int num) {
  int nextRow = row;
  int nextCol = col + 1;
  if (col == mat[0].length - 1) {
   nextCol = 0;
   nextRow = row + 1;
  }

  if (row == mat.length - 1)
   return 0;

  return Math.max(numSlope(mat, row, col, num), longestSlope(mat, nextRow, nextCol, num));

 }

 private static int numSlope(int[][] mat, int row, int col, int num) {
  int max = 1;

  if ((row + 1) < mat.length && mat[(row + 1)][(col + 0)] == mat[row][col] - num) //right
   max = Math.max(max, 1 + numSlope(mat, row + 1, col, num));

  if ((row - 1) >= 0 && mat[(row - 1)][(col + 0)] == mat[row][col] - num) //left
   max = Math.max(max, 1 + numSlope(mat, row - 1, col, num));

  if ((col + 1) < mat[0].length && mat[(row - 0)][(col + 1)] == mat[row][col] - num) //up
   max = Math.max(max, 1 + numSlope(mat, row, col + 1, num));

  if ((col - 1) >= 0 && mat[(row + 0)][(col - 1)] == mat[row][col] - num) //down
   max = Math.max(max, 1 + numSlope(mat, row, col - 1, num));

  return max;

 }


 /**
   * public static int howManySorted(int n, int max)
   * The method calculates and returns the number of options of n-size arrays consisting of numbers arranged in ascending order (or equal order) from 1 to max number.
   * 
   * @param n  The array of size.
   * @param max The maximum positive integer number.
   * 
   */
  
 public static int howManySorted(int n, int max) {
  if (n == 0)
   return 1;

  if (max == 0)
   return 0;

  return howManySorted(n - 1, max) + howManySorted(n, max - 1);
 }


}
