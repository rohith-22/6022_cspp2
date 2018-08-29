/**
 * imported scanner.
 */
import java.util.Scanner;
/*
    Do not modify this main function.
    */
public class Solution {
/**
 * private constructor.
 */
    private Solution(){
        /**
         * empty constructor.
         */
    }
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
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        /**
         * initial loop.
         * @param i Int
         */
        for (int i = 1; i <= n; i += 1){
            /**
             * second loop.
             * @param temp Int
             */
            int temp = i;
            while (temp != 0) {
            /**
             * if statement.
             */
                if (temp % (2 * 5) == 7)    count += 1;
                // if (i / 10 == 7)    count += 1;
                temp /= (2 * 5);
            }
        }
        System.out.println(count); 
    }
}
