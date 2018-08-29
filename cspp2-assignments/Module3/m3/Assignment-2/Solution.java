/**
 * imported scanner.
 */
import java.util.Scanner;
/*
    Do not modify this main function.
    */
public class Solution {
/**
 * Fill the main function to print the number of 7's between 1 to n.
 *
 * @param      args  The arguments
 */
    public static void main(String[] args) {
        /**
         * input function.
         * @param n Int
         */
        Scanner s=new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        /**
         * initial loop.
         * @param i Int
         */
        for (int i = 7; i <= n; i += 1){
            /**
             * second loop.
             * @param temp Int
             */
            int temp = i;
            while (temp >= 7) {
            /**
             * if statement.
             */
                if (temp % 10 == 7)    count += 1;
                // if (i / 10 == 7)    count += 1;
                temp = temp/10;
            }
        }
        System.out.println(count); 
    }
}