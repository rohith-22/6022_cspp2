/**
 * imported scanner.
 */
import java.util.Scanner;
/**
*Do not modify this main function.
*/
public final class Solution {
/**
 * private constructor.
 */
    private Solution() {
        /**
         * empty constructor.
         */
    }
    /**
    * Fill the main function to print the number of 7's between 1 to n.
    *
    * @param      args  The arguments
    */
    public static void main(final String[] args) {
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
        for (int i = 1; i <= n; i += 1) {
            /**
             * second loop.
             * @param temp Int
             * @param seven Int
             * @param ten Int
             */
            int temp = i;
            int seven = 7;
            int ten = 10;
            while (temp >= seven) {
            /**
             * if statement.
             */
                if (temp % ten == seven) {
                    count += 1;
                }
                temp /= ten;
            }
        }
        System.out.println(count);
    }
}
