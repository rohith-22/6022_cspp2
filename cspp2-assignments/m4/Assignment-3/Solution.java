
/**
*Given an String.
*Write a java method that returns the decimal.
*value for the given binary string.
*/
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
    * private solution constructor.
    */
   private Solution() {
        /**
         * unused.
         */
    }
    /**
     * main function. 
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**
         * input Scanner.
         * and calls binary to decimal fun is called.
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String res = binaryToDecimal(s);
            System.out.println(res);
        }
    }
    /**
     * { function to convert binary to decimal }.
     * @param      s     { string class }
     * @return     { returns a decimal value }
     */
    static String binaryToDecimal(final String s) {
        /**
         * temp is a temporary integer to store decimal value.
         */
        int temp = 0;
        int k = s.length();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //System.out.println(ch);
            if (ch == '1') {
                temp += pow(2, k - 1);
                //System.out.println(temp);
            }
            k -= 1;
        }
        String b = Integer.toString(temp);
        return b;
    }
    /**
     * { this functio n is used to find  power of integer. }.
     *
     * @param      base   The base. int
     * @param      power  The power, int
     *reccursive method.
     * @return     { returns the power of given integer. }
     */
    static int pow(final int base, final int power) {
        /**
         * { reccursive to find power. }.
         */
        if (power == 0) {
            return 1;
        } else {
            return 2 * pow(base, power - 1);
        }
    }

}
