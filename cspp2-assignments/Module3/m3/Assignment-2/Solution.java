/**
 * imported scanner.
 */
import java.util.Scanner;
/**
*Do not modify this main function.
*/
public final class Solution {
    /**
     * magic numbers.
     */
    static final int SEVEN = 7, TEN = 10;
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
             */
            int temp = i;
            while (temp >= SEVEN) {
            /**
             * if statement.
             */
                if (temp % TEN == SEVEN) {
                    count += 1;
                }
                temp /= (TEN);
            }
        }
        System.out.println(count);
    }
}
