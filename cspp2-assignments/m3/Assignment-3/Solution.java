/**
 * imported Scanner.
 */
import java.util.Scanner;
/**
*Do not modify this main function.
*/
public final class Solution {
/**
 * unused.
 */
    private Solution() {
        /**
         * private solution, unused.
         */
    }
    /**
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**
         * Scanner input.
         */
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        //gcd(n1,n2);
        System.out.println(gcd(n1, n2));

    }
    /**
    *Need to write the gcd function and print the output.
    */
    /**
     * { function_description }
     *
     * @param      n1    The n 1
     * @param      n2    The n 2
     * @param      temp  Int
     * @return     { description_of_the_return_value }
     */
    static int gcd(final int n1, final int n2) {
        /**
         * if conditional.
         */
        int temp;
        if (n1 < n2) {
            temp = n2;
        } else {
            temp = n1;
        }
        int r = 1, a = 0;
        while (r <= temp) {
            if (n1 % r == 0 && n2 % r == 0) {
                a = r;
            }
            r += 1;
        }
        return a;
    }
}
